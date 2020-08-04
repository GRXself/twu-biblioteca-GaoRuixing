package com.twu.biblioteca;

import com.twu.biblioteca.data.Movies;
import com.twu.biblioteca.model.Movie;

public class MovieManager {
    private Movies movies;

    public MovieManager() {
        movies = new Movies();
    }

    public void showMovies() {
        System.out.println("Movie List");
        movies.getMovieList().forEach(movie -> {
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
}
