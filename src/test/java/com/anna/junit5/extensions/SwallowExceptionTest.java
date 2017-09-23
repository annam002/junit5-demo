package com.anna.junit5.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SwallowExceptionHandler.class)
class SwallowExceptionTest {

    @Test
    void testAndIgnoreException() {
        assertEquals(4, 2 * 2);
        throw new IllegalStateException();
    }
}
