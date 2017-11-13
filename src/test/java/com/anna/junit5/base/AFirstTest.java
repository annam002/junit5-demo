package com.anna.junit5.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class AFirstTest {

    @Test
    @DisplayName("Hello JUnit5! \uD83D\uDE03")
    void helloJUnit5() {
        assertEquals(2, 3 - 1, "Math failed, world going down");
    }

}
