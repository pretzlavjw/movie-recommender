package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Movie not found.")
public class MovieNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public MovieNotFoundException() {
        super("Movie not found.");
    }
}
