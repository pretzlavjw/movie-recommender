package com.techelevator.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techelevator.model.User;

@Service
public class UserSqlDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        return jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
    }

	@Override
	public User getUserById(Long userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if(results.next()) {
			return mapRowToUser(results);
		} else {
			throw new RuntimeException("userId "+userId+" was not found.");
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        for (User user : this.findAll()) {
            if( user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String password, String role) {
        boolean userCreated = false;

        // create user
        String insertUser = "insert into users (username,password_hash,role) values(?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = "ROLE_" + role.toUpperCase();

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "user_id";
        userCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertUser, new String[]{id_column});
                    ps.setString(1, username);
                    ps.setString(2, password_hash);
                    ps.setString(3, ssRole);
                    return ps;
                }
                , keyHolder) == 1;
        int newUserId = (int) keyHolder.getKeys().get(id_column);

        return userCreated;
    }

//    public void setUserGenre (Long userId) {
//        String addUserGenres = "INSERT INTO user_genre (user_id, genre_id) " +
//                "VALUES (?,1), (?,2), (?,3), (?,4), (?,5), (?,6), (?,7), (?,8), (?,9), (?,10);";
//        jdbcTemplate.update(addUserGenres, userId, userId, userId, userId, userId, userId, userId, userId, userId, userId);
//    }

    public void updateGenre (Long userId, String genre) {
        String checkForGenre = "SELECT ug.user_id, ug.genre_id FROM user_genre ug JOIN genre g ON ug.genre_id = g.genre_id " +
                "WHERE ug.user_id = ? AND g.genre_name ILIKE ?;";
        SqlRowSet genreCheck = jdbcTemplate.queryForRowSet(checkForGenre, userId, genre);
        if (genreCheck.next()) {
           String removeGenrePreference = "DELETE FROM user_genre WHERE user_id = ? AND genre_id = ?;";
           jdbcTemplate.update(removeGenrePreference, userId, genreCheck.getLong("genre_id"));
        } else {
            String addGenrePreference = "INSERT INTO user_genre (user_id, genre_id) VALUES (?, (SELECT genre_id FROM genre WHERE genre_name ILIKE ?));";
            jdbcTemplate.update(addGenrePreference, userId, genre);
        }
    }

    public String getFavorites (Long userId) {
        String sql = "SELECT g.genre_name FROM genre g JOIN user_genre ug ON g.genre_id = ug.genre_id " +
                "WHERE ug.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        String favorites = "";
        while(results.next()) {
            favorites += results.getString("genre_name") + " | ";
        }
        favorites = favorites.substring(0, favorites.length() - 2);
        return favorites;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(rs.getString("role"));
        user.setActivated(true);
        return user;
    }
}
