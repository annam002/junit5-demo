package com.anna.junit5.repetition;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * - Simple repetition of test
 */
class RepeatedTestTest {

    @RepeatedTest(value=5, name="{currentRepetition}/{totalRepetitions} of {displayName}")
    void test5Times() {
        assertEquals(5, 4 + 1);
    }

}
