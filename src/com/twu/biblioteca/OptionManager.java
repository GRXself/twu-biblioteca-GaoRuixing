package com.twu.biblioteca;

import java.util.Scanner;

public class OptionManager {
    private final String Quit = "Quit";
    private final String ListOfBooks = "List of books";
    private final String CheckOut = "Check out a book";
    private BookManager bookManager = new BookManager();

    public void showOptions(){
        System.out.println("Please choose an option(choose the number):");
        System.out.println("1. " + ListOfBooks);
        System.out.println("2. " + CheckOut);
        System.out.println("0. " + Quit);
    }

    public boolean actOnSelection(int userSelection) {
        if (userSelection == 0) {
            return true;
        }
        if (userSelection == 1) {
            listAllBooks();
            return false;
        }
        if (userSelection == 2) {
            checkOutBook();
            return false;
        }
        showInvalidOptionMessage();
        return false;
    }

    private void checkOutBook() {
        System.out.println("Please type the book name you need：");
        Scanner in = new Scanner(System.in);
        String bookNameSearchString = in.nextLine();
        bookManager.checkOut(bookNameSearchString);
    }

    public void listAllBooks(){
        bookManager.showBooks();
    }

    private void showInvalidOptionMessage() {
        System.out.println("Please select a valid option!");
    }
}
