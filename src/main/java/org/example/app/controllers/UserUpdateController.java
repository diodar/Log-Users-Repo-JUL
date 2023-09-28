package org.example.app.controllers;

import org.example.app.exceptions.OptionException;
import org.example.app.services.UserUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.UserUpdateView;

import java.util.Scanner;

public class UserUpdateController {

    UserUpdateService service;
    UserUpdateView view;

    public UserUpdateController(UserUpdateService service, UserUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUser() {

        String str = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                                
                ______ What do you want to update ? ______
                1 - phone.
                2 - email.
                3 - both.
                """);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> str = service.updatePhone(view.getNewPhone());
            case 2 -> str = service.updateEmail(view.getNewEmail());
            case 3 -> str = service.updateUser(view.getAllNewInfo());
            default -> {
                try {
                    throw new OptionException(Constants.INCORRECT_VALUE_MSG);
                } catch (OptionException e) {
                    System.out.println(e.getMessage());
                    updateUser();
                }
            }
        }

        if (str.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.startApp();
        }
    }
}
