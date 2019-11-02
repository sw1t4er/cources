package com.example.shop.service;

import com.example.shop.ShopApplication;
import com.example.shop.model.User;
import com.example.shop.repo.UserRepo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ShopApplication.class})
public class UserServiceTest {

    String TEST_EMAIL = "mail1@mail.ua";

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setFirstName("Name1");
        user.setLastName("LastName1");
        user.setEmail(TEST_EMAIL);
        userRepo.save(user);
    }

    @After
    public void tearDown() throws Exception {
        User user = userRepo.findUserByEmail(TEST_EMAIL).orElseThrow(()->new UsernameNotFoundException("err in test"));
        userRepo.delete(user);
    }

    @Test
    public void findUserByEmail() throws Exception {
        User user = userService.findUserByEmail(TEST_EMAIL);
        Assert.assertEquals(TEST_EMAIL, user.getEmail());
    }

}