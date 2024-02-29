package com.csmanager;

import com.csmanager.controller.GameService;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.startGame();
    }
}
