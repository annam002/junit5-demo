package com.anna.junit5;

import lombok.Getter;

public abstract class Player {

    @Getter
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract boolean doBid(int bid);
    public abstract boolean canHoldBid(int bid);

    @Override
    public String toString() {
        return getName();
    }
}
