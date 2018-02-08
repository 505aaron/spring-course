package com.example.demo.controllers;


import com.example.demo.models.GameChanger;
import com.example.demo.services.GameChangerException;
import com.example.demo.services.GameChangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController()
public class GameChangerController {

    @Autowired
    private GameChangerService gameChanger;

    @GetMapping(value = "/game", produces = MediaType.TEXT_PLAIN_VALUE)
    public String info() {
        return "Welcome to the game changer!";
    }

    @PostMapping(value = "/game")
    public ResponseEntity<Void> createGameChanger(@RequestBody GameChanger gameChanger) throws GameChangerException {
        GameChanger created = this.gameChanger.changeTheGame(gameChanger);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "game/{identifier}")
    public GameChanger findGameChanger(@PathVariable Integer identifier) throws ExecutionException, InterruptedException, GameChangerException {
        Future<GameChanger> gameChangerFuture = this.gameChanger.getTheGameChanger(identifier);

        return gameChangerFuture.get();
    }
}
