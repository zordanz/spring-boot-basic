package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class TypesafeConfigPropertiesController {
    private final PersonProperties personProperties;

    // TODO: 4. PersonProperties 확인
    @GetMapping("/owner")
    public PersonProperties getConfigSource() {
        return personProperties;
    }
}
