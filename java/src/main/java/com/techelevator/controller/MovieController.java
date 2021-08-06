package com.techelevator.controller;

import com.techelevator.dao.MovieDAO;
import com.techelevator.exceptions.MovieNotFoundException;
import com.techelevator.model.Movie;
import com.techelevator.services.RESTMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    private RESTMovieService restMovieService;
    private MovieDAO movieDAO;

    public MovieController (MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create/{imdbId}", method = RequestMethod.POST)
    public void addNewMovie(@PathVariable String imdbId) throws MovieNotFoundException {
        Movie newMovie = restMovieService.getMovie(imdbId);

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/watchlist/{userId}", method = RequestMethod.GET)
    public List<Movie> getUserMovieWatchList(@PathVariable Long userId) throws MovieNotFoundException {
        List<Movie> watchList = movieDAO.getUserMovieWatchList(userId);
        if(watchList == null) throw new MovieNotFoundException();
        else return watchList;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/get-movie/{userId}", method = RequestMethod.GET)
    public Movie getRecommendedMovie(@PathVariable Long userId) throws MovieNotFoundException {
        Movie recommendedMovie = movieDAO.getMovie(userId);
        if(recommendedMovie == null) throw new MovieNotFoundException();
        else return recommendedMovie;
    }

}
