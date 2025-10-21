package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TypesafeConfigPropertiesController.class)
class TypesafeConfigPropertiesControllerMockBeanTest {
    @MockitoBean
    private AppProperties appProperties;

    @Test
    @DisplayName("GET /config/owner returns owner information from AppProperties")
    void getOwner_returnsOwnerFromAppProperties(@Autowired MockMvc mockMvc) throws Exception {
        // Arrange
        PersonProperties owner = new PersonProperties("Jane", "Doe");
        given(appProperties.owner()).willReturn(owner);

        // Act & Assert
        mockMvc.perform(get("/config/owner"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Jane"))
            .andExpect(jsonPath("$.lastName").value("Doe"));
    }
}
