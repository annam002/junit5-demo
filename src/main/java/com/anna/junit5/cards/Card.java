package com.anna.junit5.cards;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;

    @Override
    public int compareTo(Card o) {
        if (rank == Rank.JACK) {
            if (o.rank == Rank.JACK) {
                return suit.compareTo(o.getSuit());
            }
            return -1;
        }
        if (o.getRank() == Rank.JACK) {
            return 1;
        }
        if (suit == o.getSuit()) {
            return rank.compareTo(o.getRank());
        }

        return suit.compareTo(o.getSuit());
    }

    @Override
    public String toString() {
        return suit + "-" + rank;
    }

}
