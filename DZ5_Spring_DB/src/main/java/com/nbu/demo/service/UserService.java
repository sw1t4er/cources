package com.nbu.demo.service;

import com.nbu.demo.repo.UserRepo;
import com.nbu.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepo userRepo;

    @Autowired
    public UserService (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional <User> findById(Long id) {
        return userRepo.findById(id);
    }

    public void save(User user) {
        //if ((user.getEmail()).equals( userRepo.findUserByEmail(user.getEmail()) ) ) {
        //System.out.println(userRepo.findUserByEmail(user.getEmail()));
        if (userRepo.findUserByEmail(user.getEmail())!=null) {
            System.out.println("This User: " + user.getEmail().toString() + " EXIST");
        }
        else {
            userRepo.save(user);
        }
        logger.info("User: " + user.toString() + " added");
    }

    public void update(User user) { userRepo.save(user); }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}