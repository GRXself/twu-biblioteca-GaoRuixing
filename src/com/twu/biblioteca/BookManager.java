package com.twu.biblioteca;

import com.twu.biblioteca.data.Books;
import com.twu.biblioteca.model.Book;

import java.util.Iterator;
import java.util.List;

public class BookManager {
    private Books books;

    public BookManager (){
        books = new Books();
    }

    public Books getBooks() {
        return books;
    }

    public void showBooks(){
        System.out.println("Book List:");
        Iterator<Book> i = books.getBookList().iterator();
        while(i.hasNext()){
            Book book = i.next();
            if (book.isCheckOut())
                continue;
            bookConsoleLinePrinter(book);
        }
    }

    private void bookConsoleLinePrinter(Book book){
        System.out.print(book.getBookName());
        StringBuilder nameWhiteSpace = new StringBuilder();
        for (int i = books.getMaxBookNameCharacterCount() - book.getBookName().length() + 4; i > 0; i--) {
            nameWhiteSpace.append(" ");
        }
        System.out.print(nameWhiteSpace);
        System.out.print("|");

        System.out.print(book.getAuthor());
        StringBuilder authorWhiteSpace = new StringBuilder();
        for (int i = books.getMaxBookAuthorCharacterCount() - book.getAuthor().length() + 2; i > 0; i--) {
            authorWhiteSpace.append(" ");
        }
        System.out.print(authorWhiteSpace);
        System.out.print("|");

        System.out.println(book.getYearPublished());
    }

    public void checkOut(String bookNameSearchString) {
        List<Book> books = this.books.getBookList();
        int booIndex = books.indexOf(new Book(bookNameSearchString));
        if (booIndex >= 0) {
            Book book = books.get(booIndex);
            if(book.isCheckOut()){
                showFailedMessageOnNotCheckOut();
            }
            else {
                book.setCheckOut(true);
                showSuccessMessageOnCheckOut();
            }
        }
        else {
            showFailedMessageOnNotCheckOut();
        }
    }

    public void returnBook(String bookNameSearchString) {
        List<Book> books = this.books.getBookList();
        int bookIndex = books.indexOf(new Book(bookNameSearchString));
        if (bookIndex >= 0) {
            Book book = books.get(bookIndex);
            if(book.isCheckOut()){
                book.setCheckOut(false);
                showSuccessMessageOnReturn();
            }
            else {
                showFailedMessageOnBadReturn();
            }
        }
        else {
            showFailedMessageOnBadReturn();
        }
    }

    private void showSuccessMessageOnCheckOut() {
        System.out.println("Thank you! Enjoy the book");
    }

    private void showFailedMessageOnNotCheckOut() {
        System.out.println("Sorry, that book is not available");
    }

    private void showSuccessMessageOnReturn() {
        System.out.println("Thank you for returning the book");
    }

    private void showFailedMessageOnBadReturn() {
        System.out.println("That is not a valid book to return.");
    }
}
