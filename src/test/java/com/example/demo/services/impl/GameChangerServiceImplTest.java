package com.example.demo.services.impl;

import com.example.demo.models.GameChanger;
import com.example.demo.services.GameChangerException;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Test
    public void getTheGameChanger_test() throws ExecutionException, InterruptedException, GameChangerException {
        GameChanger inputGameChanger = this.gameChangerService.changeTheGame(new GameChanger());

        Future<GameChanger> gameChangerFuture = this.gameChangerService.getTheGameChanger(inputGameChanger.getIdentifier());

        assertEquals(inputGameChanger, gameChangerFuture.get());
    }
}