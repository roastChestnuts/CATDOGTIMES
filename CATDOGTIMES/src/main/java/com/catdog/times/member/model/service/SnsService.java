package com.catdog.times.member.model.service;

import java.util.Map;

public interface SnsService {
	public String getReturnAccessToken(String code);
	public Map<String,Object> getUserInfo(String access_token);
}
