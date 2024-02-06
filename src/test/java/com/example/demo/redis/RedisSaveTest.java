package com.example.demo.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class RedisSaveTest {

    @Autowired
    private RedisTemplateList redisTemplateList;

    @Autowired
    private RedisTemplateString redisTemplateString;

    @Autowired
    private HashOperationsMap hashOperationsMap;

    @Autowired
    private RedisTemplateSets redisTemplateSets;

    @Test
    void saveStringType() {

        String KEY = "COFFEE";

        /** save **/
        redisTemplateString.saveStringType(KEY, "LATTE");

        /** read **/
        String value = redisTemplateString.getStringType(KEY);

        /** check **/
        Assertions.assertEquals("LATTE", value);

        /** delete **/
        redisTemplateString.deleteStringType(KEY);

    }

    @Test
    void testListRight() {

        String KEY = "LIST_1";

        /** save **/
        redisTemplateList.saveListRightPush(KEY, List.of("TEST1", "TEST2", "TEST3"));

        /** read **/
        List<String> list = redisTemplateList.getList(KEY);

        /** check **/
        Assertions.assertEquals(3, list.size());

        /** delete **/
        redisTemplateList.deleteList(KEY);
    }

    @Test
    void testListLeft() {

        String KEY = "LIST_2";

        /** save **/
        redisTemplateList.saveListLeftPush(KEY, List.of("TEST5", "TEST6", "TEST7"));

        /** read **/
        List<String> list = redisTemplateList.getList(KEY);

        /** check **/
        Assertions.assertEquals(3, list.size());

        /** delete **/
        redisTemplateList.deleteList(KEY);

    }

    @Test
    void testMap() {

        String KEY = "MAP_1";
        Map<String, String> saveMap = Map.of("KEY1", "VALUE1", "KEY2", "VALUE2");

        /** save **/
        hashOperationsMap.saveMap(KEY, saveMap);

        /** read **/
        Map<String, String> readMap = hashOperationsMap.getMap(KEY);

        /** check **/
        Assertions.assertEquals("VALUE1", readMap.get("KEY1"));
        Assertions.assertEquals("VALUE2", readMap.get("KEY2"));

        /** delete **/
        hashOperationsMap.deleteMap(KEY);

    }

    @Test
    void testSet() {

        String KEY = "SET_1";

        /** save **/
        redisTemplateSets.addToSet(KEY, "VALUE1", "VALUE2", "VALUE3");

        /** read **/
        var members = redisTemplateSets.getMembers(KEY);

        /** check **/
        Assertions.assertEquals(3, members.size());

        /** delete **/
        redisTemplateSets.removeFromSet(KEY, "VALUE1", "VALUE2", "VALUE3");
    }
}