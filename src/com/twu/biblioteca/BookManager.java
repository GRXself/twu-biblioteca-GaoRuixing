package com.twu.biblioteca;

import com.twu.biblioteca.data.Books;
import com.twu.biblioteca.model.Book;

import java.util.Iterator;
import java.util.List;

public class BookManager {
    private List books;

    public BookManager (){
        getBooks();
    }

    private void getBooks(){
        books = new Books().getBookList();
    }

    public void showBooks(){
        System.out.println("Book List:");
        Iterator<Book> i = books.iterator();
        while(i.hasNext()){
            System.out.println(i.next().getBookName());
        }
    }
}
