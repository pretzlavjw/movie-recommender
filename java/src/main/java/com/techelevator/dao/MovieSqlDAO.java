package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Movie;

import java.util.Collections;

@Service
public class MovieSqlDAO {

    private JdbcTemplate jdbcTemplate;
    public MovieSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public 

    private Movie mapRowToMovie(SqlRowSet rs) {
        Movie movie = new Movie();

        movie.setId(rs.getLong("movie_id"));
        movie.setImdbID(rs.getString("imdb_id"));
        movie.setMovieTitle(rs.getString("movie_title"));
        movie.setGenreTypes(Collections.singletonList(rs.getString("movie_genre")));
        movie.setMovieDescription(rs.getString("movie_description"));
        movie.setMovieImageURL(rs.getString("movie_image"));
        movie.setYearReleased(rs.getDate("year_released"));
        movie.setRating(rs.getString("rating"));
        movie.setMovieLength(rs.getString("movie_length"));

        return movie;
    }

}
