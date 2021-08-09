package com.techelevator.controller;

import com.techelevator.dao.UserDAO;
import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@RestController
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDAO userDao;

    public UserController (UserDAO userDao ) {
        this.userDao = userDao;
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @RequestMapping(path = "/add-movie", method = RequestMethod.POST)
//    public boolean addMovie (@Valid @RequestBody String imdbId, String movieGenre, String movieTitle, String movieDescription, String movieImage, Date yearReleased, String rating, String movieLength, Principal principal) {
//        boolean addedMovie = userDao.addMovie(imdbId, movieGenre, movieTitle, movieDescription, movieImage, yearReleased, rating, movieLength);
//        return addedMovie;
//    }

//    @RequestMapping(path = "/profile", method = RequestMethod.PUT)
//    public boolean updateProfile (@RequestBody String firstName, String lastName, String emailAddress, String phoneNumber, String genreList, Principal principal) {
//        boolean updatedProfile = userDao.updateProfile(firstName, lastName, emailAddress, phoneNumber, genreList, userDao.findByUsername(principal.getName()));
//        return updatedProfile;
//   }
//
//   @RequestMapping (path = "update-status/{user-preference}", method = RequestMethod.PUT)
//    public boolean updateStatus (@PathVariable int preferenceId, String imdbId, Principal principal) {
//        boolean updatedStatus = userDao.updateStatus(preferenceId, imdbId, userDao.findByUsername(principal.getName()));
//        return updatedStatus;
//   }
}
