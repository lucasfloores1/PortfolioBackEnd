package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.User;
import com.portfolio.PortfolioBackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin( origins = "https://portfoliofrontend-f9741.web.app/" )
@CrossOrigin( origins = "https://localhost:4200/" )
public class UserController {
    
    @Autowired
    private UserService userServ;
    
    
    @GetMapping("/user/load/{id}")
    @ResponseBody
    public User loadUser(@PathVariable Long id) {
        return userServ.loadUser(id);
    }
    
    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        ResponseEntity<User> response;

        User createdUser = userServ.createUser(user).getBody();

        if (createdUser != null) {
            response = ResponseEntity.ok(createdUser);
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }    
    
    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User toUpdateUser) {
        return userServ.updateUser(id, toUpdateUser);
    }
    
}
