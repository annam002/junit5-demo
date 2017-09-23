package com.anna.junit5.base;

import com.anna.junit5.Bidding.BidGenerator;
import com.anna.junit5.cards.CardProvider;
import com.anna.junit5.cards.DealingResult;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * - assertions look similar as in JUnit4
 * - assertion message moved to the end of the argument list
 * - assertion message can be lazily evaluated
 * - assertSame: test if same object
 * - assertAll: assert all executables and report all errors
 */
class AssertionsTest {

    @Test
    void junitAssertions() {
        DealingResult dealingResult = new CardProvider().dealCards();

        assertAll(
                () -> assertEquals(2, dealingResult.getSkat().size(), "Did not get 2 cards in Skat"),
                () -> assertSame(10, dealingResult.getCardsPlayer1().size(), "Player 1 did not get 10 cards"),
                () -> assertTrue(10 == dealingResult.getCardsPlayer2().size(), "Player 2 did not get 10 cards"),
                () -> assertFalse(10 != dealingResult.getCardsPlayer3().size(), () -> "Player 3 got these cards: " + dealingResult.getCardsPlayer3())
        );
    }

    @Test
    void useExternalMatchers() {
        assertThat(18, is(equalTo(new BidGenerator().getNextBid())));
    }

    @Test
    void callFailManually() {
        if (new BidGenerator().getNextBid() != 18) {
            fail("a failing test");
        }
    }
}
