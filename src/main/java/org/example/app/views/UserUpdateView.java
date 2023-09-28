package org.example.app.views;

import java.util.Scanner;

public class UserUpdateView {

    public String[] getNewPhone() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter contact's ID: ";
        System.out.print(title);
        String id = scanner.nextLine();

        title = "Enter new phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        String phone = scanner.nextLine();

        String email = null;

        return new String[]{id, phone, email};
    }

    public String[] getNewEmail() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter contact's ID: ";
        System.out.print(title);
        String id = scanner.nextLine();

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        String phone = null;

        return new String[]{id, phone, email};
    }

    public String[] getAllNewInfo() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter contact's ID: ";
        System.out.print(title);
        String id = scanner.nextLine();

        title = "Enter new phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        String phone = scanner.nextLine();

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[]{id, phone, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
