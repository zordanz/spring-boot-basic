package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import jakarta.validation.constraints.NotEmpty;

// FIXME: 4. @NotEmpty 애노테이션으로 유효성 체크 추가
public record PersonProperties(@NotEmpty String firstName, @NotEmpty String lastName) {

}
