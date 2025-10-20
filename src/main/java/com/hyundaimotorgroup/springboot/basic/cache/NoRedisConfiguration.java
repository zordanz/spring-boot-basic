package com.hyundaimotorgroup.springboot.basic.cache;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = "!redis")
@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.class})
public class NoRedisConfiguration {

}
