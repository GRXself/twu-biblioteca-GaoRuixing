package com.twu.biblioteca.data;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> movieList;
    private int maxNameCharCount;
    private int maxDirectorCharCount;

    public Movies() {
        generateMovieList();
    }

    private void generateMovieList() {
        movieList = new ArrayList<>();
        String prefix = "Movie_";
        char name = 'A';
        int year = 1990;
        char director = 'a';
        int rating = 1;
        for (int i = 0; i < 5; i++) {
            String nameString = prefix + Character.toString(name);
            String directorString = prefix + Character.toString(director);
            movieList.add(new Movie(nameString,
                    year,
                    directorString,
                    rating));
            maxNameCharCount = Math.max(maxNameCharCount, nameString.length());
            maxDirectorCharCount = Math.max(maxDirectorCharCount, directorString.length());
            name += 1;
            year += 1;
            director += 1;
            rating += 1;
        }
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public int getMaxNameCharCount() {
        return maxNameCharCount;
    }

    public int getMaxDirectorCharCount() {
        return maxDirectorCharCount;
    }
}
