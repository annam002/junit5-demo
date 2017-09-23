package com.anna.junit5.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anna.junit5.FailureIntended;

/**
 * - @Before/@After -> @BeforeEach/@AfterEach
 * - @BeforeClass/@AfterClass -> @BeforeAll/@AfterAll
 * - FailureIntended: custom tag to indicate to the build tools that this test should be ignored
 */
class BeforeAndAfterTest {

    private static Stream<Integer> staticStream;
    private Stream<Integer> stream;

    @BeforeAll
    static void initAll() {
        staticStream = Stream.iterate(1, i -> i + 1).limit(100);
    }

    @AfterAll
    static void tearDownAll() {
        staticStream.close();
    }

    @BeforeEach
    void init() {
        stream = Stream.iterate(1, i -> i + 1).limit(100);
    }

    @AfterEach
    void tearDown() {
        stream.close();
    }

    @Test
    void test1() {
        assertEquals(100, stream.count());
        assertEquals(100, staticStream.count());
    }

    @Test
    void test2() {
        assertEquals(100, stream.count());
    }

    @Test
    @FailureIntended
    void test3() {
        //will fail - staticStream already consumed
        assertEquals(100, staticStream.count());
    }
}
