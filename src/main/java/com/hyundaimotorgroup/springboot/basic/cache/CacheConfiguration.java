package com.hyundaimotorgroup.springboot.basic.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// FIXME: 4-1. redis 프로필 시 캐시 설정 추가
@Profile(value = "redis")
@Configuration(proxyBeanMethods = false)
@EnableCaching
public class CacheConfiguration {

}
