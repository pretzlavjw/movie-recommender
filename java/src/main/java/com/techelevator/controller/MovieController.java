package com.techelevator.controller;

import com.techelevator.exceptions.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create/{imdbId}", method = RequestMethod.POST)
    public boolean addNewMovie(PathVariable String imdbId) throws MovieNotFoundException {

    }

}
