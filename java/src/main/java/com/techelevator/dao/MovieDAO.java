package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getList(Long userId, String preference);
    Movie getRecommendedMovie(Long userID);
    List<Movie> generateRecommendedMovieList(Long userId);
    void addMovie(Movie newMovie);
    void updateUserPreferenceStatus(Long userId, Long movieId, String userPreference);

}