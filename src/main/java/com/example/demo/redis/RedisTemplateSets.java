package com.example.demo.redis;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * RedisTemplate 사용해서  Set 관리하기
 */
@Component
public class RedisTemplateSets {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private SetOperations<String, String> setOperations;


    @PostConstruct
    private void init() {
        this.setOperations = redisTemplate.opsForSet();
    }

    /**
     * Save Set<String>
     */
    public void addToSet(String key, String... values) {
        setOperations.add(key, values);
    }

    /**
     * Read Set<String>
     */
    public Set<String> getMembers(String key) {
        return setOperations.members(key);
    }

    /**
     * Delete Set<String>
     */
    public void removeFromSet(String key, String... values) {
        setOperations.remove(key, (Object[])values);
    }

    /**
     * Read Set Size
     */
    public Long setSize(String key) {
        return setOperations.size(key);
    }
}
