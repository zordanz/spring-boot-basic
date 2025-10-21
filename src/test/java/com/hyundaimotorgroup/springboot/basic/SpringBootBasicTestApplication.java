package com.hyundaimotorgroup.springboot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("redis")
public class SpringBootBasicTestApplication {

    static void main(String[] args) {
        SpringApplication.from(SpringBootBasicApplication::main)
            .with(ContainersConfiguration.class)
            .run(args);
    }
}
