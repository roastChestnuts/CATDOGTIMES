package com.catdog.times.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.catdog.times.member.controller.MemberController;
import com.catdog.times.member.model.service.JwtServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@PropertySource("classpath:jwt.properties")
public class JwtInterceptor implements HandlerInterceptor {
	@Value("${jwt.secretkey}")
	private String SECRET_KEY; //서명에 사용할 키
	
	@Value("${jwt.accesstoken}")
	private String ACCESS_TOKEN; //서명에 사용할 키
	
	@Value("${jwt.refreshtoken}")
	private String REFRESH_TOKEN; //서명에 사용할 키
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        log.info("Interceptor Pre / Request Url : " + request.getRequestURI());

		if (request.getMethod().equals("OPTIONS")) {
			log.info("preflight, 통과");
			
			return true;
		}
        
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        String acToken = request.getHeader(ACCESS_TOKEN);// Header를 통해 Token 받기
        String rfToken;
        if(request.getHeader(REFRESH_TOKEN) == null) rfToken = null;
        else rfToken = (String) request.getHeader(REFRESH_TOKEN);

        if(acToken == null || acToken.length() < 24) {// Access 토큰이 없을 때
            map.put("status", 401);
            map.put("msg", "There is no Token");
        }
        else if(rfToken != null){// Access 토큰과 Refresh 토큰이 둘 다 있을 때
            map = jwtService.validRefreshToken(acToken, rfToken);
            if((int) map.get("status") == 200) {
                response.setHeader(REFRESH_TOKEN, rfToken);
                response.setHeader(ACCESS_TOKEN, (String) map.get("token"));  // Access 토큰이 성공적으로 재 발행 되었을 때
                request.setAttribute("userId", map.get("userId"));
            }
        }
        else{// Access 토큰만 있을 때
            String ret = jwtService.decodeToken(acToken, SECRET_KEY);
            if(ret.equals("expire")) {
                map.put("msg", "AccessToken has been expired");
                map.put("status", 401);
            }
            else if(ret.equals("invalid")){
                map.put("msg", "AccessToken is invalid");
                map.put("status", 403);
            }
            else {
                request.setAttribute("userId", ret);
                map.put("status", 200);// AccessToken이 유효할 때
            }
        }
        jsonObject.addProperty("token", (String) map.get("token"));
        jsonObject.addProperty("msg", (String) map.get("msg"));

        response.setStatus((int) map.get("status"));
        if((int) map.get("status") == 200) {
            return true;
        }

        response.getWriter().write(gson.toJson(jsonObject));
        return false;
	}
}