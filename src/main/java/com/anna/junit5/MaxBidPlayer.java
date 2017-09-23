package com.anna.junit5;

public class MaxBidPlayer extends Player {

    private final int maxBid;

    public MaxBidPlayer(String name, int maxBid) {
        super(name);
        this.maxBid = maxBid;
    }

    @Override
    public boolean doBid(int bid) {
        return bid <= maxBid;
    }

    @Override
    public boolean canHoldBid(int bid) {
        return bid <= maxBid;
    }
}
