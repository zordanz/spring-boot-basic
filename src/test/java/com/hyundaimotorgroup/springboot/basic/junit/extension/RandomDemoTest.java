package com.hyundaimotorgroup.springboot.basic.junit.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @ExtendWith(RandomNumberExtension.class)
class RandomDemoTest {
    private static final Logger log = LoggerFactory.getLogger(RandomDemoTest.class);
    // including @BeforeAll or @AfterAll lifecycle methods.
    @Random
    private static Integer randomNumber0;

    static {
        log.info("randomNumber0: {} in static", randomNumber0);
    }

    // Use randomNumber1 field in test methods and @BeforeEach or @AfterEach lifecycle methods.
    @Random
    private int randomNumber1;

    RandomDemoTest(@Random int randomNumber2) {
        // Use randomNumber2 in constructor.
        log.info("randomNumber0: {} in Constructor", randomNumber0);
        log.info("randomNumber1: {} in Constructor", randomNumber1);
        log.info("randomNumber2: {} in Constructor", randomNumber2);
    }

    @BeforeEach
    void beforeEach(@Random int randomNumber3) {
        // Use randomNumber3 in @BeforeEach method.
        log.info("randomNumber0: {} in beforeEach", randomNumber0);
        log.info("randomNumber1: {} in beforeEach", randomNumber1);
        log.info("randomNumber3: {} in beforeEach", randomNumber3);
    }

    @Test
    void test1(@Random int randomNumber4) {
        log.info("randomNumber0: {} in test1", randomNumber0);
        log.info("randomNumber1: {} in test1", randomNumber1);
        log.info("randomNumber4: {} in test1", randomNumber4);
    }

    @Test
    void test2(@Random int randomNumber4) {
        log.info("randomNumber0: {} in test2", randomNumber0);
        log.info("randomNumber1: {} in test2", randomNumber1);
        log.info("randomNumber4: {} in test2", randomNumber4);
    }
}
