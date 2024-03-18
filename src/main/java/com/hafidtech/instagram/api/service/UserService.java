package com.hafidtech.instagram.api.service;

import com.hafidtech.instagram.api.entity.User;
import com.hafidtech.instagram.api.exceptions.UserException;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface UserService {

    public User registerUser(User user) throws UserException;
    public User findUserById(Integer userId) throws UserException;
    public User findUserByProfile(String token) throws UserException;
    public User findUserByUsername(String username) throws UserException;
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException;
    public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException;
    public List<User> findUserByIds(List<Integer> userIds) throws UserException;
    public List<User> searchUser(String query) throws UserException;
    public User updateUserDetails(User updatedUser, User existingUser) throws UserException;

}
