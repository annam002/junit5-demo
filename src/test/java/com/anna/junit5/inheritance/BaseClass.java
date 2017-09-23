package com.anna.junit5.inheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class BaseClass implements ATestInterface {

    @BeforeEach
    void beforeEach() {
        System.out.println("This is the base class");
    }

    @Test
    void testBiggerZero() {
        assertTrue(getANumberBiggerZero() > 0);
    }

    abstract int getANumberBiggerZero();
}
