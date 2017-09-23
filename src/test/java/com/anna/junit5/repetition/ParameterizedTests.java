package com.anna.junit5.repetition;

import com.anna.junit5.Bidding.BiddingResult;
import com.anna.junit5.Bidding.BiddingRunner;
import com.anna.junit5.BiddingSetup;
import com.anna.junit5.MaxBidPlayer;
import com.anna.junit5.Player;
import com.anna.junit5.cards.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * - Run the same test with different data
 * - Different sources configurable: values, enums, methods, csv or custom
 * - Need dependency on junit-jupiter-params
 */
class ParameterizedTests {

    @DisplayName("My first parameterized test")
    @ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
    @ValueSource(ints = { 1, 2, 3 })
    void testWithValueSource(int argument) {
        assertTrue(argument > 0);
    }

    @ParameterizedTest
    @EnumSource(Suit.class)
    void testWithEnumSource(Suit suit) {
        assertNotNull(suit);
    }

    @Test
    void testBidding1() {
        Player player1 = new MaxBidPlayer("Dealer", 24);
        Player player2 = new MaxBidPlayer("Hearer", 20);
        Player player3 = new MaxBidPlayer("Teller", 33);
        BiddingResult biddingResult = new BiddingRunner().runBidding(player1, player2, player3);
        assertAll(
                () -> assertEquals(24, biddingResult.getHighestBid()),
                () -> assertEquals(player3, biddingResult.getSoloPlayer())
        );
    }

    @ParameterizedTest
    @MethodSource("biddingProvider")
    void testWithMethodSource(BiddingSetup setup) {
        BiddingResult biddingResult = new BiddingRunner().runBidding(setup.getPlayer1(), setup.getPlayer2(), setup.getPlayer3());
        assertAll(
                () -> assertEquals(setup.getHighestBid(), biddingResult.getHighestBid()),
                () -> assertEquals(setup.getWinner(), biddingResult.getSoloPlayer())
        );
    }

    static Stream<BiddingSetup> biddingProvider() {
        return BiddingSetup.createBiddingSetups();
    }

    @ParameterizedTest
    @ArgumentsSource(BiddingSetupProvider.class)
    void testWithArgumentsSource(BiddingSetup setup) {
        BiddingResult biddingResult = new BiddingRunner().runBidding(setup.getPlayer1(), setup.getPlayer2(), setup.getPlayer3());
        assertAll(
                () -> assertEquals(setup.getHighestBid(), biddingResult.getHighestBid()),
                () -> assertEquals(setup.getWinner(), biddingResult.getSoloPlayer())
        );
    }

    static class BiddingSetupProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return BiddingSetup.createBiddingSetups().map(Arguments::of);
        }
    }

}
