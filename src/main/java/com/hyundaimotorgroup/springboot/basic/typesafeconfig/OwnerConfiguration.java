package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PersonProperties.class)
public class OwnerConfiguration {
}
