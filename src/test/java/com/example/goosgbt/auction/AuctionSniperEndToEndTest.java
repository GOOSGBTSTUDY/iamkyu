package com.example.goosgbt.auction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AuctionSniperEndToEndTest {

    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    void sniperJoinsAuctionUntilAuctionCloses() {
        auction.startSellingItem(); // 1단계
        application.startBiddingIn(auction); // 2단계
        auction.hasReceivedJoinRequestFromSniper(); // 3단계
        auction.announceClosed(); // 4단계
        application.showsSniperHasLostAuction(); // 5단계
    }

    @AfterEach
    void stopAuction() {
        auction.stop();
    }

    @AfterEach
    void stopApplication() {
        auction.stop();
    }
}
