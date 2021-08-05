package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Movie {
    private Long id;
    private String imdbID;
    private String movieTitle;
    private String movieDescription;
    private String movieImageURL;
    private Date yearReleased;
    private String rating;
    private String movieLength;
    private List<String> genreTypes;

    public Movie(String imdbID) {
        this.imdbID = imdbID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieImageURL() {
        return movieImageURL;
    }

    public void setMovieImageURL(String movieImageURL) {
        this.movieImageURL = movieImageURL;
    }

    public Date getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(Date yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public List<String> getGenreTypes() {
        return genreTypes;
    }

    public void setGenreTypes(List<String> genreTypes) {
        this.genreTypes = genreTypes;
    }
}
