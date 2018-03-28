package com.example.goosgbt.auction;

import static com.example.goosgbt.auction.FakeAuctionServer.XMPP_HOSTNAME;
import static com.example.goosgbt.auction.MainWindow.STATUS_JOINING;
import static com.example.goosgbt.auction.MainWindow.STATUS_LOST;

public class ApplicationRunner {

    public static final String SNIPER_ID = "sniper";
    public static final String SNIPER_PASSWORD = "sniper";
    public static final String SNIPER_XMPP_ID = "sniper@localhost/Auction";

    public AuctionSniperDriver driver;

    public void startBiddingIn(FakeAuctionServer auction) {
        Thread t = new Thread(() -> {
            try {
                Main.main(
                        XMPP_HOSTNAME, 
                        SNIPER_ID, 
                        SNIPER_PASSWORD, 
                        auction.getItemId()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Test Application");

        t.setDaemon(true);
        t.start();

        driver = new AuctionSniperDriver(1000);
        driver.showSniperStatus(STATUS_JOINING);
    }

    public void showsSniperHasLostAuction() {
        driver.showSniperStatus(STATUS_LOST);
    }

    public void hasShownSniperIsBidding() {
        driver.showSniperStatus(MainWindow.STATUS_BIDDING);
    }

    public void stop() {
        if (driver != null) {
            driver.dispose();
        }
    }
}
