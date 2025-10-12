package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppConfiguration {
}
