package com.hyundaimotorgroup.springboot.basic;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfiguration {

    /**
     * @ServiceConnection 설명
     * - Spring Boot 3.1+에서 Testcontainers로 띄운 컨테이너가 실제 애플리케이션의 "서비스 연결 정보(ConnectionDetails)"가
     *   되도록 자동으로 연동해 주는 애노테이션입니다.
     * - 아래 RedisContainer 빈에 붙이면, 컨테이너가 기동될 때 Spring Boot가 Redis 연결 정보를 자동으로 감지하여
     *   spring.data.redis.*(host/port/password 등) 또는 ConnectionDetails( RedisConnectionDetails ) 빈으로 주입합니다.
     * - 별도의 @DynamicPropertySource, TestPropertyValues, application-*.properties 설정 없이도
     *   테스트/로컬 실행에서 컨테이너의 주소와 포트가 자동으로 적용됩니다.
     *
     * 동작 방식 요약
     * - 컨테이너를 Bean으로 등록하거나(@Bean) JUnit @Container로 선언하고 @ServiceConnection을 붙이면,
     *   Spring Boot가 해당 컨테이너 타입(PostgreSQL, MySQL, Redis, RabbitMQ 등)을 인식해 ConnectionDetails를 구성합니다.
     * - 동일한 서비스 타입이 여러 개 있으면 name 속성으로 구분할 수 있습니다. (예: @ServiceConnection(name = "readOnly"))
     *
     * 이 클래스의 Context
     * - @RestartScope: DevTools 사용 시 애플리케이션 재시작에도 컨테이너 인스턴스를 재사용하여 속도를 높입니다.
     * - @Profile("redis"): redis 프로파일에서만 컨테이너가 올라오도록 제한합니다.
     * - 결과적으로, redis 프로파일로 테스트/로컬 실행 시 redis:6.2.6 컨테이너가 자동 기동되고
     *   ProductService 등에서 필요한 Redis 연결 정보가 자동으로 주입됩니다.
     *
     * 참고: https://docs.spring.io/spring-boot/reference/testing/testcontainers.html#testing.testcontainers.service-connections
     */
    @Profile(value = "redis")
    @Bean
    @RestartScope   // DevTools를 이용해서 Redis 컨테이너 인스턴스 유지
    @ServiceConnection
    public RedisContainer redisContainer() {
        return new RedisContainer(DockerImageName.parse("redis:6.2.6"));
    }
}
