package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Movie {
    private Long movieId;
    private String imdbID;
    private String title;
    private String plot;
    private String poster;
    private String year;
    private String rated;
    private String runtime;
    private String genre;
    private String[] genreTypes;

    public Movie() {}

    public void populateGenreList() {
        genreTypes = genre.split(", ");
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getGenreTypes() {
        return genreTypes;
    }

    public void setGenreTypes(String[] genreTypes) {
        this.genreTypes = genreTypes;
    }
}
