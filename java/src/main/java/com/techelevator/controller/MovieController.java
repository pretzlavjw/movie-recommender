package com.techelevator.controller;

import com.techelevator.exceptions.MovieNotFoundException;
import com.techelevator.model.Movie;
import com.techelevator.services.RESTMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    private RESTMovieService restMovieService;

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create/{imdbId}", method = RequestMethod.POST)
    public void addNewMovie(@PathVariable String imdbId) throws MovieNotFoundException {
        Movie newMovie = restMovieService.getMovie(imdbId);

    }

}
