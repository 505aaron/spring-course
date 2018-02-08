package com.example.demo.controllers;

import com.example.demo.models.GameChanger;
import com.example.demo.services.GameChangerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GameChangerController.class, secure = false)
public class GameChangerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameChangerService gameChangerService;

    @Test
    public void info_test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/game")
                .accept(MediaType.TEXT_PLAIN);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals("Welcome to the game changer!", result.getResponse().getContentAsString());
    }

    @Test
    public void createGameChanger_test() throws Exception {
        final String gameChangerJson = "{\"factor\":10}";

        GameChanger created = new GameChanger();
        created.setIdentifier(1515);

        Mockito.when(gameChangerService.changeTheGame(any(GameChanger.class))).thenReturn(created);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/game")
                .content(gameChangerJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost/game/1515",
                response.getHeader(HttpHeaders.LOCATION));
    }
}