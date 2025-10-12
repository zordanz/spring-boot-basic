package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// FIXME: 2. Owner -> App으로 변경
@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppConfiguration {
}
