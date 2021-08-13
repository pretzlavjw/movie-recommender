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
@CrossOrigin
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDAO userDao;

    public UserController (UserDAO userDao ) {
        this.userDao = userDao;
    }

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

    @RequestMapping(path = "/update/{id}/{genre}", method = RequestMethod.POST)
    public void updateGenre (@PathVariable Long id, @PathVariable String genre) {
        userDao.updateGenre(id, genre);
    }

    @RequestMapping(path = "/favorites/{id}", method = RequestMethod.GET)
    public String getFavorites (@PathVariable Long id) {
        return userDao.getFavorites(id);
    }
}
