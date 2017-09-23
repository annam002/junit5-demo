package com.anna.junit5.template;

import com.anna.junit5.Bidding.BiddingResult;
import com.anna.junit5.Bidding.BiddingRunner;
import com.anna.junit5.BiddingSetup;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTemplateTest {

    @TestTemplate
    @ExtendWith(BiddingSetupContextProvider.class)
    void testBidding(BiddingSetup setup) {
        BiddingResult biddingResult = new BiddingRunner().runBidding(setup.getPlayer1(), setup.getPlayer2(), setup.getPlayer3());
        assertAll(
                () -> assertEquals(setup.getHighestBid(), biddingResult.getHighestBid()),
                () -> assertEquals(setup.getWinner(), biddingResult.getSoloPlayer())
        );
    }
}
