package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(PersonProperties owner, PersonProperties manager) {
}
