package com.techelevator.controller;

import com.techelevator.dao.MovieDAO;
import com.techelevator.exceptions.MovieNotFoundException;
import com.techelevator.model.Movie;
import com.techelevator.services.MovieService;
import com.techelevator.services.RESTMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movie")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    private RESTMovieService restMovieService = new RESTMovieService();
    private MovieDAO movieDAO;

    public MovieController (MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create/{imdbId}", method = RequestMethod.POST)
    public void addNewMovie(@PathVariable String imdbId) {
        Movie newMovie = restMovieService.getMovie(imdbId);
        movieDAO.addMovie(newMovie);

    }

    //Still needs to be debugged. Passing in (null, userId, null)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "update-status/{userId}/{movieId}/{userPreference}", method = RequestMethod.POST)
    public void updateStatus (@PathVariable Long userId, @PathVariable Long movieId, @PathVariable String userPreference) {
        movieDAO.updateUserPreferenceStatus(userId, movieId, userPreference);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/watchlist/{userId}", method = RequestMethod.GET)
    public List<Movie> getWatchList(@PathVariable Long userId) throws MovieNotFoundException {
        List<Movie> watchList = movieDAO.getList(userId, "watchlist");
        if(watchList == null) throw new MovieNotFoundException();
        else return watchList;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/favorited/{userId}", method = RequestMethod.GET)
    public List<Movie> getFavoritedList(@PathVariable Long userId) throws MovieNotFoundException {
        List<Movie> favoritedList = movieDAO.getList(userId, "favorited");
        if(favoritedList == null) throw new MovieNotFoundException();
        else return favoritedList;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/get-movie/{userId}", method = RequestMethod.GET)
    public Movie getRecommendedMovie(@PathVariable Long userId){
        Movie recommendedMovie = movieDAO.getRecommendedMovie(userId);
        return  recommendedMovie;
    }
    

}
