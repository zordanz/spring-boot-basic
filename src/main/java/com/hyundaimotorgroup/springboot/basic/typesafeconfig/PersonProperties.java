package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.owner")
public record PersonProperties(String firstName, String lastName) {

}
