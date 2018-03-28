package com.example.goosgbt.auction;

import javax.swing.*;

public class MainWindow extends JFrame {

    public static final String MAIN_WINDOW_NAME = "Auction Sniper Main";
    public static final String SNIPER_STATUS_NAME = "sniper status";
    public static final String STATUS_JOINING = "Joining";
    public static final String STATUS_LOST = "Lost";

    public MainWindow() {
        super("Auction sniper");
        setName(MAIN_WINDOW_NAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(100, 100);
    }
}
