package com.hafidtech.instagram.api.controller;

import com.hafidtech.instagram.api.entity.User;
import com.hafidtech.instagram.api.exceptions.UserException;
import com.hafidtech.instagram.api.response.MessageResponse;
import com.hafidtech.instagram.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserByIdHandler(@PathVariable Integer id) throws UserException {
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findUserByUsernameHandler(@PathVariable String username) throws UserException {
        User user = userService.findUserByUsername(username);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/follow/{followUserId}")
    public ResponseEntity<MessageResponse> followUserHandler(@PathVariable Integer followUserId) {

//        MessageResponse res = userService.followUser(followUserId, followUserId);
        return null;
    }

    @PutMapping("/unfollow/{userId}")
    public ResponseEntity<MessageResponse> unfollowUserHandler(@PathVariable Integer userId) {

//        MessageResponse res = userService.followUser(followUserId, followUserId);
        return null;
    }

    @PutMapping("/req")
    public ResponseEntity<MessageResponse> findUserProfileHandler(@RequestHeader("Authorization") String token) {

        return null;
    }

    @GetMapping("/m/{userId}")
    public ResponseEntity<List<User>> findByUserIdsHandler(@PathVariable List<Integer> userId) throws UserException {
        List<User> users = userService.findUserByIds(userId);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
// api/users/search?q="query"
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUserHandler(@RequestParam("q") String query) throws UserException {
        List<User> users = userService.searchUser(query);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> updateUserHandler(@RequestHeader("Authorization") String token, @RequestBody User user) throws UserException {

//        User updateUser = userService.updateUserDetails(user, user);
        return null;
    }
}
