package com.hyundaimotorgroup.springboot.basic.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StandardTests {
    private static final Logger log = LoggerFactory.getLogger(StandardTests.class);

    @BeforeAll
    static void initAll() {
        log.info("initAll @BeforeAll");
    }

    @AfterAll
    static void tearDownAll() {
        log.info("tearDownAll @AfterAll");
    }

    @BeforeEach
    void init() {
        log.info("init @BeforeEach");
    }

    @Test
    void succeedingTest() {
        log.info("succeedingTest");
    }

    @Test
    void failingTest() {
        log.info("failingTest");
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
        log.info("skippedTest");
    }

    @Test
    void abortedTest() {
        log.info("abortedTest");
        assumeTrue("abc".contains("Z"));
        log.info("abortedTest");
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown @AfterEach");
    }
}
