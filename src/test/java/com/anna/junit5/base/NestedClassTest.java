package com.anna.junit5.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.anna.junit5.Bidding.BidGenerator;

/**
 * - Nested functionality to express grouping relation between tests
 * - @BeforeAll/@AfterAll and @BeforeEach/@AfterEach of parent classes executed for nested classes
 * - @BeforeAll/@AfterAll only works for nested claases when TestInstance is set to Lifecycle.PER_CLASS
 */
class NestedClassTest {
    private BidGenerator bidGenerator;
    private static int theInt = -1;

    @BeforeAll
    static void initAll() {
        theInt = 42;
    }

    @BeforeEach
    void createNewGenerator() {
        bidGenerator = new BidGenerator();
    }

    @Test
    void firstBidIs18() {
        assertEquals(18, bidGenerator.getNextBid());
        assertEquals(42, theInt);
    }

    @Nested
    class AfterCallingNextBid {

        @BeforeEach
        void callNextBid() {
            bidGenerator.getNextBid();
        }

        @Test
        void secondBidIs20() {
            assertEquals(20, bidGenerator.getNextBid());
            assertEquals(42, theInt);
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class AfterCallingNextBidTwice {

            @BeforeAll
            void initAll() {
                theInt = 41;
            }

            @BeforeEach
            void callNextBid() {
                bidGenerator.getNextBid();
            }

            @Test
            void thirdBidIs22() {
                assertEquals(22, bidGenerator.getNextBid());
                assertEquals(41, theInt);
            }

        }

    }
}
