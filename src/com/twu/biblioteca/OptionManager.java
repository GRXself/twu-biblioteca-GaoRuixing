package com.twu.biblioteca;

public class OptionManager {
    private final String ListOfBooks = "List of books";
    private BookManager bookManager = new BookManager();

    public void showOptions(){
        System.out.println("Please choose an option(choose the number):");
        System.out.println("1. " + ListOfBooks);
    }

    public void actOnSelection(int userSelection){
        if (userSelection == 1){
            listAllBooks();
        }
    }

    public void listAllBooks(){
        bookManager.showBooks();
    }
}
