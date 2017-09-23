package com.anna.junit5.ye.olde;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Run JUnit5 test in IDE that does not support JUnit5 yet
 */
@RunWith(JUnitPlatform.class)
public class JUnit5Test {

    @Test
    @DisplayName("my new test")
    public void shinyNewTestOnOldPlatform() {
        assertEquals(4, 2 * 2);
    }
}
