package agh.to2.dicemaster.game.model;

import agh.to2.dicemaster.game.poker.PokerGameManager;

import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    private PokerGameManager gameManager;
    private int secondsToCount;

    public Timer(PokerGameManager gameManager, int secondsToCount) {
        this.gameManager = gameManager;
        this.secondsToCount = secondsToCount;
    }

    @Override
    public void run() {
        while (!gameManager.hasEnded()) {
            try {
                TimeUnit.SECONDS.sleep(secondsToCount);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            gameManager.onTurnEnd();
        }
    }

}

