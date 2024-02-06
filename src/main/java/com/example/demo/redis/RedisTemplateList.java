package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RedisTemplate 사용해서  Jave List 관리하기
 */
@Component
public class RedisTemplateList {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * Save List<String> : Right Push
     */
    public void saveListRightPush(String key, List<String> list) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        list.forEach(word -> listOps.rightPush(key, word));
    }

    /**
     * Read List<String> : Left Push
     */
    public void saveListLeftPush(String key, List<String> list) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        list.forEach(word -> listOps.leftPush(key, word));
    }

    /**
     * Read List<String>
     */
    public List<String> getList(String key) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.range(key, 0, -1);
    }

    /**
     * Delete List<String>
     */
    public void deleteList(String key) {
        redisTemplate.delete(key);
    }

}
