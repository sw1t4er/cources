package com.nbu.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.nbu.demo.model.User;
import com.nbu.demo.model.UserView;
import com.nbu.demo.pojo.UserDetail;
import com.nbu.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/api/user", produces = "application/json")
public class UserInfoController {

    @Autowired
    UserService userService;
    User user;

    //@GetMapping("getAllUsers")
    @GetMapping()
    @JsonView({UserView.MainUserView.class})
    public List<User> getUserData() {
        log.info("select all users from UserInfoController");
        return userService.findAll();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("create")
    @JsonView({UserView.MainUserView.class})
    public User createUser(@Valid @RequestBody UserDetail userDetail) {
        user = new User();
        user.setFirstName(userDetail.getFirstName());
        user.setLastName(userDetail.getLastName());
        user.setEmail(userDetail.getEmail());
        userService.save(user);
        return user;
    }

}
