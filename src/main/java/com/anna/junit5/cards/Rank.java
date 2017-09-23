package com.anna.junit5.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Rank {
    ACE(11),
    TEN(10),
    KING(4),
    QUEEN(3),
    JACK(2),
    NINE(0),
    EIGHT(0),
    SEVEN(0);

    private final int rankValue;
}
