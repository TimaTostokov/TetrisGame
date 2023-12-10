package com.example.my.tetrisgame.view;

import android.widget.Button;
import android.widget.TextView;

import com.example.my.tetrisgame.presenter.GameView;

public class GameViewFactory {

    private GameViewFactory() {
    }

    public static GameView newGameView(GameFrame gameFrame, TextView gameScoreText, TextView gameStatusText, Button gameCtlBtn) {
        return new GameViewImpl(gameFrame, gameScoreText, gameStatusText, gameCtlBtn);
    }

}