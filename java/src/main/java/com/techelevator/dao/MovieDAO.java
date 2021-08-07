package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getWatchList(Long userId);

}