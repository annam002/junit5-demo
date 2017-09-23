package com.anna.junit5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
@ToString
public class BiddingSetup {
    private static final String PLAYER1_NAME = "Dealer";
    private static final String PLAYER2_NAME = "Hearer";
    private static final String PLAYER3_NAME = "Teller";

    private final Player player1;
    private final Player player2;
    private final Player player3;
    private final int highestBid;
    private final Player winner;

    public static Stream<BiddingSetup> createBiddingSetups() {
        return Stream.of(
                BiddingSetup.createAndPlayer1Wins(33, 20, 24, 27),
                BiddingSetup.createAndPlayer2Wins(24, 33, 20, 24),
                BiddingSetup.createAndPlayer3Wins(24, 20, 33, 24),
                BiddingSetup.createAndPlayer1Wins(18, 0, 0, 18),
                BiddingSetup.createAndPlayer2Wins(0, 18, 0, 18),
                BiddingSetup.createAndPlayer3Wins(0, 0, 18, 18)
        );
    }

    static BiddingSetup createAndPlayer1Wins(int maxBidDealer, int maxBidHearer, int maxBidTeller, int highestBid) {
        Player player1 = new MaxBidPlayer(PLAYER1_NAME, maxBidDealer);
        Player player2 = new MaxBidPlayer(PLAYER2_NAME, maxBidHearer);
        Player player3 = new MaxBidPlayer(PLAYER3_NAME, maxBidTeller);
        return new BiddingSetup(player1, player2, player3, highestBid, player1);
    }

    static BiddingSetup createAndPlayer2Wins(int maxBidDealer, int maxBidHearer, int maxBidTeller, int highestBid) {
        Player player1 = new MaxBidPlayer(PLAYER1_NAME, maxBidDealer);
        Player player2 = new MaxBidPlayer(PLAYER2_NAME, maxBidHearer);
        Player player3 = new MaxBidPlayer(PLAYER3_NAME, maxBidTeller);
        return new BiddingSetup(player1, player2, player3, highestBid, player2);
    }

    static BiddingSetup createAndPlayer3Wins(int maxBidDealer, int maxBidHearer, int maxBidTeller, int highestBid) {
        Player player1 = new MaxBidPlayer(PLAYER1_NAME, maxBidDealer);
        Player player2 = new MaxBidPlayer(PLAYER2_NAME, maxBidHearer);
        Player player3 = new MaxBidPlayer(PLAYER3_NAME, maxBidTeller);
        return new BiddingSetup(player1, player2, player3, highestBid, player3);
    }
}
