package com.anna.junit5.inheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * - Some annotations on default methods inherited by child classes:
 * @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate, @BeforeEach, @AfterEach
 * - @BeforeAll and @AfterAll are inherited when TestInstance lifecycle is set to Lifecycle.PER_CLASS
 */
public interface ATestInterface {

    @BeforeEach
    default void beforeAll() {
        System.out.println("This is the interface");
    }

    @Test
    default void testSmallerZero() {
        assertTrue(getANumberSmallerZero() < 0);
    }

    int getANumberSmallerZero();
}
