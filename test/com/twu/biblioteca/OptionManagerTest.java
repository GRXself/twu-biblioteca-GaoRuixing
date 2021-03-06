package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionManagerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private OptionManager optionManager = new OptionManager();

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
    public void testUserSelectListOfBooks() {
        //given
        int userSelection = 1;
        //when
        optionManager.actOnSelection(userSelection);
        //then
        assertEquals("Book List:\r\n" +
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

    @Test
    public void testUserNotSelectValidOption() {
        //give
        int userSelection = 9;
        //when
        optionManager.actOnSelection(userSelection);
        //then
        assertEquals("Please select a valid option!\r\n", out.toString());
    }

    @Test
    public void testUserChooseQuitOption() {
        //give
        int userSelection = 0;
        //when
        boolean isUserChooseQuit = optionManager.actOnSelection(userSelection);
        //then
        assertTrue(isUserChooseQuit);
    }

    @Test
    public void testUserSelectListOfMovies() {
        //give
        int userSelection = 4;
        //when
        optionManager.actOnSelection(userSelection);
        //then
        assertEquals("Movie List\r\n" +
                "Movie_A    |1990  |Movie_a  |1\r\n" +
                "Movie_B    |1991  |Movie_b  |2\r\n" +
                "Movie_C    |1992  |Movie_c  |3\r\n" +
                "Movie_D    |1993  |Movie_d  |4\r\n" +
                "Movie_E    |1994  |Movie_e  |5\r\n", out.toString());
    }
}
