package com.hyundaimotorgroup.springboot.basic.product;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface ProductRepository extends KeyValueRepository<Product, String> {
}
