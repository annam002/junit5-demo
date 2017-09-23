package com.anna.junit5.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.anna.junit5.Bidding.BidGenerator;

/**
 * - Exceptions can be asserted and do not disrupt test flow
 * - Objects of asserted exceptions can be tested as well
 */
class ExceptionTest {

    @Test
    void exceptionTesting() {
        BidGenerator bidGenerator = new BidGenerator();
        assertEquals(18, bidGenerator.getNextBid());

        IllegalStateException exception = assertThrows(IllegalStateException.class, bidGenerator::goDownOneBid);
        assertEquals("Lowest bid reached", exception.getMessage());
    }
}
