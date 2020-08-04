package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MovieManagerTest {

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
        MovieManager movieManager = new MovieManager();
        String movieName = "Movie_A";
        //when
        movieManager.checkOut(movieName);
        //then
        assertEquals("Thank you! Enjoy the movie.\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenRentMovieNotEverInLibrary() {
        //give
        MovieManager movieManager = new MovieManager();
        String movieName = "Movie_fake";
        //when
        movieManager.checkOut(movieName);
        //then
        assertEquals("Sorry, that movie is not available.\r\n", out.toString());
    }

    @Test
    public void testShowSuccessMessageWhenSucceedInReturn() {
        //give
        MovieManager movieManager = new MovieManager();
        String movieName = "Movie_A";
        //when
        movieManager.checkOut(movieName);
        movieManager.returnMovie(movieName);
        //then
        assertEquals("Thank you! Enjoy the movie.\r\n" +
                "Thank you for returning the movie.\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenReturnMovieNotEverInLibrary() {
        //give
        MovieManager movieManager = new MovieManager();
        String movieName = "Movie_Fake";
        //when
        movieManager.returnMovie(movieName);
        //then
        assertEquals("That is not a valid movie to return.\r\n", out.toString());
    }

    @Test
    public void testShowFailedMessageWhenReturnMovieAlreadyReturned() {
        //give
        MovieManager movieManager = new MovieManager();
        String movieName = "Movie_A";
        //when
        movieManager.returnMovie(movieName);
        //then
        assertEquals("That is not a valid movie to return.\r\n", out.toString());
    }
}
