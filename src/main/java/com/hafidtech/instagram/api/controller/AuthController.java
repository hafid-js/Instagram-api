package com.hafidtech.instagram.api.controller;

import com.hafidtech.instagram.api.entity.User;
import com.hafidtech.instagram.api.exceptions.UserException;
import com.hafidtech.instagram.api.repository.UserRepository;
import com.hafidtech.instagram.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException {
        User createdUser = userService.registerUser(user);

        return new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }


    @GetMapping("/signin")
    public ResponseEntity<User> signinHandler(Authentication auth) throws BadCredentialsException {

        Optional<User> opt = userRepository.findByEmail(auth.getName());

        if(opt.isPresent()) {
            return new ResponseEntity<User>(opt.get(), HttpStatus.ACCEPTED);
        }

        throw new BadCredentialsException("invalid username or password");

    }


}
