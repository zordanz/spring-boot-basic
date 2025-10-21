package com.hyundaimotorgroup.springboot.basic.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;


// FIXME: 1-1. Product
@Getter
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdAt;
}
