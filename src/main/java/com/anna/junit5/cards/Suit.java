package com.anna.junit5.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Suit {
    CLUBS(12),
    SPADES(11),
    HEARTS(10),
    DIAMONDS(9);

    private final int suitValue;
}
