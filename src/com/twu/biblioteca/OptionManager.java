package com.twu.biblioteca;

import java.util.Scanner;

public class OptionManager {
    private final String Quit = "Quit";
    private final String ListOfBooks = "List of books";
    private final String CheckOutBook = "Check out a book";
    private final String ReturnBook = "Return a book";
    private final String ListOfMovies = "List of movies";
    private final String CheckOutMovie = "Check out a movie";
    private final String ReturnMovie = "Return a movie";
    private BookManager bookManager = new BookManager();
    private MovieManager movieManager = new MovieManager();

    public void showOptions(){
        System.out.println("Please choose an option(choose the number):");
        System.out.println("1. " + ListOfBooks);
        System.out.println("2. " + CheckOutBook);
        System.out.println("3. " + ReturnBook);
        System.out.println("4. " + ListOfMovies);
        System.out.println("5. " + CheckOutMovie);
        System.out.println("6. " + ReturnMovie);
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
        if (userSelection == 3) {
            returnBook();
            return false;
        }
        if (userSelection == 4) {
            listAllMovies();
            return false;
        }
        if (userSelection == 5) {
            checkOutMovie();
            return false;
        }
        if (userSelection == 6) {
            returnMovie();
            return false;
        }
        showInvalidOptionMessage();
        return false;
    }

    private void returnMovie() {
        System.out.println(("Please type the movie name you want to return："));
        Scanner in = new Scanner(System.in);
        String movieNameSearchString = in.nextLine();
        movieManager.returnMovie(movieNameSearchString);
    }

    private void checkOutMovie() {
        System.out.println("Please type the movie name you need：");
        Scanner in = new Scanner(System.in);
        String movieNameSearchString = in.nextLine();
        movieManager.checkOut(movieNameSearchString);
    }

    private void listAllMovies() {
        movieManager.showMovies();
    }

    private void returnBook() {
        System.out.println("Please type the book name you want to return：");
        Scanner in = new Scanner(System.in);
        String bookNameSearchString = in.nextLine();
        bookManager.returnBook(bookNameSearchString);
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
