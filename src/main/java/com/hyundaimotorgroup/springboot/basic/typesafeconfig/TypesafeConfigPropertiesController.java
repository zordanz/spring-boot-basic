package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class TypesafeConfigPropertiesController {
    private final AppProperties appProperties;

    @GetMapping("/owner")
    public PersonProperties getOwner() {
        // TODO: 2. Owner API 완성하기
        return null;
    }

    @GetMapping("/manager")
    public PersonProperties getManag() {
        // TODO: 3. Manager API 완성하기
        return null;
    }
}
