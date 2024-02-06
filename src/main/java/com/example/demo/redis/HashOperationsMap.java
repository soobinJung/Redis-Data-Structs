package com.example.demo.redis;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * RedisTemplate 사용해서  Map 관리하기
 */
@Component
public class HashOperationsMap {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private HashOperations<String, String, String> hashOperations;


    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    /**
     * Save Map<String, String>
     */
    public void saveMap(String key, Map<String, String> map) {
        hashOperations.putAll(key, map);
    }

    /**
     * Read Map<String, String>
     */
    public Map<String, String> getMap(String key) {
        return hashOperations.entries(key);
    }

    /**
     * Delete Map<String, String>
     */
    public void deleteMap(String key){
        hashOperations.getOperations().delete(key);
    }
}
