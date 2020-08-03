package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookManagerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private BookManager bookManager = new BookManager();

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

    @Test
    public void testShowSuccessMessageWhenSucceedInCheckOut() {
        //give
        String bookName = "A";
        //when
        bookManager.checkOut(bookName);
        //then
        assertEquals("Thank you! Enjoy the book\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenBookNotEverInLibrary() {
        //give
        String bookName = "bbb";
        //when
        bookManager.checkOut(bookName);
        //then
        assertEquals("Sorry, that book is not available\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenBookBeingCheckOut() {
        //give
        String bookName = "B";
        //when
        bookManager.checkOut(bookName);
        bookManager.checkOut(bookName);
        //then
        assertEquals("Thank you! Enjoy the book\r\n" +
                        "Sorry, that book is not available\r\n",
                out.toString());
    }
}
