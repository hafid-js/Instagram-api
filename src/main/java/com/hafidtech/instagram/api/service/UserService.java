package com.hafidtech.instagram.api.service;

import com.hafidtech.instagram.api.entity.User;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface UserService {

    public User registerUser(User user) throws ExecutionControl.UserException;
    public User findUserById(Integer userId) throws ExecutionControl.UserException;
    public User findUserByProfile(String token) throws ExecutionControl.UserException;
    public User findUserByUsername(String username) throws ExecutionControl.UserException;
    public String followUser(Integer reqUserId, Integer followUserId) throws ExecutionControl.UserException;
    public String unFollowUser(Integer reqUserId, Integer followUserId) throws ExecutionControl.UserException;
    public List<User> findUserByIds(List<Integer> userIds) throws ExecutionControl.UserException;
    public List<User> searchUser(String query) throws ExecutionControl.UserException;
    public User updateUserDetails(User updatedUser, User existingUser) throws ExecutionControl.UserException;

}
