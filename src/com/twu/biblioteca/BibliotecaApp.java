package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        //Show welcome
        Welcome welcome = new Welcome();
        welcome.showWelcomeMessage();

        //Show options
        OptionManager optionManager = new OptionManager();
        optionManager.showOptions();

        Scanner in = new Scanner(System.in);
        int userSelection = in.nextInt();
        optionManager.actOnSelection(userSelection);

    }
}
