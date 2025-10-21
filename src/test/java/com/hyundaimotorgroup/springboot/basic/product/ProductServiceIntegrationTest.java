package com.hyundaimotorgroup.springboot.basic.product;

import com.hyundaimotorgroup.springboot.basic.ContainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// FIXME: 2. ProductServiceIntegrationTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("redis")
@Import(ContainersConfiguration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

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

        // Assert - find after delete throws
        RuntimeException ex = assertThrows(RuntimeException.class, () -> productService.findById(id));
        assertTrue(ex.getMessage().contains("Product not found"));
    }
}
