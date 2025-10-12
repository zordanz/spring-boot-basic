package com.hyundaimotorgroup.springboot.basic;

import org.springframework.boot.SpringApplication;

// FIXME: 3. SpringBootBasicApplication을 확장하여 TestApplication 설정
public class SpringBootBasicTestApplication {
    // TODO: 2. 애플리케이션 실행 시 "redis" 프로필 활성화!!(중요)
    static void main(String[] args) {
        SpringApplication.from(SpringBootBasicApplication::main)
            .with(ContainersConfiguration.class)
            .run(args);
    }
}
