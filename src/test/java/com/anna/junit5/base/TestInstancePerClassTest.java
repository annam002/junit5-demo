package com.anna.junit5.base;

import com.anna.junit5.Bidding.BidGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * - Default Lifecycle is PER_METHOD: for every test method, a new instance of the test class is created
 * - If Lifecycle is PER_CLASS, one and the same instance of the test class is used for each test method
 * - @BeforeAll/@AfterAll can be non-static in this case
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestInstancePerClassTest {

    private BidGenerator bidGeneratorInitializedOnce;
    private BidGenerator bidGeneratorInitializedPerTest;

    @BeforeAll
    void init() {
        bidGeneratorInitializedOnce = new BidGenerator();
    }

    @BeforeEach
    void initEach() {
        bidGeneratorInitializedPerTest = new BidGenerator();
    }

    @Test
    void aTest() {
        System.out.println("=== aTest ====");
        System.out.println("bidGeneratorInitializedOnce: " + bidGeneratorInitializedOnce.getNextBid());
        System.out.println("bidGeneratorInitializedPerTest: " + bidGeneratorInitializedPerTest.getNextBid());
    }

    @Test
    void anotherTest() {
        System.out.println("=== anotherTest ====");
        System.out.println("bidGeneratorInitializedOnce: " + bidGeneratorInitializedOnce.getNextBid());
        System.out.println("bidGeneratorInitializedPerTest: " + bidGeneratorInitializedPerTest.getNextBid());
    }
}
