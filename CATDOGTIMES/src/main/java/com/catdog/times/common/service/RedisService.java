package com.catdog.times.common.service;

import java.util.List;

public interface RedisService {
    public void setStringValue(String key, List<String> value, Long expTime);


    public void setStringValue(String key, Object value, Long expTime);

    public List<Object> getListValue(String key);

    public void del(String key);

}
