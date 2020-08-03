package com.twu.biblioteca;

import com.twu.biblioteca.data.Books;
import com.twu.biblioteca.model.Book;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class BookManager {
    private Books books;

    public BookManager (){
        getBooks();
    }

    private void getBooks(){
        books = new Books();
    }

    public void showBooks(){
        System.out.println("Book List:");
        Iterator<Book> i = books.getBookList().iterator();
        while(i.hasNext()){
            Book book = i.next();
            bookConsoleLinePrinter(book);
        }
    }

    private void bookConsoleLinePrinter(Book book){
        System.out.print(book.getBookName());
        String nameWhiteSpace = "";
        for (int i = books.getMaxBookNameCharacterCount() - book.getBookName().length() + 4; i > 0; i--) {
            nameWhiteSpace += " ";
        }
        System.out.print(nameWhiteSpace);
        System.out.print("|");

        System.out.print(book.getAuthor());
        String authorWhiteSpace = "";
        for (int i = books.getMaxBookAuthorCharacterCount() - book.getAuthor().length() + 2; i > 0; i--) {
            authorWhiteSpace += " ";
        }
        System.out.print(authorWhiteSpace);
        System.out.print("|");

        System.out.println(book.getYearPublished());
    }

    public void checkOut(String bookNameSearchString) {
    }
}
