package com.twu.biblioteca;

import java.awt.*;

public class OptionManager {
    private final String ListOfBooks = "List of books";
    private BookManager bookManager = new BookManager();

    public void showOptions(){
        System.out.println("Please choose an option(choose the number):");
        System.out.println("1. " + ListOfBooks);
    }

    public void actOnSelection(int userSelection) {
        if (userSelection == 1) {
            listAllBooks();
        }
        else {
            showInvalidOptionMessage();
        }
    }

    public void listAllBooks(){
        bookManager.showBooks();
    }

    private void showInvalidOptionMessage() {
        System.out.println("Please select a valid option!");
    }
}
