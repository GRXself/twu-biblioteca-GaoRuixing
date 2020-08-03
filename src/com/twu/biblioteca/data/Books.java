package com.twu.biblioteca.data;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List bookList;

    public Books() {
        generateBookList();
    }

    private void generateBookList() {
        bookList = new ArrayList<Book>();
        char bookName = 'A';
        for (int i = 0; i < 10; i++) {
            bookList.add(new Book(Character.toString(bookName)));
            bookName += 1;
        }
    }

    public List getBookList() {
        return bookList;
    }
}
