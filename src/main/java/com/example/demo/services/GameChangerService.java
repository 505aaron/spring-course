package com.example.demo.services;

import com.example.demo.models.GameChanger;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface GameChangerService {
    GameChanger changeTheGame(GameChanger gameChanger) throws GameChangerException;

    @Async
    Future<GameChanger> getTheGameChanger(Integer identifier) throws GameChangerException;
}
