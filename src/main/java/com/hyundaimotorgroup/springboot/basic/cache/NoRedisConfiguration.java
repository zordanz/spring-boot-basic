package com.hyundaimotorgroup.springboot.basic.cache;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// FIXME: 4-2. redis 프로필 아닐 시 캐시 설정 제거
@Profile(value = "!redis")
@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.class})
public class NoRedisConfiguration {

}
