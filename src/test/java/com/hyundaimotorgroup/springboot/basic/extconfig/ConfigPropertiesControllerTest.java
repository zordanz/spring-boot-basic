package com.hyundaimotorgroup.springboot.basic.extconfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ConfigPropertiesController.class)
@TestPropertySource(
    properties = {
        "spring.config.source=test-config"
    })
class ConfigPropertiesControllerTest {
    @Test
    @DisplayName("GET /config/source returns configured source property")
    void getConfigSource_returnsConfiguredValue(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/config/source"))
            .andExpect(status().isOk())
            .andExpect(content().string("test-config"));
    }
}
