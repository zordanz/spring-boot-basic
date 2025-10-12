package com.hyundaimotorgroup.springboot.basic.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrintCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            log.info("No application arguments provided");
            return;
        }
        for (String arg : args) {
            log.info("arg: {}", arg);
        }
    }
}
