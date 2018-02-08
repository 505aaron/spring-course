package com.example.demo.services.impl;

import com.example.demo.models.GameChanger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameChangerServiceImplTest {
    private GameChangerServiceImpl gameChangerService;

    @Before
    public void setUp() {
        gameChangerService = new GameChangerServiceImpl();
    }

    @Test
    public void changeTheGame() {
        GameChanger inputGameChanger = new GameChanger();
        inputGameChanger.setIdentifier(10);

        GameChanger gameChanger = this.gameChangerService.changeTheGame(inputGameChanger);

        assertEquals(1, gameChanger.getIdentifier().longValue());
    }
}