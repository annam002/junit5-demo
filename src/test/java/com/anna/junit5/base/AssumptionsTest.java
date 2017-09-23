package com.anna.junit5.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * - assumptions are preconditions for tests
 */
class AssumptionsTest {

    @Test
    void testOnlyOnCertainJavaVersion() {
        assumeTrue(System.getProperty("java.version").equals("1.8.0_130"), "nonono");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals(2, 2);
                });

        // perform these assertions in all environments
        assertEquals("a string", "a string");
    }
}
