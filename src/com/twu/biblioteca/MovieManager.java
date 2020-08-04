package com.twu.biblioteca;

import com.twu.biblioteca.data.Movies;
import com.twu.biblioteca.model.Movie;

import java.util.List;

public class MovieManager {
    private Movies movies;

    public MovieManager() {
        movies = new Movies();
    }

    public void showMovies() {
        System.out.println("Movie List");
        movies.getMovieList().forEach(movie -> {
            if (!movie.isCheckOut())
                movieConsoleLinePrinter(movie);
        });
    }

    private void movieConsoleLinePrinter(Movie movie) {
        System.out.print(movie.getName());
        StringBuilder nameWhiteSpace = new StringBuilder();
        for (int i = movies.getMaxNameCharCount() - movie.getName().length() + 4; i > 0; i--) {
            nameWhiteSpace.append(" ");
        }
        System.out.print(nameWhiteSpace);
        System.out.print("|");

        System.out.print(movie.getYear());
        StringBuilder yearWhiteSpace = new StringBuilder();
        for (int i = 2; i > 0; i--) {
            yearWhiteSpace.append(" ");
        }
        System.out.print(yearWhiteSpace);
        System.out.print("|");

        System.out.print(movie.getDirector());
        StringBuilder directorWhiteSpace = new StringBuilder();
        for (int i = movies.getMaxDirectorCharCount() - movie.getDirector().length() + 2; i > 0; i--) {
            directorWhiteSpace.append(" ");
        }
        System.out.print(directorWhiteSpace);
        System.out.print("|");

        System.out.println(movie.getRating());
    }

    public void checkOut(String movieNameSearchString) {
        List<Movie> movies = this.movies.getMovieList();
        int movieIndex = movies.indexOf(new Movie(movieNameSearchString));
        if (movieIndex >= 0) {
            Movie movie = movies.get(movieIndex);
            if (movie.isCheckOut()) {
                showFailedMessageOnNotCheckOut();
            }
            else {
                movie.setCheckOut(true);
                showSucceedMessageOnCheckOut();
            }
        }
        else {
            showFailedMessageOnNotCheckOut();
        }
    }

    private void showSucceedMessageOnCheckOut() {
        System.out.println("Thank you! Enjoy the movie.");
    }

    private void showFailedMessageOnNotCheckOut() {
        System.out.println("Sorry, that movie is not available.");
    }

    public void returnMovie(String movieNameSearchString) {
        List<Movie> movies = this.movies.getMovieList();
        int movieIndex = movies.indexOf(new Movie(movieNameSearchString));
        if (movieIndex >= 0) {
            Movie movie = movies.get(movieIndex);
            if (movie.isCheckOut()) {
                movie.setCheckOut(false);
                showSuccessMessageOnReturn();
            }
            else {
                showFailedMessageOnBadReturn();
            }
        }
        else {
            showFailedMessageOnBadReturn();
        }
    }

    private void showFailedMessageOnBadReturn() {
        System.out.println("That is not a valid movie to return.");
    }

    private void showSuccessMessageOnReturn() {
        System.out.println("Thank you for returning the movie.");
    }
}
