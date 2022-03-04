package com.alkemy.challenge.respositories.User;

import com.alkemy.challenge.models.UserDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDB findByUsername(String username){
        return iUserRepo.findByUsername(username);
    }

    public UserDB register(UserDB user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return iUserRepo.save(user);
    }


}
