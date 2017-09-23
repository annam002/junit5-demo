package com.anna.junit5.base;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * - @Ignore -> @Disabled
 * - Disabled test can be run manually
 */
class DisabledTest {

    @Disabled("This test is disabled")
    @Test
    void test1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test2() {
        assertEquals(4, 2 + 2);
    }
}
