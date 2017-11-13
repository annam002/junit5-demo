package com.anna.junit5.repetition;

import com.anna.junit5.FailureIntended;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * - Simple repetition of test
 */
class RepeatedTestTest {

    @RepeatedTest(value=5, name="{currentRepetition}/{totalRepetitions} of {displayName}")
    void test5Times() {
        assertEquals(5, 4 + 1);
    }

    @RepeatedTest(value = 100)
    void testRandomDistribution() {
        Random random = new Random();

        long trueCount = Stream.generate(random::nextBoolean).limit(100)
                .filter(b -> b)
                .count();
        assertTrue(trueCount > 35 && trueCount < 65, () -> "Counted 'True' " + trueCount + " times");
    }

}
