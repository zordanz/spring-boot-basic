package com.hyundaimotorgroup.springboot.basic.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Profile("redis")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // FIXME 1: /products/{id} API 확인
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return Optional.ofNullable(productService.findById(id))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product service not found"));
    }
}
