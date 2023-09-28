package org.example.app;

import org.example.app.utils.AppStarter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class App {

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppStarter.startApp();
    }
}