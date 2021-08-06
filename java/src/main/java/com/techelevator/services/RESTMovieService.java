package com.techelevator.services;

import com.techelevator.model.Movie;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class RESTMovieService implements MovieService {
    public RestTemplate restTemplate = new RestTemplate();

    @Override
    public Movie getMovie(String imdbId) {
        Movie newMovie = null;
        try {
            newMovie = restTemplate.getForObject("http://www.omdbapi.com/?apikey=" + imdbId + "&", Movie.class);
            newMovie.populateGenreList();
        } catch (RestClientResponseException ex) {
            System.err.println("No movie found. Please try again.");
        } catch (ResourceAccessException ex) {
            System.err.println("A network error occurred.");

        }
        return newMovie;
    }
}
