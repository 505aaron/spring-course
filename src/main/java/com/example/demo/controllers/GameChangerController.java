package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class GameChangerController {
    @RequestMapping(value = "/game", method = RequestMethod.GET, produces = "text/plain")
    public String info() {
        return "Welcome to the game changer!";
    }
}
