package com.anna.junit5.Bidding;

public final class BidGenerator {
    private int bid = -1;
    private int lastBid = -1;

    public int getNextBid() {
        if (bid < 0) {
            bid = 18;
            return bid;
        }
        lastBid = bid;
        bid++;
        while(!isValidBid()) {
            bid++;
        }
        return bid;
    }

    public int getCurrentBid() {
        return bid;
    }

    public void goDownOneBid() {
        if (bid <= 18) {
            throw new IllegalStateException("Lowest bid reached");
        }
        bid = lastBid;
    }

    private boolean isValidBid() {
        return bid == 23 || bid == 35 || bid == 46 || bid == 53 //Null
                || bid % 9 == 0   //Diamonds
                || bid % 10 == 0  //Hearts
                || bid % 11 == 0  //Spades
                || bid % 12 == 0; //Clubs
    }
}
