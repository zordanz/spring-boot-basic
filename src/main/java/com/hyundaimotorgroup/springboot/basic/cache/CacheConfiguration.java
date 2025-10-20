package com.hyundaimotorgroup.springboot.basic.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = "redis")
@Configuration(proxyBeanMethods = false)
@EnableCaching
public class CacheConfiguration {

}
