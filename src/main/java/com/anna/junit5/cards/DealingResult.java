package com.anna.junit5.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public final class DealingResult {
    private final List<Card> cardsPlayer1;
    private final List<Card> cardsPlayer2;
    private final List<Card> cardsPlayer3;
    private final List<Card> skat;
}
