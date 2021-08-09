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
        String url = "http://www.omdbapi.com/?i=" + imdbId + "&apikey=65bfb6b8";
        try {
            newMovie = restTemplate.getForObject(url, Movie.class);
//            newMovie.populateGenreList();
        } catch (RestClientResponseException ex) {
            System.err.println("No movie found. Please try again.");
        } catch (ResourceAccessException ex) {
            System.err.println("A network error occurred.");

        }
        return newMovie;
    }
}
