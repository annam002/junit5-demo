package com.anna.junit5.Bidding;

import com.anna.junit5.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public final class BiddingResult {
    private final Player soloPlayer;
    private final int highestBid;
}
