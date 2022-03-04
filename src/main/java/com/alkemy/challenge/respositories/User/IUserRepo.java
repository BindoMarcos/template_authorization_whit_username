package com.alkemy.challenge.respositories.User;

import com.alkemy.challenge.models.UserDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<UserDB, Long>{
    public UserDB findByUsername(String username);

}
