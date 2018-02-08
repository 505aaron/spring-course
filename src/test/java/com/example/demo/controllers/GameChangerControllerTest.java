package com.example.demo.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GameChangerController.class, secure = false)
public class GameChangerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void info_test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/game")
                .accept(MediaType.TEXT_PLAIN);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals("Welcome to the game changer!", result.getResponse().getContentAsString());
    }
}