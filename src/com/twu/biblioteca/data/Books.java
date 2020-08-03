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
        char author = 'a';
        int yearPublished = 1990;
        for (int i = 0; i < 10; i++) {
            bookList.add(new Book(Character.toString(bookName),
                    Character.toString(author),
                    yearPublished));
            bookName += 1;
            author += 1;
            yearPublished += 1;
        }
    }

    public List getBookList() {
        return bookList;
    }
}
