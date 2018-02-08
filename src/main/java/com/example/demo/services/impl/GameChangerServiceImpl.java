package com.example.demo.services.impl;

import com.example.demo.models.GameChanger;
import com.example.demo.services.GameChangerException;
import com.example.demo.services.GameChangerService;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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

    @Override
    public Future<GameChanger> getTheGameChanger(Integer identifier) throws GameChangerException {
        GameChanger gameChanger = null;
        try {
            Thread.sleep(500);
            gameChanger = this.gameChangers.stream()
                    .filter(g -> g.getIdentifier().equals(identifier))
                    .findFirst()
                    .orElse(null);

        } catch (InterruptedException e) {
            throw new GameChangerException(e);
        }

        return AsyncResult.forValue(gameChanger);
    }
}
