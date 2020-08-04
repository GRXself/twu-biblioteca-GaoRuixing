package com.twu.biblioteca.model;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isCheckOut;

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year =year;
        this.director = director;
        this.rating = rating;
        isCheckOut = false;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
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
        if (!(obj instanceof Movie)) {
            return false;
        }

        Movie that = (Movie) obj;

        if (this.getName().equals(that.getName())) {
            return true;
        }

        return false;
    }
}
