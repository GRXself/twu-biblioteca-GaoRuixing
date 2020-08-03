package com.twu.biblioteca.model;

public class Book {
    private String bookName;
    private String author;
    private int yearPublished;
    private boolean isCheckOut;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String author, int yearPublished, boolean isCheckOut){
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isCheckOut = isCheckOut;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }

        Book that = (Book) obj;

        if (this.getBookName().equals(that.getBookName())) {
            return true;
        }

        return false;
    }
}
