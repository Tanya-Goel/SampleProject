package com.example.tanya.sampleproject.others;

public class Details {
    String title;
    int rating;
    int year;
    String genre;
    String URL;

    public Details(String title, int rating, int year, String genre,String URL) {
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.genre = genre;
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getURL() {
        return URL;
    }
}
