package com.alkemy.challenge.services;

import com.alkemy.challenge.models.UserDB;
import com.alkemy.challenge.respositories.User.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserDB findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public UserDB register(UserDB user){
        return userRepo.register(user);
    }
}
