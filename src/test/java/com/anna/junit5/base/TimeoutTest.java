package com.anna.junit5.base;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.anna.junit5.FailureIntended;

/**
 * - Fail if a method takes longer than a certain amount of time
 * - Test can be killed if it exceeds the timeout
 */
class TimeoutTest {

    @Test
    @FailureIntended
    void timeoutTesting() {
        assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(100));
    }

    @Test
    @FailureIntended
    void timeoutTestingOnDifferentThread() {
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> Thread.sleep(100));
    }
}
