package com.example.shop.controller;

import com.example.shop.model.User;
import com.example.shop.pojo.UserResponce;
import com.example.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;

@Slf4j
@RestController(value ="/test")
public class TestController {

    @Autowired
    UserService userService;
    UserResponce userResponce;

    @GetMapping
    public UserResponce getUsersData() {
        log.info("select all users from UserDetailPojo");
        userResponce = new UserResponce(userService.findAll());
        return userResponce;
    }

}
