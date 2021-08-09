package com.techelevator.controller;

import com.techelevator.dao.MovieDAO;
import com.techelevator.exceptions.MovieNotFoundException;
import com.techelevator.model.Movie;
import com.techelevator.services.MovieService;
import com.techelevator.services.RESTMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    private RESTMovieService restMovieService = new RESTMovieService();
    private MovieDAO movieDAO;

    public MovieController (MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create/{imdbId}", method = RequestMethod.POST)
    public void addNewMovie(@PathVariable String imdbId) {
        Movie newMovie = restMovieService.getMovie(imdbId);
        movieDAO.addMovie(newMovie);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/watchlist/{userId}", method = RequestMethod.GET)
    public List<Movie> getWatchList(@PathVariable Long userId) throws MovieNotFoundException {
        List<Movie> watchList = movieDAO.getWatchList(userId);
        if(watchList == null) throw new MovieNotFoundException();
        else return watchList;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/get-movie/{userId}", method = RequestMethod.GET)
    public Movie getRecommendedMovie(@PathVariable Long userId){
        Movie recommendedMovie = movieDAO.getRecommendedMovie(userId);
        if(recommendedMovie == null) {
            movieDAO.generateRecommendedMovieList(userId);
            recommendedMovie = movieDAO.getRecommendedMovie(userId);
            return  recommendedMovie;
        }
        else return recommendedMovie;
    }
    

}
