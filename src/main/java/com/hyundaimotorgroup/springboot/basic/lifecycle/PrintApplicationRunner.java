package com.hyundaimotorgroup.springboot.basic.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrintApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        args.getOptionNames().forEach(name ->
            log.info("option: {}={}", name, args.getOptionValues(name)));
    }
}
