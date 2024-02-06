
# Spring Data Redis
Spring Data Redis는 Spring Framework에서 제공하는 모듈로, Redis와의 상호작용을 쉽게 만들어주는 고수준의 추상화를 제공합니다. 
이 모듈을 통해 Redis 데이터 액세스 코드를 쉽게 작성할 수 있으며, Redis 지원 데이터 구조와의 작업을 간소화합니다.


### 장점


##### 🚀 효율적인 데이터 관리
Redis의 데이터 구조는 메모리 기반의 고성능 처리를 위해 최적화되어 있으며, 이를 통해 애플리케이션의 데이터 처리 속도와 성능을 개선할 수 있습니다.

##### 🚀 분산 시스템에서의 데이터 공유
Redis는 네트워크를 통해 접근 가능한 분산 데이터 스토어를 제공합니다. 이를 통해 여러 애플리케이션 인스턴스 간에 데이터를 쉽게 공유하고 동기화할 수 있습니다.

##### 🚀 데이터 구조의 확장성과 유연성
Redis는 다양한 데이터 구조를 지원하여, 복잡한 데이터 타입과 다양한 사용 사례를 처리할 수 있는 유연성을 제공합니다. 이는 애플리케이션의 요구 사항에 맞춰 데이터 구조를 선택하고 활용할 수 있게 해줍니다.

##### 🚀 성능 최적화
Redis는 메모리 기반 데이터 저장소로, 집합 연산을 포함한 모든 작업이 매우 빠르게 수행됩니다. 

##### 🚀 간편한 구성과 사용
Spring Data Redis는 Redis 연산을 위한 템플릿과 리포지토리 지원을 제공하여, Redis를 사용하는 데 필요한 부트스트래핑(bootstrap)과 구성을 간소화합니다. 이를 통해 개발자는 보일러플레이트 코드를 최소화하고 더 중요한 비즈니스 로직에 집중할 수 있습니다.

##### 🚀 객체 매핑 지원
Spring Data Redis는 RedisHash와 같은 어노테이션을 통해 객체를 Redis 데이터 구조에 매핑할 수 있는 기능을 제공합니다. 이는 객체를 Redis에 저장하고 조회하는 작업을 간편하게 만들어 줍니다.

##### 🚀 추상화된 데이터 액세스
RedisTemplate과 StringRedisTemplate 클래스를 통해 Redis 명령어를 추상화하고, 다양한 데이터 타입에 대한 연산을 쉽게 수행할 수 있습니다. 이는 Redis의 사용을 단순화하며, 코드의 가독성을 향상시킵니다.

##### 🚀 리액티브 프로그래밍 지원
Spring Data Redis는 리액티브 프로그래밍 모델을 지원하여, 비동기적이고 논블로킹인 데이터 액세스를 가능하게 합니다. 이는 고성능 웹 애플리케이션 개발에 특히 유용합니다.

##### 🚀 집합 연산과 트랜잭션 지원
Redis의 집합 연산과 트랜잭션 기능을 Spring Data Redis를 통해 사용할 수 있으며, 이를 통해 복잡한 데이터 처리 로직을 구현할 수 있습니다.

### 단점
##### 🚀 메모리 사용량
Redis는 인메모리 데이터 스토어이기 때문에, 대규모 데이터 세트를 관리할 때 메모리 사용량을 주의 깊게 관리해야 합니다. 특히, 큰 크기의 객체를 집합에 저장하는 경우 메모리 사용량이 증가할 수 있습니다.

##### 🚀 학습 곡선
Spring Data Redis와 같은 고수준의 추상화를 제공하는 라이브러리는 사용 방법을 익히기 위한 초기 학습 곡선이 있습니다. Redis 자체의 기능뿐만 아니라 Spring Data Redis의 추상화된 API에 대한 이해가 필요합니다.

##### 🚀 성능 고려 사항
RedisTemplate 사용 시 직렬화와 역직렬화 과정에서 오버헤드가 발생할 수 있으며, 이는 대량의 데이터 처리 시 성능 저하를 일으킬 수 있습니다. 특히, 커스텀 직렬화 방법을 사용하지 않는 경우 Java의 기본 직렬화 방식이 성능에 부정적인 영향을 미칠 수 있습니다.

##### 🚀 의존성 관리
Spring Data Redis를 사용하려면 Spring 프레임워크에 대한 의존성이 필요합니다. 이미 Spring을 사용하는 프로젝트에서는 문제가 되지 않지만, 그렇지 않은 경우 프로젝트에 추가적인 의존성을 가져옵니다.

##### 🚀 버전 호환성
Spring Data Redis 라이브러리의 버전이 Redis 서버 버전과 정확히 호환되어야 합니다. 때로는 Redis의 새로운 기능을 사용하기 위해 Spring Data Redis의 최신 버전으로 업그레이드해야 할 수도 있으며, 이 과정에서 의존성 관련 문제가 발생할 수 있습니다. 따라서, 프로젝트에서 사용하는 Redis 서버의 버전과 Spring Data Redis 라이브러리의 버전을 주의 깊게 관리해야 합니다.

##### 🚀 복잡한 쿼리 지원 제한
Redis는 주로 키-값 저장소로 설계되었기 때문에, SQL 데이터베이스처럼 복잡한 쿼리를 지원하지 않습니다. Spring Data Redis도 이러한 한계를 가지고 있으며, 복잡한 데이터 검색이나 조건부 쿼리를 구현하기 위해서는 추가적인 로직이 필요할 수 있습니다.

##### 🚀 데이터 모델링 제약
Redis와 Spring Data Redis는 유연한 데이터 모델링을 지원하지만, 관계형 데이터베이스에서 제공하는 외래 키나 조인 같은 기능은 제공하지 않습니다. 따라서, 관계형 데이터 모델을 Redis에 적용하려고 할 때 설계상의 고려가 필요합니다.


# RedisTemplate
RedisTemplate은 Spring Data Redis에서 제공하는 중앙 클래스로, Redis와의 상호작용을 위한 고수준 추상화를 제공합니다. 
RedisTemplate은 연결 관리, 직렬화, Redis 명령 실행 등을 처리합니다.

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

### 장점
##### 🚀 구조화된 데이터 저장
HashOperations를 사용하면 복잡한 구조의 데이터를 Redis에서 효율적으로 관리할 수 있습니다. 
객체의 속성을 필드-값 쌍으로 저장하여, 데이터 구조의 무결성을 유지하며 관리할 수 있습니다.

##### 🚀 메모리 효율성
Redis 해시는 여러 필드와 값 쌍을 하나의 키 아래에 저장할 수 있어 메모리 사용량을 최적화할 수 있습니다. 
이는 특히 작은 데이터 구조를 대량으로 저장할 때 유용합니다.

##### 🚀 데이터 접근 최적화
해시 연산을 통해 개별 필드에 대한 접근, 수정, 삭제가 가능합니다. 이는 전체 데이터 구조를 가져온 후 수정하고 다시 저장하는 것보다 훨씬 효율적입니다.

### 단점
##### 🚀 복잡성
Redis 해시를 통해 복잡한 객체를 저장하고 관리할 때, 객체의 직렬화와 역직렬화 과정이 필요할 수 있습니다. 
이는 추가적인 코드 작성과 성능 고려를 필요로 합니다.

##### 🚀 성능 고려 사항
HashOperations를 사용할 때 내부적으로 직렬화와 역직렬화 처리가 일어납니다. 
이로 인해 대량의 데이터를 처리할 때 성능 저하가 발생할 수 있습니다.
 

## SetOperations
SetOperations는 Spring Data Redis에서 제공하는 인터페이스로, Redis의 집합(Set) 데이터 구조와의 상호작용을 위한 연산을 정의합니다.
Redis의 집합은 중복을 허용하지 않는 문자열의 컬렉션으로, 주로 고유 값의 저장, 멤버십 테스트, 집합 간 연산(교집합, 합집합, 차집합) 등에 사용됩니다. SetOperations를 사용하는 것의 장단점은 다음과 같습니다.

```
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private SetOperations<String, String> setOperations;


    @PostConstruct
    private void init() {
        this.setOperations = redisTemplate.opsForSet();
    } 
```

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

### 단점
##### 🚀 직렬화/역직렬화 오버헤드
복잡한 객체를 집합의 요소로 저장하려면 직렬화가 필요할 수 있으며, 조회 시 역직렬화가 필요합니다. 
이 과정에서 성능 저하가 발생할 수 있습니다.


# Java 자료구조 → Redis 자료구조
Java 애플리케이션에서 사용하는 기본 자료구조를 Redis의 고성능, 분산 데이터 스토리지 시스템으로 효율적으로 옮기고 활용하는 방법에 대한 가이드를 제공합니다. 이 문서는 Spring Data Redis를 활용하여 Java의 String, List, Map, Set 등의 자료구조를 Redis의 String, List, Hash, Set 데이터 구조로 변환하고 관리하는 방법을 설명합니다.
 
## String

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

## List
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

## Map

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

## Set

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

