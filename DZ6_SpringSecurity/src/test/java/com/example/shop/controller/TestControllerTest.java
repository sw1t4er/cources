package com.example.shop.controller;

import com.example.shop.ShopApplication;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ShopApplication.class})
public class TestControllerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUsersData() throws Exception {
        RestAssured.get("http://localhost:8081/test").then().assertThat().statusCode(200);
    }

    @Test
    public void getUsersDataBody() throws Exception {
        RestAssured.get("http://localhost:8081/test").then().assertThat().statusCode(200)
                .and().body("users[0].id",equalTo(5));
    }

}