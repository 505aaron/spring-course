package com.example.demo.services;

import com.example.demo.models.GameChanger;

public interface GameChangerService {
    GameChanger changeTheGame(GameChanger gameChanger) throws GameChangerException;
}
