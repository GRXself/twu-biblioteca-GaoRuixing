package com.twu.biblioteca;

public class OptionManager {
    private final String Quit = "Quit";
    private final String ListOfBooks = "List of books";
    private BookManager bookManager = new BookManager();

    public void showOptions(){
        System.out.println("Please choose an option(choose the number):");
        System.out.println("1. " + ListOfBooks);
        System.out.println("0. " + Quit);
    }

    public boolean actOnSelection(int userSelection) {
        if (userSelection == 0) {
            return true;
        }
        if (userSelection == 1) {
            listAllBooks();
        }
        else {
            showInvalidOptionMessage();
        }
        return false;
    }

    public void listAllBooks(){
        bookManager.showBooks();
    }

    private void showInvalidOptionMessage() {
        System.out.println("Please select a valid option!");
    }
}
