package com.hyundaimotorgroup.springboot.basic.product;

import com.hyundaimotorgroup.springboot.basic.ContainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("redis")
@Import(ContainersConfiguration.class)
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("GET /products/{id} should return product JSON when exists")
    void getProductById_withExisting_shouldReturnOk() throws Exception {
        // Arrange: create a product in Redis via service
        String id = UUID.randomUUID().toString();
        Product toCreate = new Product(
            id,
            "Keyboard",
            "Mechanical keyboard",
            new BigDecimal("129.99"),
            LocalDateTime.now()
        );
        productService.create(toCreate);

        // Act & Assert
        mockMvc.perform(get("/products/{id}", id))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value("Keyboard"))
            .andExpect(jsonPath("$.description").value("Mechanical keyboard"))
            .andExpect(jsonPath("$.price").value(129.99))
            .andExpect(jsonPath("$.createdAt").exists());
    }
}