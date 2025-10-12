package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO: 1. AppProperties 완성시키기
@ConfigurationProperties(prefix = "app")
public record AppProperties() {
}
