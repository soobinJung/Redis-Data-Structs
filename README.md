
# Spring Data Redis
Spring Data Redis는 Spring Framework의 일부로, Redis 데이터베이스와의 효과적인 상호작용을 위한 고수준 추상화 및 편리한 API를 제공하는 모듈입니다. 개발자들은 이를 통해 Redis 데이터 액세스 코드를 간단하게 작성할 수 있으며, 복잡한 Redis 연산을 쉽게 수행할 수 있습니다. 이 모듈은 Redis의 다양한 데이터 구조를 지원하며, 애플리케이션의 성능을 향상시키기 위한 메모리 기반의 데이터 처리와 분산 데이터 관리를 가능하게 합니다.

<br/>

### 장점
##### 🚀효율적인 데이터 관리
메모리 기반의 빠른 데이터 액세스와 처리를 통해 애플리케이션 성능을 향상시킵니다.

##### 🚀분산 데이터 공유
다양한 데이터 구조(String, List, Hash, Set, Sorted Set)를 통해 복잡한 데이터 타입을 효율적으로 관리할 수 있습니다.

##### 🚀리액티브 프로그래밍 지원
리액티브 프로그래밍 모델을 지원하여, 비동기적이고 논블로킹인 데이터 액세스를 가능하게 합니다.

<br/>

### 단점

##### 🚀 메모리 사용량
인메모리 데이터 스토어의 특성 상, 대규모 데이터를 효율적으로 관리하기 위해서는 메모리 용량과 사용량을 신중하게 계획해야 합니다.

##### 🚀 학습 곡선
Spring Data Redis의 고수준 추상화와 Redis 자체의 다양한 기능을 효과적으로 사용하기 위해서는 초기에 학습 곡선이 존재합니다.

##### 🚀 성능 고려 사항
직렬화와 역직렬화 과정이 필요한 작업에서는 성능 최적화를 위해 커스텀 직렬화 전략을 고려해야 할 수 있습니다.

##### 🚀 의존성과 프레임워크 통합
Spring Framework에 대한 의존성이 필요하며, Spring 기반 애플리케이션에서 주로 사용됩니다.

##### 🚀 버전 호환성 및 업그레이드 관리
Redis 서버와 Spring Data Redis 라이브러리 간의 버전 호환성을 관리해야 하며, 때때로 의존성 문제가 발생할 수 있습니다.

##### 🚀 복잡한 쿼리와 데이터 모델링 제약
관계형 데이터베이스처럼 복잡한 쿼리 기능이 제한적이며, 관계형 모델을 Redis에 적용하기 위한 추가적인 설계 고려가 필요합니다.

<br/>

# RedisTemplate
RedisTemplate은 Spring Data Redis에서 제공하는 중앙 클래스로, Redis와의 상호작용을 위한 고수준 추상화를 제공합니다. 
RedisTemplate은 연결 관리, 직렬화, Redis 명령 실행 등을 처리합니다.

<br/>

## HashOperations
HashOperations 인터페이스는 Redis의 Hash 데이터 구조와 상호작용하기 위한 연산을 정의합니다. 
이를 통해 개발자는 Hash 타입의 데이터를 쉽게 저장, 검색, 삭제할 수 있습니다.

```
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private HashOperations<String, String, String> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }
```

<br/>

### 장점
##### 🚀 구조화된 데이터 저장
HashOperations를 사용하면 복잡한 구조의 데이터를 Redis에서 효율적으로 관리할 수 있습니다. 
객체의 속성을 필드-값 쌍으로 저장하여, 데이터 구조의 무결성을 유지하며 관리할 수 있습니다.

##### 🚀 메모리 효율성
Redis 해시는 여러 필드와 값 쌍을 하나의 키 아래에 저장할 수 있어 메모리 사용량을 최적화할 수 있습니다. 
이는 특히 작은 데이터 구조를 대량으로 저장할 때 유용합니다.

##### 🚀 데이터 접근 최적화
해시 연산을 통해 개별 필드에 대한 접근, 수정, 삭제가 가능합니다. 이는 전체 데이터 구조를 가져온 후 수정하고 다시 저장하는 것보다 훨씬 효율적입니다.

<br/>

### 단점
##### 🚀 복잡성
Redis 해시를 통해 복잡한 객체를 저장하고 관리할 때, 객체의 직렬화와 역직렬화 과정이 필요할 수 있습니다. 
이는 추가적인 코드 작성과 성능 고려를 필요로 합니다.

##### 🚀 성능 고려 사항
HashOperations를 사용할 때 내부적으로 직렬화와 역직렬화 처리가 일어납니다. 
이로 인해 대량의 데이터를 처리할 때 성능 저하가 발생할 수 있습니다.

 <br/>

## SetOperations
SetOperations는 Spring Data Redis에서 제공하는 인터페이스로, Redis의 집합(Set) 데이터 구조와의 상호작용을 위한 연산을 정의합니다.
Redis의 집합은 중복을 허용하지 않는 문자열의 컬렉션으로, 주로 고유 값의 저장, 멤버십 테스트, 집합 간 연산(교집합, 합집합, 차집합) 등에 사용됩니다.

```
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private SetOperations<String, String> setOperations;


    @PostConstruct
    private void init() {
        this.setOperations = redisTemplate.opsForSet();
    } 
```

<br/>

### 장점
##### 🚀 중복 방지
Redis 집합은 중복된 값을 저장하지 않기 때문에, SetOperations를 사용하면 자동으로 중복을 제거하며 데이터를 관리할 수 있습니다. 
이는 고유한 항목의 컬렉션을 관리할 때 매우 유용합니다.

##### 🚀 데이터 관리의 용이성
SetOperations를 통해 제공되는 메소드들은 집합에 데이터를 추가, 삭제, 조회하는 등의 작업을 간단하게 만들어 줍니다. 
이는 코드의 가독성과 유지 보수성을 향상시킵니다.

##### 🚀 집합 연산 지원
Redis 집합은 합집합, 교집합, 차집합 등의 집합 연산을 네이티브하게 지원합니다. 
SetOperations를 사용하면 이러한 연산을 쉽게 수행할 수 있어, 복잡한 데이터 처리 요구 사항을 효율적으로 해결할 수 있습니다.

##### 🚀 성능 최적화
Redis는 메모리 기반 데이터 저장소로, 집합 연산을 포함한 모든 작업이 매우 빠르게 수행됩니다. 
SetOperations를 사용하면 고성능의 데이터 처리가 가능합니다.

<br/>

### 단점
##### 🚀 직렬화/역직렬화 오버헤드
복잡한 객체를 집합의 요소로 저장하려면 직렬화가 필요할 수 있으며, 조회 시 역직렬화가 필요합니다. 
이 과정에서 성능 저하가 발생할 수 있습니다.

<br/>

# Java 자료구조 → Redis 자료구조
Java 애플리케이션에서 사용하는 기본 자료구조를 Redis의 고성능, 분산 데이터 스토리지 시스템으로 효율적으로 옮기고 활용하는 방법에 대한 가이드를 제공합니다. 이 문서는 Spring Data Redis를 활용하여 Java의 String, List, Map, Set 등의 자료구조를 Redis의 String, List, Hash, Set 데이터 구조로 변환하고 관리하는 방법을 설명합니다.

 <br/>
 
## String

```
127.0.0.1:6379> SET key value
OK
127.0.0.1:6379> GET key
"value"
127.0.0.1:6379> DEL key
(integer) 1
127.0.0.1:6379> GET key
(nil)
```


```

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
```

<br/>

## List
- 순서가 있는 데이터 컬렉션을 관리합니다.
- 큐나 스택과 같은 데이터 구조를 구현할 때 유용합니다.

```
127.0.0.1:6379> RPUSH key value1 value2
(integer) 2
127.0.0.1:6379> LPUSH key value3 value4
(integer) 4
127.0.0.1:6379> LRANGE key 0 -1
1) "value4"
2) "value3"
3) "value1"
4) "value2"
127.0.0.1:6379> DEL key
(integer) 1
127.0.0.1:6379> LRANGE key 0 -1
(empty array)
```

```

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
```
<br/>

## Map
- 키-값 쌍의 컬렉션을 저장합니다.
- 객체나 다양한 속성을 가진 데이터를 관리하는 데 적합합니다.

```
127.0.0.1:6379> HSET key field1 value1 field2 value2
(integer) 2
127.0.0.1:6379> HGETALL key
1) "field1"
2) "value1"
3) "field2"
4) "value2"
127.0.0.1:6379> DEL key
(integer) 1
127.0.0.1:6379> HGETALL key
(empty array)
```

```
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

```
<br/>

## Set

- 중복이 없는 요소의 집합을 관리합니다.
- 고유 값의 저장이나 집합 연산에 유용합니다.

```
127.0.0.1:6379> SADD key value1 value2
(integer) 2
127.0.0.1:6379> SMEMBERS key
1) "value1"
2) "value2"
127.0.0.1:6379> SADD key value1 value3
(integer) 1
127.0.0.1:6379> SMEMBERS key
1) "value1"
2) "value2"
3) "value3"
127.0.0.1:6379> SREM key value2
(integer) 1
127.0.0.1:6379> SMEMBERS key
1) "value1"
2) "value3"
127.0.0.1:6379> SCARD key
(integer) 2
```

```
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
```

<br/>

#### Test 코드 첨부
https://github.com/soobinJung/Redis-Data-Structs/blob/main/src/test/java/com/example/demo/redis/RedisSaveTest.java
