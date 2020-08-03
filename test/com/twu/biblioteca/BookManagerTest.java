package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookManagerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

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
        BookManager bookManager = new BookManager();
        String bookName = "A";
        //when
        bookManager.checkOut(bookName);
        //then
        assertEquals("Thank you! Enjoy the book\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenBookNotEverInLibrary() {
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
    public void testUserCanReturnABook() {
        //give
        BookManager bookManager = new BookManager();
        String bookName = "C";
        //when
        bookManager.checkOut(bookName);
        bookManager.returnBook(bookName);
        bookManager.showBooks();
        //then
        assertEquals("Thank you! Enjoy the book\r\n" +
                "Book List:\r\n" +
                "A    |a  |1990\r\n" +
                "B    |b  |1991\r\n" +
                "C    |c  |1992\r\n" +
                "D    |d  |1993\r\n" +
                "E    |e  |1994\r\n" +
                "F    |f  |1995\r\n" +
                "G    |g  |1996\r\n" +
                "H    |h  |1997\r\n" +
                "I    |i  |1998\r\n" +
                "J    |j  |1999\r\n", out.toString());
    }
}
