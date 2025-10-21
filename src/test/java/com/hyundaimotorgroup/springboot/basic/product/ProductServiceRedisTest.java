package com.hyundaimotorgroup.springboot.basic.product;

import com.hyundaimotorgroup.springboot.basic.ContainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

// TODO: 1. spring-data-redis 와 cache 관련 설정을 가진 Test Slice 애노테이션을 위치시켜 주세요.
// Hint: @Data*********
// TODO: 2. 본 TestContext에 ContainersConfiguration와 중첩된 Config 설정을 포함해주세요.
// Hint: @Import(......)
@ActiveProfiles("redis")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceRedisTest {

    @TestConfiguration
    public static class Config {
        // TODO: 1. ProductService Bean을 등록하세요. @DataRedisTest 로 인해 ProductRepository Bean은 준비되어 있습니다.
        // Hint: @Bean, return new ProductService(productRepository)
        // 주의: ProductService를 Mock 객체로 만들지 않습니다.
    }

    @Autowired
    private ProductService productService;

    // FIXME: 1. 코드는 기존 ProductServiceIntegrationTest 과 동일합니다.
    @Test
    @DisplayName("ProductService create/find/remove integration with Redis")
    void createFindRemoveProduct() {
        // Arrange
        String id = UUID.randomUUID().toString();
        Product toCreate = new Product(
            id,
            "Keyboard",
            "Mechanical keyboard",
            new BigDecimal("129.99"),
            LocalDateTime.now()
        );

        // Act - create
        Product saved = productService.create(toCreate);

        // Assert - created product returned
        assertNotNull(saved);
        assertEquals(id, saved.getId());
        assertEquals("Keyboard", saved.getName());

        // Act - find by id
        Product found = productService.findById(id);

        // Assert - found matches
        assertEquals(saved.getId(), found.getId());
        assertEquals(saved.getName(), found.getName());
        assertEquals(saved.getDescription(), found.getDescription());
        assertEquals(saved.getPrice(), found.getPrice());

        // Act - remove
        productService.remove(id);

        // Assert - find after returns null
        assertNotNull(productService.findById(id));
    }
}
