package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import jakarta.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@ConfigurationProperties(prefix = "app")
@Validated
public record AppProperties(@Valid @NestedConfigurationProperty PersonProperties owner,
                            @Valid @NestedConfigurationProperty PersonProperties manager,
                            Map<String, @Valid PersonProperties> staffs
) {
}
