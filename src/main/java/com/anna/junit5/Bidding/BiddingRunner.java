package com.anna.junit5.Bidding;

import com.anna.junit5.Player;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class BiddingRunner {

    public BiddingResult runBidding(Player dealer, Player hearer, Player teller) {
        BidGenerator bidGenerator = new BidGenerator();
        Player nextBiddingPartner = twoPlayerBidding(teller, hearer, bidGenerator);
        if (nextBiddingPartner == null) {
            //Nobody was able to bid
            if (dealer.doBid(18)) {
                return new BiddingResult(dealer, 18);
            }
            return new BiddingResult(null, 18);
        }
        Player winner = twoPlayerBidding(dealer, nextBiddingPartner, bidGenerator);
        return new BiddingResult(winner, bidGenerator.getCurrentBid());
    }

    private Player twoPlayerBidding(Player teller, Player hearer, BidGenerator bidGenerator) {
        int bid = bidGenerator.getNextBid();

        boolean tellerCanDoBid = teller.doBid(bid);

        while (tellerCanDoBid) {
            if (!hearer.canHoldBid(bid)) {
                return teller;
            }

            bid = bidGenerator.getNextBid();
            tellerCanDoBid = teller.doBid(bid);
        }

        if (bid == 18 && !hearer.canHoldBid(bid)) {
            return null;
        }
        if (bid > 18) {
            bidGenerator.goDownOneBid();
        }
        return hearer;
    }

}
