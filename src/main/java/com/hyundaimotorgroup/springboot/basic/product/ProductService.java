package com.hyundaimotorgroup.springboot.basic.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Profile(value = "redis")
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    @Transactional
    public Product create(Product product) {
        return repository.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void remove(String id) {
        repository.deleteById(id);
    }
}
