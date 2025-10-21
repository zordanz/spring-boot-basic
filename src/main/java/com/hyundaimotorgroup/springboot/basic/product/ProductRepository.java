package com.hyundaimotorgroup.springboot.basic.product;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

// FIXME: 1-2. ProductRepository on Redis
public interface ProductRepository extends KeyValueRepository<Product, String> {
}
