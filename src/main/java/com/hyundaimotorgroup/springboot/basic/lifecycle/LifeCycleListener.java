package com.hyundaimotorgroup.springboot.basic.lifecycle;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//@Component
@SuppressWarnings("rawtypes")
@Slf4j
public class LifeCycleListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(@NonNull ApplicationEvent event) {
        log.info("event : {}", event);
        if (event instanceof AvailabilityChangeEvent ace) {
            log.info(" - state: {}", ace.getState());
        }
    }
}
