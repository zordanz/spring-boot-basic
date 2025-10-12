package com.hyundaimotorgroup.springboot.basic;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.utility.DockerImageName;

// FIXME: 2. Redis Testcontainers 설정
@ActiveProfiles("redis")
@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfiguration {

    @Bean
    @RestartScope   // DevTools를 이용해서 Redis 컨테이너 인스턴스 유지
    @ServiceConnection
    public RedisContainer redisContainer() {
        return new RedisContainer(DockerImageName.parse("redis:6.2.6"));
    }
}
