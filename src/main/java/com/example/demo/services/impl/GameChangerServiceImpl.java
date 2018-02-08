package com.example.demo.services.impl;

import com.example.demo.models.GameChanger;
import com.example.demo.services.GameChangerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameChangerServiceImpl implements GameChangerService {
    private List<GameChanger> gameChangers;

    public GameChangerServiceImpl() {
        this.gameChangers = new ArrayList<>();
    }

    @Override
    public GameChanger changeTheGame(GameChanger gameChanger) {
        this.gameChangers.add(gameChanger);
        gameChanger.setIdentifier(this.gameChangers.size());

        return gameChanger;
    }
}
