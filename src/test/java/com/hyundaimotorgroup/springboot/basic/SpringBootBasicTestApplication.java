package com.hyundaimotorgroup.springboot.basic;

import org.springframework.boot.SpringApplication;

public class SpringBootBasicTestApplication {

    static void main(String[] args) {
        SpringApplication.from(SpringBootBasicApplication::main)
            .with(ContainersConfiguration.class)
            .run(args);
    }
}
