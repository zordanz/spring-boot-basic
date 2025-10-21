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
// TODO: 1-1. mockMvc가 준비되어야해요. Hint: @AutoConfigure*
// TODO: 1-2. redis 프로필인 경우에만 실행되어야해요.
// TODO: 1-3. redis 컨테이너 설정이 포함되어야해요. ContainersConfiguration
class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    // FIXME: 1-1. E2E테스트를 지향하는 바 Stubbing은 최소화하고 실제 Bean을 이용해요.
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
            // TODO: 1-4 jsonPath를 이용해서 응답 JSON도 테스트해요.
            ;
    }
}