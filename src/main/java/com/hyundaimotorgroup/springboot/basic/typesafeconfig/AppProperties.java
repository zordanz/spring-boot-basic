package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import jakarta.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@ConfigurationProperties(prefix = "app")
// FIXME: 2. @Validated, @Valid 애노테이션으로 유효성 체크
@Validated
public record AppProperties(@Valid PersonProperties owner,
                            @Valid PersonProperties manager,
                            // FIXME: 3. staffs 추가
                            @Valid Map<String, PersonProperties> staffs
) {
}
