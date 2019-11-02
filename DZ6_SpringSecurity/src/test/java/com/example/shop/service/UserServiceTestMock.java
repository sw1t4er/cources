package com.example.shop.service;

import com.example.shop.ShopApplication;
import com.example.shop.model.User;
import com.example.shop.repo.UserRepo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ShopApplication.class})
public class UserServiceTestMock {

    String TEST_EMAIL = "mail1@mail.ua";

    @MockBean
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Test
    public void findUserByEmail() throws Exception {

        //UserRepo userRepo = Mockito.mock(UserRepo.class);
        User user = new User();
        user.setFirstName("Name1");
        user.setLastName("LastName1");
        user.setEmail(TEST_EMAIL);
        userRepo.save(user);

        Mockito.when(userRepo.findUserByEmail(TEST_EMAIL)).thenReturn(java.util.Optional.of(user));

        User user2 = userService.findUserByEmail(TEST_EMAIL);

        Assert.assertEquals(TEST_EMAIL, user2.getEmail());

        Mockito.verify(userRepo, Mockito.times(1)).findUserByEmail(TEST_EMAIL);

    }

}
