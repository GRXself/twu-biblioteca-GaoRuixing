package com.twu.biblioteca.data;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List bookList;
    private int maxBookNameCharacterCount;
    private int maxBookAuthorCharacterCount;

    public Books() {
        generateBookList();
    }

    private void generateBookList() {
        bookList = new ArrayList<Book>();
        char bookName = 'A';
        char author = 'a';
        int yearPublished = 1990;
        for (int i = 0; i < 10; i++) {
            String bookNameString = Character.toString(bookName);
            String bookAuthorString = Character.toString(author);
            bookList.add(new Book(bookNameString,
                    bookAuthorString,
                    yearPublished));
            maxBookNameCharacterCount = bookNameString.length() > maxBookAuthorCharacterCount ?
                    bookNameString.length() : maxBookNameCharacterCount;
            maxBookAuthorCharacterCount = bookAuthorString.length() > maxBookAuthorCharacterCount ?
                    bookAuthorString.length() : maxBookAuthorCharacterCount;
            bookName += 1;
            author += 1;
            yearPublished += 1;
        }
    }

    public List getBookList() {
        return bookList;
    }

    public int getMaxBookNameCharacterCount() {
        return maxBookNameCharacterCount;
    }

    public int getMaxBookAuthorCharacterCount() {
        return maxBookAuthorCharacterCount;
    }
}
