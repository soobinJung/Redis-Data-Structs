package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * RedisTemplate 사용해서  String 관리하기
 */
@Component
public class RedisTemplateString {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * Save String
     */
    public void saveStringType(String key, String value) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set(key, value);
    }

    /**
     * Read String
     */
    public String getStringType(String key) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        return stringStringValueOperations.get(key);
    }

    /**
     * Delete String
     */
    public void deleteStringType(String key) {
        redisTemplate.delete(key);
    }
}
