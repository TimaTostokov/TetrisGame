package com.example.my.tetrisgame.model;

public class GameModelFactory {

    private GameModelFactory() {}

    public static TetrisGameModel newGameModel(GameType gameType) {
        if (gameType == GameType.TETRIS) {
            return new TetrisGameModel();
        }
        return null;
    }

}