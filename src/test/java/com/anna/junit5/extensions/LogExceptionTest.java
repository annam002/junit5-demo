package com.anna.junit5.extensions;

import com.anna.junit5.FailureIntended;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LogExceptionHandler.class)
class LogExceptionTest {

    @Test
    @FailureIntended
    void testAndLogException() {
        assertEquals(4, 2 * 2);
        throw new IllegalStateException("This test is broken!");
    }
}
