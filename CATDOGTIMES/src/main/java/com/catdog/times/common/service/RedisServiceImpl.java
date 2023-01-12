package com.catdog.times.common.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
    public void setStringValue(String key, List<String> value, Long expTime) {
        redisTemplate.opsForList().rightPush(key, value.get(0));
        redisTemplate.opsForList().rightPush(key, value.get(1));
        redisTemplate.expire(key, expTime, TimeUnit.MILLISECONDS);
    }

	@Override
    public void setStringValue(String key, Object value, Long expTime){
        redisTemplate.opsForList().rightPush(key, value);
        redisTemplate.expire(key, expTime, TimeUnit.MILLISECONDS);
    }

	@Override
    public List<Object> getListValue(String key){
        List<Object> ret = redisTemplate.opsForList().range(key, 0, -1);
        System.out.println(ret);
        return ret;
    }

	@Override
    public void del(String key){
        redisTemplate.delete(key);
    }
}
