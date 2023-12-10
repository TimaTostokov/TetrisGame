package com.example.my.tetrisgame.presenter;

public class GamePresenter {

    private GameView mGameView;
    private GameModel mGameModel;
    private GameStatus mStatus;

    public void setGameView(GameView gameView) {
        mGameView = gameView;
    }

    public void setGameModel(GameModel gameModel) {
        mGameModel = gameModel;
    }

    public void init() {
        mGameModel.init();
        mGameView.init(mGameModel.getGameSize());
        mGameModel.setGameOverListener(() -> setStatus(GameStatus.OVER));
        mGameModel.setScoreUpdatedListener(mGameView::setScore);
        setStatus(GameStatus.START);
    }

    public void turn(GameTurn gameTurn) {
        mGameModel.turn(gameTurn);
    }

    public void changeStatus() {
        if (mStatus == GameStatus.PLAYING) {
            pauseGame();
        } else {
            startGame();
        }
    }

    private void pauseGame() {
        setStatus(GameStatus.PAUSED);
        mGameModel.pauseGame();
    }

    private void startGame() {
        setStatus(GameStatus.PLAYING);
        mGameModel.startGame(mGameView::draw);
    }

    public void setStatus(GameStatus status) {
        if (mStatus == GameStatus.OVER || status == GameStatus.START) {
            mGameModel.newGame();
        }
        mStatus = status;
        mGameView.setStatus(status);
    }

}
