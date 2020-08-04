package com.twu.biblioteca;

import com.twu.biblioteca.model.LoginManager;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        //Show welcome
        Welcome welcome = new Welcome();
        welcome.showWelcomeMessage();

        //Show login
        LoginManager loginManager = new LoginManager();
        loginManager.doLogin();

        //Show options
        OptionManager optionManager = new OptionManager();
        Scanner in = new Scanner(System.in);
        while (true) {
            optionManager.showOptions();
            int userSelection = in.nextInt();
            boolean isUserChooseQuit = optionManager.actOnSelection(userSelection);
            if (isUserChooseQuit){
                break;
            }
        }

    }
}
