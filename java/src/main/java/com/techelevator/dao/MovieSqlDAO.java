package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Movie;
import com.techelevator.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieSqlDAO implements MovieDAO {

    public List<Movie> recommendedMovies = new ArrayList<>();

    private JdbcTemplate jdbcTemplate;
    public MovieSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public List<Movie> getFavorites() {
//        List<Movie> movies = new ArrayList<>();
//        String sql = "SELECT m.* " +
//                "FROM movies m " +
//                "JOIN user_movie um ON m.movie_ = um.movie_id " +
//                "JOIN user u ON um.user_id = u.user_id " +
//                "WHERE " +
//                "        u.user_id = ? AND  " +
//                "        um.user_preference_description = 'favorites';";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql/*, id, moviePreference*/);
//        while (results.next()) {
//            movies.add(mapRowToMovie(results));
//        }
//        return movies;
//    }

    @Override
    public List<Movie> getWatchList(Long userId) {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT m.* " +
                "FROM movies m " +
                "JOIN user_movie um ON m.movie_id = um.movie_id " +
                "JOIN user u ON um.user_id = u.user_id " +
                "WHERE " +
                "        u.user_id = ? AND  " +
                "        um.user_preference_description = 'watch list';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    public List<Movie> getRecommendedMovies(Long userId) {
//        List<Movie> recommendedMovies = new ArrayList<>();
        String sql = "SELECT m.*\n" +
                "FROM movie_genre mg\n" +
                "JOIN movies m ON mg.movie_id = m.movie_id\n" +
                "JOIN user_movie um ON m.movie_id = um.movie_id\n" +
                "JOIN users u ON um.user_id = u.user_id\n" +
                "JOIN user_genre ug ON u.user_id = ug.user_id\n" +
                "WHERE mg.genre_id = ug.genre_id AND user_id = ?\n" +
                "\n" +
                "EXCEPT\n" +
                "\n" +
                "SELECT *\n" +
                "FROM user_movie\n" +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (results.next()) {
            recommendedMovies.add(mapRowToMovie(results));
        }
        return recommendedMovies;
    }

    private Movie mapRowToMovie(SqlRowSet rs) {
        Movie movie = new Movie();

        movie.setMovieId(rs.getLong("movie_id"));
        movie.setImdbID(rs.getString("imdb_id"));
        movie.setTitle(rs.getString("movie_title"));
        movie.setPlot(rs.getString("movie_description"));
        movie.setPoster(rs.getString("movie_image"));
        movie.setYear(rs.getString("year_released"));
        movie.setRated(rs.getString("rating"));
        movie.setRuntime(rs.getString("movie_length"));

        return movie;
    }

}
