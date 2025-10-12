package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

// FIXME: 5. 직렬화 설정. @see JdkSerializationRedisSerializer
public record PersonProperties(@NotEmpty String firstName, @NotEmpty String lastName) implements Serializable {

}
