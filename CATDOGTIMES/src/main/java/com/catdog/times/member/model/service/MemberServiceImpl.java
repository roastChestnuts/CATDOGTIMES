package com.catdog.times.member.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catdog.times.member.model.dto.Member;
import com.catdog.times.member.model.mapper.MemberMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member findMemberById(String id) {
		return mapper.selectMemberById(id);
	}
	
	@Override
	public Member login(String id, String password) {
		Member member = null;
//		System.out.println(id);
//		System.out.println(password);
		member = this.findMemberById(id);
		
//		System.out.println(member);
		if(member != null && passwordEncoder.matches(password, member.getPassword())) {
			return member;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public int save(Member member) {
		int result = 0;
		
		if(member.getNo() != 0) {
			//// update
			//result = mapper.updateMember(member);
		} else {
			// insert
			member.setPassword(passwordEncoder.encode(member.getPassword()));
			
			result = mapper.insertMember(member);
		}
		
		return result;
	}
	//아이디 중복체크
	@Override
	public int idCheck(String id) {
		int cnt = mapper.idCheck(id);
		return cnt;
	}
	//닉네임 체크
	@Override
	public int nickNameCheck(String nickName) {
		int cnt = mapper.nickNameCheck(nickName);
		return cnt;
	}	
	
	//카카오로그인
    @Override
    public String kakaoJoin(Member member) {
    	member.setPassword(passwordEncoder.encode(member.getSnsId()));
        String no = mapper.kakaoInsert(member);
        log.info("userid:: " + member.getId());
        return no;
    }

    @Override
    public Member kakaoLogin(String memberSnsId) {
        log.info("snsId:: " + memberSnsId);
        return mapper.kakaoSelect(memberSnsId);
    }
	//네이버로그인
    @Override
    public void naverJoin(Member member) {
    	member.setPassword(passwordEncoder.encode(member.getSnsId()));
        mapper.naverInsert(member);
        String memberId = member.getId();
        log.info("userid:: " + memberId);
    }

    @Override
    public Member naverLogin(String memberSnsId) {
        log.info("snsId:: " + memberSnsId);
        return mapper.naverSelect(memberSnsId);
    }
    
    @Override
    public String findMemberBySnsId(String memberSnsId) {
        log.info("snsId:: " + memberSnsId);
        return mapper.findMemberBySnsId(memberSnsId);
    }
    
    @Override
    public String findMemberByEmail(String memberEmail) {
        log.info("snsId:: " + memberEmail);
        return mapper.findMemberByEmail(memberEmail);
    }
    
    //기등록 동물번호인지 체크
	@Override
	public int checkAnimalNumber(String animalRegNo) {
		log.info("snsId:: " + animalRegNo);
        return mapper.checkAnimalNumber(animalRegNo);
	}
    
	//동물 등록번호 업데이트
    @Override
    public int updateAnimalNumber(Member member) throws Exception{
        log.info("snsId:: " + member.getAnimalRegNo());
    	
        Map<String, String> animalPageCookie = this.animalPageCookie();
        String WMONID = animalPageCookie.get("WMONID");
        String JSESSIONID_FRONT7 = animalPageCookie.get("JSESSIONID_FRONT7");
        
        
    	ObjectMapper objectMapper = new ObjectMapper();
		URL url = new URL("https://www.animal.go.kr/front/awtis/record/recordConfirmDtl.do;");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		httpConn.setRequestMethod("POST");

		httpConn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
		httpConn.setRequestProperty("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		httpConn.setRequestProperty("Connection", "keep-alive");
		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		httpConn.setRequestProperty("Cookie", "WMONID="+ WMONID +"; JSESSIONID_FRONT7="+JSESSIONID_FRONT7);
		httpConn.setRequestProperty("Origin", "https://www.animal.go.kr");
		httpConn.setRequestProperty("Referer", "https://www.animal.go.kr/front/awtis/record/recordConfirmList.do?menuNo=2000000011");
		httpConn.setRequestProperty("Sec-Fetch-Dest", "empty");
		httpConn.setRequestProperty("Sec-Fetch-Mode", "cors");
		httpConn.setRequestProperty("Sec-Fetch-Site", "same-origin");
		httpConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
		httpConn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		httpConn.setRequestProperty("sec-ch-ua", "\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"");
		httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
		httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");

		httpConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
		writer.write("sOwnerState=owner&searchOwnerKeyword="+member.getName()+"&sRfidState=drn&searchRfidKeyword="+member.getAnimalRegNo());
		writer.flush();
		writer.close();
		httpConn.getOutputStream().close();

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		
		//json -> map변환 {"data":{"bgroup":"","kindCd":...}}
		Map<String, Object> dataCheck = objectMapper.readValue(response, Map.class);
		
		if(dataCheck.get("data") == (Object)0) {
			return 0; //조회 실패
		}else {
			//data에 해당하는 value부분만 String으로 변환 후 다시 map으로 변환
			Map<String, Object> data = objectMapper.readValue(objectMapper.writeValueAsString(dataCheck.get("data")), Map.class);
			//System.out.println(data.get("dogRegNo"));
			return mapper.updateAnimalNumber(member);
		}
    }
    
    @Override
    //동물보호관리시스템 홈페이지에서 요청시 필요한 쿠키값 리턴해주는 메서드
    public Map<String, String> animalPageCookie() throws IOException{
    	Connection.Response animalPageResponse = Jsoup.connect("https://www.animal.go.kr/front/awtis/record/recordConfirmList.do?")
									                 .timeout(3000)
									                 .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
									                 .header("Upgrade-Insecure-Requests", "1")
									                 .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
									                 .header("sec-ch-ua", "Not?A_Brand;v=8, Chromium;v=108, Google Chrome;v=108")
									                 .header("sec-ch-ua-mobile", "?0")
									                 .header("sec-ch-ua-platform", "Windows")
									                 .method(Connection.Method.GET)
 									                 .execute();
    	Map<String, String> animalPageCookie = animalPageResponse.cookies();
    	return animalPageCookie;
    }

}
