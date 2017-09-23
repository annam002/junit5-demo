package com.anna.junit5.base;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * - @Ignore -> @Disabled
 * - Disabled class can be run manually
 * - Disabled message printed out in console
 */
@Disabled("All tests in this class are disabled")
class ClassDisabledTest {

    @Test
    void test1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test2() {
        assertEquals(4, 2 + 2);
    }
}
