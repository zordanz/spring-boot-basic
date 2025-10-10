package com.hyundaimotorgroup.springboot.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class LifeCycleListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("event : {}", event);
        if (event instanceof AvailabilityChangeEvent ace) {
            log.info(" - state: {}", ace.getState());
        }
    }
}
