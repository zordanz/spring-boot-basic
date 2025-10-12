package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record PersonProperties(@NotEmpty String firstName, @NotEmpty String lastName) {

}
