package com.example.goosgbt.auction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AuctionSniperEndToEndTest {

    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
        auction.startSellingItem(); // 1단계
        application.startBiddingIn(auction); // 2단계
        auction.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID); // 3단계
        auction.announceClosed(); // 4단계
        application.showsSniperHasLostAuction(); // 5단계
    }

    @Test
    void sniperMakesAHigherBidButLoses() throws Exception {
        auction.startSellingItem();

        application.startBiddingIn(auction);
        auction.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);
        
        auction.reportPrice(1000, 98, "other bidder");
        application.hasShownSniperIsBidding();
        auction.hasReceiveBid(1098, ApplicationRunner.SNIPER_XMPP_ID);

        auction.announceClosed();
        application.showsSniperHasLostAuction();
    }

    @AfterEach
    void stopAuction() {
        auction.stop();
    }

    @AfterEach
    void stopApplication() {
        application.stop();
    }
}
