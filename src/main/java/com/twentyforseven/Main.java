package com.twentyforseven;

import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import com.twentyforseven.util.LoggerConfig;
import com.twentyforseven.view.LandingPage;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LoggerConfig.configureLogger();
        logger.info("Starting application");

        SwingUtilities.invokeLater(() -> {
            LandingPage landingPage = new LandingPage();
            landingPage.setVisible(true);
        });
    }
}