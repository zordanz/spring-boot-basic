package com.hyundaimotorgroup.springboot.basic.extconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// FIXME: 3. GET /config/source API로 config source 조회
@RestController
@RequestMapping("/config")
public class ConfigPropertiesController {
    @Value("${spring.config.source}")
    private String configSource;

    @GetMapping("/source")
    public String getConfigSource() {
        return configSource;
    }
}
