package com.catdog.times.member.model.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.catdog.times.member.model.dto.jwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl {
	@Value("${jwt.secretkey}")
	private String secretKey; //서명에 사용할 키
	
	private long exp = 1000L * 60 * 60; // 토근 사용 가능 시간 1시간

	// 토큰 생성 메서드
	public String createToken(jwtUser jwtUser) { // 토큰에 담고싶은 값 파라미터로 가져오기
		return Jwts.builder()
				   .setHeaderParam("typ", "JWT") // 토큰 타입
				   .setSubject("userToken") // 토큰 제목
				   .setExpiration(new Date(System.currentTimeMillis() + exp)) // 토큰 유효시간
				   .claim("user", jwtUser) // 토큰에 담을 데이터
				   .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // secretKey를 사용하여 해싱 암호화 알고리즘 처리
				   .compact(); // 직렬화, 문자열로 변경
	}
	
	// 토큰에 담긴 정보를 가져오기 메서드
	public Map<String, Object> getInfo(String token) throws Exception {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token); // secretKey를 사용하여 복호화
		} catch(Exception e) {
			throw new Exception();
		}
		
		return claims.getBody();
	}
	
	// interceptor에서 토큰 유효성을 검증하기 위한 메서드
	public void checkValid(String token) {
		Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
	}
}
