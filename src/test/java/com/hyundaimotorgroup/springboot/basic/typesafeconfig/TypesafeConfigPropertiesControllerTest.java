package com.hyundaimotorgroup.springboot.basic.typesafeconfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TypesafeConfigPropertiesController.class)
// TODO 1. TypesafeConfigPropertiesControllerTest는 AppProperties에 의존하고 있습니다. 해당 의존성을 해결하세요
// Hint: @Import
class TypesafeConfigPropertiesControllerTest {

    // TODO 2. mockMvc를 이용해서 테스트를 작성하세요.
    void getOwner_returnsOwnerFromAppProperties(MockMvc mockMvc) throws Exception {
    }
}
