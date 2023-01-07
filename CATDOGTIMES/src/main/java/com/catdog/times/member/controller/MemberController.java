package com.catdog.times.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.catdog.times.member.model.dto.Member;
import com.catdog.times.member.model.dto.User;
import com.catdog.times.member.model.service.JwtServiceImpl;
import com.catdog.times.member.model.service.KaKaoServiceImpl;
import com.catdog.times.member.model.service.MailSendService;
import com.catdog.times.member.model.service.MemberService;
import com.catdog.times.member.model.service.SnsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
// 해당 객체를 세션 스코프까지 확장하는 어노테이션
@SessionAttributes({"loginMember", "kakaoToken"})
public class MemberController {
	@Autowired
	private MemberService service;
	
	@Autowired
	private MailSendService mailService;
	
	@Autowired
	@Qualifier("kaKaoServiceImpl")
    private SnsService kakaoService;
	
	@Autowired
	JwtServiceImpl jwtService;
	
	
    @GetMapping("/member/login")
    public String loginpage() {
        log.info("로그인 페이지 요청");

        return "member/sign_in"; 
    }
	
//	@PostMapping("/member/login")
//	public ModelAndView login(ModelAndView model,
//				@RequestParam("id") String userId, @RequestParam("password") String userPwd) {	
//		
//		log.info("{}, {}", userId, userPwd);
//		
//		Member loginMember = service.login(userId, userPwd);
//		
//		if(loginMember != null) {
//			model.addObject("loginMember", loginMember);
//			model.setViewName("redirect:/");
//		} else {
//			model.addObject("msg", "아이디나 비밀번호가 일치하지 않습니다.");
//			model.addObject("location", "/member/login");
//			model.setViewName("common/msg");			
//		}		
//		
//		return model;
//	}
	@PostMapping("/member/login")
	public Object login(ModelAndView model,
				@RequestParam("id") String userId, @RequestParam("password") String userPwd) {	
		
		log.info("{}, {}", userId, userPwd);
		
		Map<String, Object> map = new HashMap<>();
		
		Member loginMember = service.login(userId, userPwd);
		
		if(loginMember != null) {
			model.addObject("loginMember", loginMember);
			User user = new User(loginMember.getId(), loginMember.getName(), loginMember.getType());
			Map<String, String> tokenMap = jwtService.createToken(user);
			String accessToken = tokenMap.get("accessToken");
			String refreshToken = tokenMap.get("refreshToken");
			Cookie cookie = new Cookie("token", accessToken);
			cookie.setMaxAge(60*60*24); //하루
			
			return ResponseEntity.status(HttpStatus.FOUND)
		             .header("Location", "http://localhost:3000/post")
		             .body(cookie);
		} else {
			model.addObject("msg", "아이디나 비밀번호가 일치하지 않습니다.");
			model.addObject("location", "/member/login");
			model.setViewName("common/msg");
			return model;
		}		

	}
	
	@GetMapping("/member/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete(); // 세션 스코프로 확장된 객체들을 지워준다.
		
		return "redirect:/";
	}
	
	@PostMapping("/member/sign_up")
	public ModelAndView enroll(ModelAndView model, @ModelAttribute Member member) {
		log.info(member.toString());
		
		int result = 0;
		
		result = service.save(member);
		
		if(result > 0) {
			model.addObject("msg", "회원가입이 완료되었습니다.");
		} else {
			model.addObject("msg", "회원가입을 실패하였습니다.");
		}
		model.addObject("location", "/member/login");
		
		model.setViewName("common/msg");
		
		return model;
	}
	//아이디 중복체크
	@PostMapping("/member/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		int cnt = service.idCheck(id);
		return cnt;
	}
	//이메일 인증
	@PostMapping("/member/mailCheck")
	@ResponseBody
	public String mailCheck(@RequestParam("email") String email) {
		System.out.println(email);
		return mailService.joinEmail(email);
	}
	//닉네임 중복체크
	@PostMapping("/member/nickNameCheck")
	@ResponseBody
	public int nickNameCheck(@RequestParam("nickName") String nickName) {
		
		int cnt = service.nickNameCheck(nickName);
		return cnt;
	}
	
	//모달 호출(개인정보)
    @GetMapping("/member/privacyModal")
    public String privacyModal() {
        return "common/privacy";
    }
	//모달 호출(이용약관)
    @GetMapping("/member/termconditionsModal")
    public String termconditionsModal() {
        return "common/termconditions";
    }
    
	// 카카오 로그인
	@GetMapping("/member/kakaoLogin")
	public ModelAndView redirectkakao(ModelAndView model, @RequestParam String code, HttpSession session)
			throws IOException {
		// 접속토큰 get
		String kakaoToken = kakaoService.getReturnAccessToken(code);

		// 접속자 정보 get
		Map<String, Object> result = kakaoService.getUserInfo(kakaoToken);
		log.info("result:: " + result);
		String snsId = (String) result.get("id");
		String nickName = (String) result.get("nickname");
		String email = (String) result.get("email");
		String gender = "female".equals((String) result.get("gender")) ? "W" : "M";

		// 분기
		Member member = new Member();

		// 일치하는 snsId 없을 시 회원가입
		if (service.kakaoLogin(snsId) == null) {
			log.warn("카카오로 회원가입");
			member.setId(email);
			member.setEmail(email);
			member.setNickName(nickName);
			member.setSnsId(snsId);
			member.setGender(gender);
			service.kakaoJoin(member);

			model.addObject("loginMember", member);
		} else {
			// 일치하는 snsId가 있으면 멤버객체에 담음.
			log.warn("카카오로 로그인");
			String MemberId = service.findMemberBySnsId(snsId);
			Member dto = service.findMemberById(MemberId);
			log.warn("member:: " + dto);
			model.addObject("loginMember", dto);
		}

		/* 로그아웃 처리 시, 사용할 토큰 값 */
		model.addObject("kakaoToken", kakaoToken);
		
		model.setViewName("redirect:/");
		return model;
	}
	//네이버 로그인 콜백(성공시 요청 - 데이터를 받는 곳)
	@RequestMapping("/member/naverLogin")
	public String naver() {
		return "common/naverCallBack";
	}
	
	@PostMapping("/member/naverSave")
	public @ResponseBody String naverSave(ModelAndView model, @RequestBody Member memberDto) {
		String result;
		if(memberDto == null) { //넘어온 값이 null이라면 로그인 실패니까
			result = "no";
		}else {
			String snsId = memberDto.getSnsId();
			String email = memberDto.getEmail();
			
			// 일치하는 snsId 없을 시 회원가입
			if (service.naverLogin(snsId) == null) {
				log.warn("네이버로 회원가입");
				memberDto.setId(email);
				service.naverJoin(memberDto);
	
				model.addObject("loginMember", memberDto);
			} else {
				// 일치하는 snsId가 있으면 멤버객체에 담음.
				log.warn("네이버로 로그인");
				String MemberId = service.findMemberBySnsId(snsId);
				Member dto = service.findMemberById(MemberId);
				log.warn("member:: " + dto);
				model.addObject("loginMember", dto);
			}
			result = "ok";
		}
	
		return result;
	}
	
//    @GetMapping("/member/kakaoLogin")
//    public String redirectkakao(@RequestParam String code, HttpSession session) throws IOException {
//        // 접속토큰 get
//        String kakaoToken = kakaoService.getReturnAccessToken(code);
//
//        // 접속자 정보 get
//        Map<String, Object> result = kakaoService.getUserInfo(kakaoToken);
//        log.info("result:: " + result);
//        String snsId = (String) result.get("id");
//        String nickName = (String) result.get("nickname");
//        String email = (String) result.get("email");
//        String pw = snsId;
//        String gender = "female".equals((String)result.get("gender")) ? "W" : "M";
//        
//        // 분기
//        Member member = new Member();
//        
//        // 일치하는 snsId 없을 시 회원가입
//        System.out.println("snsId : " + service.kakaoLogin(snsId));
//        if (service.kakaoLogin(snsId) == null) {
//            log.warn("카카오로 회원가입");
//            member.setId(email);
//            member.setEmail(email);
//            member.setPassword(pw);
//            member.setNickName(nickName);
//            member.setSnsId(snsId);
//            member.setGender(gender);
//            service.kakaoJoin(member);
//
//            session.setAttribute("loginMember", member);
//        } else {
//        	// 일치하는 snsId가 있으면 멤버객체에 담음.
//            log.warn("카카오로 로그인");
//            String MemberId = service.findMemberBySnsId(snsId);
//            Member dto = service.findMemberById(MemberId);
//            log.warn("member:: " + dto);
//            session.setAttribute("loginMember", dto);
//        }
//        
//        /* 로그아웃 처리 시, 사용할 토큰 값 */
//        session.setAttribute("kakaoToken", kakaoToken);
//
//        return "redirect:/";
//    }
}
