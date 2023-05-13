package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IUserService {
    
    public User loadUser(Long id);

    public  ResponseEntity<User> createUser(User user);

    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User toUpdateUser);
    
}
