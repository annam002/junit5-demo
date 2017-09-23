package com.anna.junit5.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardProvider {

    public DealingResult dealCards() {
        List<Card> cards = getAllCards();
        Collections.shuffle(cards);
        return new DealingResult(
                new ArrayList<>(cards.subList(0, 10)),
                new ArrayList<>(cards.subList(10, 20)),
                new ArrayList<>(cards.subList(20, 30)),
                new ArrayList<>(cards.subList(30, 32))
        );
    }

    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
        return cards;
    }
}
