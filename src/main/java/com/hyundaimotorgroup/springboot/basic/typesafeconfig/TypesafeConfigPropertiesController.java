package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class TypesafeConfigPropertiesController {
    private final AppProperties appProperties;

    @GetMapping("/owner")
    public PersonProperties getOwner() {
        return appProperties.owner();
    }

    @GetMapping("/manager")
    public PersonProperties getManager() {
        return appProperties.manager();
    }

    // TODO: 1. API 응답에 캐시 활성화. Hint: @Cacheable
    @Cacheable(value = "staffs", key = "#name")
    @GetMapping("/staffs/{name}")
    public PersonProperties getStaff(@PathVariable String name) {
        return Optional.ofNullable(appProperties.staffs().get(name))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "staff not found"));
    }
}
