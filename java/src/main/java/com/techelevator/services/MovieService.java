package com.techelevator.services;

import com.techelevator.model.Movie;

public interface MovieService {
    Movie getMovie(String imdbId);
}
