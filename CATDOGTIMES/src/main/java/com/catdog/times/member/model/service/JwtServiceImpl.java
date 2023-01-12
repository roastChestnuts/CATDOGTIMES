package com.catdog.times.member.model.service;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.catdog.times.common.service.RedisServiceImpl;
import com.catdog.times.member.model.dto.Member;
import com.catdog.times.member.model.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@PropertySource("classpath:jwt.properties")
public class JwtServiceImpl{
	@Value("${jwt.secretkey}")
	private String SECRET_KEY; //서명에 사용할 키
	
	private long ACCESS_EXP_TIME = 1000L * 60 * 60; // 토큰 사용 가능 시간 1시간
	
	private long REFRESH_EXP_TIME = 1000L * 60 * 60 * 24 * 7; // 리프레시토큰 사용 가능 시간 7일

	@Autowired
	private MemberService memberService;
	
    @Autowired
    private RedisServiceImpl redisService;

	
	// 토큰 생성 메서드
	public Map<String, String> createToken(User user) { // 토큰에 담고싶은 값 파라미터로 가져오기
		System.out.println(SECRET_KEY);
		String accessToken = createAccessToken(user, ACCESS_EXP_TIME, SECRET_KEY);
		String refreshToken = createRefreshToken(REFRESH_EXP_TIME, accessToken);
		
        List<String> userIdAccToken = new ArrayList<>();
        userIdAccToken.add(user.getId());
        userIdAccToken.add(accessToken);
        save(refreshToken, userIdAccToken, REFRESH_EXP_TIME);    // RefreshToken DB에 저장

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("refreshToken", refreshToken);

        return map;
	}
	
	public String createAccessToken(User user, Long expTime, String secretKey) {
		Date now = new Date();
        Date expireTime = new Date(now.getTime() + expTime);
		Key signKey = makeKey(secretKey);
		
		return Jwts.builder()
				   .setHeaderParam("typ", "JWT") // 토큰 타입
				   .setSubject(user.getId()) // 토큰 제목
				   .setIssuedAt(now) //생성일
				   .setExpiration(expireTime) // 토큰 유효시간
				   .claim("user", user) // 토큰에 담을 데이터
				   .signWith(SignatureAlgorithm.HS256, signKey) // secretKey를 사용하여 해싱 암호화 알고리즘 처리
				   .compact(); // 직렬화, 문자열로 변경
	}
	
	
	//리프레시 토큰 생성 메서드
    public String createRefreshToken(Long expTime, String secretKey) {
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + expTime);
        Key signKey = makeKey(secretKey);
        
        return Jwts.builder()
        		   .setSubject("valid")
	               .setIssuedAt(now)
	               .setExpiration(expireTime)
	               .signWith(SignatureAlgorithm.HS256, signKey)
	               .compact();
    }
	
    // signKey 생성
    public Key makeKey(String secretKey){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;       // HS256 암호화 알고리즘 사용
        byte[] securityByte = DatatypeConverter.parseBase64Binary(secretKey);   // String 형태의 키를 Byte 형태로 인코딩
        
        return new SecretKeySpec(securityByte, signatureAlgorithm.getJcaName());   // 암호화된 Key 생성
    }
    
    // 토큰 Validation & Get Subject
    public String decodeToken(String token, String secretKey){
        // 클레임 : Payload 에 들어있는 값
        try{
            Claims claims = Jwts.parser()
                    		    .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                    		    .parseClaimsJws(token)
                    		    .getBody();

            return claims.getSubject();
        }catch(ExpiredJwtException e1){
            e1.printStackTrace();
            return "expire";
        }catch(JwtException e2){
            e2.printStackTrace();
            return "invalid";
        }
    }

    // RefreshToken 받아서 AccessToken 재발행
    public Map<String, Object> validRefreshToken(String accessToken, String refreshToken){
        Map<String, Object> map = new HashMap<>();

        String acUserId = decodeToken(accessToken, SECRET_KEY);    // AccessToken을 통해 userId를 추출한다. -> 만료라면 "expire" 반환
        List<Object> userIdAccToken = find(refreshToken);         // redis로 부터 key(refreshToken)를 통해 userId & First AccessToken(rfToken 복호화에 사용)을 가져온다.

        if(userIdAccToken.size() < 2) {
            map.put("msg", "RefreshToken has been expired");
            map.put("status", 401);
        }
        // RefreshToken 인증은 성공했지만 AccessToken이 만료되지 않은 경우 = AccessToken이 살아있는데 재발급 받으려는 경우 : 발급 불가 반환
        else if(acUserId.equals(userIdAccToken.get(0))) {
            map.put("msg", "AccessToken Already Valid.");
            map.put("status", 403);    // 발급 불가
        }
        // RefreshToken 유효 & AccessToken 유효한 값이지만 만료 => 재발급
        else {
        	Member loginMember = memberService.findMemberById(String.valueOf(userIdAccToken.get(0)));
        	User user = new User(loginMember.getId(), loginMember.getName(), loginMember.getType());
        	
            map.put("token", createAccessToken(user, ACCESS_EXP_TIME, SECRET_KEY));
            map.put("status", 200);
            map.put("msg", "Access Token Updated Complete");
            map.put("userId", userIdAccToken.get(0));
        }

        return map;
    }
    
    // Redis save
    public void save(String token, List<String> userIdAccToken, Long expTime){
        redisService.setStringValue(token, userIdAccToken, expTime);
    }

    // Redis select
    public List<Object> find(String token){
        List<Object> userId = redisService.getListValue(token);
        return userId;
    }

    public void del(String token){
        redisService.del(token);
    }

	// 토큰에 담긴 정보를 가져오기 메서드
//	public Map<String, Object> getInfo(String token) throws Exception {
//		Jws<Claims> claims = null;
//		try {
//			claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token); // secretKey를 사용하여 복호화
//		} catch(Exception e) {
//			throw new Exception();
//		}
//		
//		return claims.getBody();
//	}
    
	// interceptor에서 토큰 유효성을 검증하기 위한 메서드
//	public boolean checkValid(String token) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//	}
}
