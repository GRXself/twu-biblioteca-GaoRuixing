package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        //1.1 Show welcome
        Welcome welcome = new Welcome();
        welcome.showWelcomeMessage();

        //1.2 Show book list
        BookManager bookManager = new BookManager();
        bookManager.showBooks();
    }
}
