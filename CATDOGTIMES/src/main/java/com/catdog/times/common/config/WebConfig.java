package com.catdog.times.common.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) { // client에서 header추출이 가능하도록 하기 위해 등록
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*")
				.exposedHeaders("ACCESS_TOKEN", "REFRESH_TOKEN"); //url에 담겨서 가니 필요는없음
	}
}
