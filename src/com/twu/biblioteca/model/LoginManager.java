package com.twu.biblioteca.model;

import com.twu.biblioteca.data.Users;

import java.util.Scanner;

public class LoginManager {
    private String id;
    private String password;
    private User currentUser;
    private Users users;

    public LoginManager() {
        users = new Users();
    }

    public boolean login(String id, String password) {
        return isRightIdPassword(id, password);
    }

    public boolean isRightIdPassword(String id, String password) {
        return users.getUserList().stream().anyMatch(user -> {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
            return false;
        });
    }

    public void doLogin() {
        while (true) {
            showLoginReminder();
            letUserEnterIdPassword();
            if (isRightIdPassword(id, password)) {
                showSuccessLoginReminder();
                break;
            }
            showBadLoginReminder();
        }
    }

    private void letUserEnterIdPassword() {
        Scanner in = new Scanner(System.in);

        showInputIdReminder();
        id = in.nextLine();

        showInputPasswordReminder();
        password = in.nextLine();
    }

    private void showLoginReminder() {
        System.out.println("Please login first");
    }

    private void showInputIdReminder() {
        System.out.println("Please enter your id:");
    }

    private void showInputPasswordReminder() {
        System.out.println("Please enter your password:");
    }

    private void showSuccessLoginReminder() {
        System.out.println("Login success!");
    }

    private void showBadLoginReminder() {
        System.out.println("Bad id or password!");
    }
}
