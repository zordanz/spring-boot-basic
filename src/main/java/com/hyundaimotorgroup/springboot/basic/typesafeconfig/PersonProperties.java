package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO: 1. @ConfigurationProperties 애노테이션
// TODO: 2. Constructor Binding 으로 완성하기.
public record PersonProperties(String firstName, String lastName) {

}
