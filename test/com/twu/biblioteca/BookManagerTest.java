package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookManagerTest {

    private LoginManager loginManager = LoginManager.getInstance();

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    public BookManagerTest() {
        userLogin();
    }

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    private void userLogin() {
        loginManager.isRightIdPassword("000-0001", "pw1");
    }

    @Test
    public void testShowSuccessMessageWhenSucceedInCheckOut() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "A";
        //when
        bookManager.checkOut(bookName);
        //then
        assertEquals("Thank you! Enjoy the book\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenRentBookNotEverInLibrary() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "bbb";
        //when
        bookManager.checkOut(bookName);
        //then
        assertEquals("Sorry, that book is not available\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenBookBeingCheckOut() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "B";
        //when
        bookManager.checkOut(bookName);
        bookManager.checkOut(bookName);
        //then
        assertEquals("Thank you! Enjoy the book\r\n" +
                        "Sorry, that book is not available\r\n",
                out.toString());
    }

    @Test
    public void testShowSuccessMessageWhenSucceedInReturn() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "C";
        //when
        bookManager.checkOut(bookName);
        bookManager.returnBook(bookName);
        //then
        assertEquals("Thank you! Enjoy the book\r\n" +
                "Thank you for returning the book\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenReturnBookNotEverInLibrary() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "ddd";
        //when
        bookManager.returnBook(bookName);
        //then
        assertEquals("That is not a valid book to return.\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenReturnBookAlreadyReturned() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "D";
        //when
        bookManager.returnBook(bookName);
        //then
        assertEquals("That is not a valid book to return.\r\n", out.toString());
    }
}
