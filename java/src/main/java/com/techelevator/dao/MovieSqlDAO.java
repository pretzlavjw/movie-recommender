package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Movie;
import com.techelevator.model.User;

import java.sql.PreparedStatement;
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

    public List<Movie> generateRecommendedMovieList(Long userId) {
//        List<Movie> recommendedMovies = new ArrayList<>();
        String sql = "SELECT m.* " +
                "FROM movie_genre mg " +
                "JOIN movies m ON mg.movie_id = m.movie_id " +
                "JOIN user_movie um ON m.movie_id = um.movie_id " +
                "JOIN users u ON um.user_id = u.user_id " +
                "JOIN user_genre ug ON u.user_id = ug.user_id " +
                "WHERE mg.genre_id = ug.genre_id AND user_id = ? " +
                "AND m.movie_id NOT IN um.movie_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (results.next()) {
            recommendedMovies.add(mapRowToMovie(results));
        }
        Collections.shuffle(recommendedMovies);
        return recommendedMovies;
    }

    public Movie getRecommendedMovie(Long userID) {
        if(!recommendedMovies.equals(null)) {
            Movie movie = recommendedMovies.get(recommendedMovies.size() - 1);
            recommendedMovies.remove(recommendedMovies.size() - 1);
            return movie;
        }
        return null;
    }

    public void addMovie(Movie newMovie) {
        String sql = "INSERT INTO movies " +
                "        (imdb_id, movie_title, movie_description, " +
                "        movie_image, year_released, rating, movie_length) " +
                "VALUES (?, ? ,?, ?, ?, ?, ?);";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                newMovie.getImdbID(),
                newMovie.getTitle(),
                newMovie.getPlot(),
                newMovie.getPoster(),
                newMovie.getYear(),
                newMovie.getRated(),
                newMovie.getRuntime());
        newMovie.populateGenreList();
        populateNewMovieGenres(newMovie.getGenre(), newId);
    }

//    public void populateNewMovieGenres(String[] genreArray, Long movieId) {
//        String[] movieGenres = genreArray;
//        for (String genre : movieGenres) {
////            String sql = "SELECT * FROM genre WHERE genre_name = ?;";
//            String checkGenre = "SELECT * FROM genre WHERE genre_name = ?;";
//            SqlRowSet genres = jdbcTemplate.queryForRowSet(genre);
//            if (genres.next())
//                String sql = "INSERT INTO movie_genre (movie_id, genre_id) " +
//                        "SELECT genre_id FROM genre WHERE genre_name = ? " +
//                        "SELECT movie_id FROM movies WHERE movie_id = ?";
//        }
//    }

    public void populateNewMovieGenres(String genres, Long movieId) {
            String newGenres = "%" + genres + "%";
            String checkGenre = "SELECT * FROM genre WHERE genre_name LIKE ?;";
            SqlRowSet pippin = jdbcTemplate.queryForRowSet(checkGenre, newGenres);
            while (pippin.next()) {
                String genreName = "SELECT genre_id FROM genre WHERE genre_name = ?;";
                SqlRowSet bernie = jdbcTemplate.queryForRowSet(genreName, pippin.getString("genre_name"));
                Long newGenreId = bernie.getLong("genre_id");
                String sql = "INSERT INTO movie_genre (movie_id, genre_id) " +
                        "VALUES (?, ?);";
                jdbcTemplate.update(sql, movieId, newGenreId);
            }

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
