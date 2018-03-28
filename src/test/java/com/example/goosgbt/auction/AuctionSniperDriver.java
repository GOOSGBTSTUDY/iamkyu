package com.example.goosgbt.auction;

import static com.example.goosgbt.auction.MainWindow.MAIN_WINDOW_NAME;
import static org.hamcrest.Matchers.equalTo;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

public class AuctionSniperDriver extends JFrameDriver {
    
    public AuctionSniperDriver(int timeOutMillis) {
        super(new GesturePerformer(), 
                JFrameDriver.topLevelFrame(
                        named(MAIN_WINDOW_NAME),
                        showingOnScreen()
                ),
                new AWTEventQueueProber(timeOutMillis, 100)
        );
    }

    public void showSniperStatus(String statusText) {
        new JLabelDriver(this, named(MainWindow.SNIPER_STATUS_NAME))
                .hasText(equalTo(statusText));
    }
}
