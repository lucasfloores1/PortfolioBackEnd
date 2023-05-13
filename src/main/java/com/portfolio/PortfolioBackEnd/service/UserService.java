package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.User;
import com.portfolio.PortfolioBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService implements IUserService{

    @Autowired
    public UserRepository userRepo;

    @Override
    public User loadUser(Long id) {
       return userRepo.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        User createdUser = userRepo.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User toUpdateUser) {
        User user = userRepo.findById(id).orElse(null);

        user.setUsername            (toUpdateUser.getUsername());
        user.setPassword     (toUpdateUser.getPassword());
        user.setBannerurl       (toUpdateUser.getBannerurl());
        user.setPfpurl          (toUpdateUser.getPfpurl());
        user.setName            (toUpdateUser.getName());
        user.setAboutme       (toUpdateUser.getAboutme());
        user.setTitle          (toUpdateUser.getTitle());

        User updatedUser = userRepo.save(user);

        return ResponseEntity.ok(updatedUser);
    }
}
