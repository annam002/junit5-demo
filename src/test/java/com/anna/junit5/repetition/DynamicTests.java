package com.anna.junit5.repetition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;

import com.anna.junit5.Bidding.BidGenerator;
import com.google.common.collect.Lists;

/**
 * - Define factory for generating tests instead of test itself
 * - Lifecycle methods only executed once for each test factory
 * - Factory must deliver a Collection, Iterable or Stream of DynamicTests
 * - Tests can be grouped in DynamicContainers
 */
class DynamicTests {

    private static final List<Integer> BIDS = Lists.newArrayList(18, 20, 22, 23, 24, 27, 30, 33, 35, 36, 40, 44, 45, 46, 48, 50, 53, 54, 55);

    private BidGenerator bidGenerator;

    @BeforeEach
    void init() {
        bidGenerator = new BidGenerator();
    }

    @Test
    void testBidGenerator() {
        BIDS.forEach(bid -> assertEquals((int) bid, bidGenerator.getNextBid()));
    }

    @TestFactory
    Stream<DynamicTest> testBidGeneratorDynamically() {
        return DynamicTest.stream(BIDS.iterator(),
                bid -> "test-" + bid,
                bid -> assertEquals((int) bid, bidGenerator.getNextBid()));
    }

    @TestFactory
    Stream<DynamicNode> testBidGeneratorDynamicallyWithContainers() {
        return BIDS.stream()
                .map(bid -> dynamicContainer("Bid " + bid, Stream.of(
                        dynamicTest("next bid", () -> assertEquals((int) bid, bidGenerator.getNextBid())),
                        dynamicTest("current bid", () -> assertEquals((int) bid, bidGenerator.getCurrentBid()))
                )));
    }


}
