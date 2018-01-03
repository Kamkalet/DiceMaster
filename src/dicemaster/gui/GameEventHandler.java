package dicemaster.gui;

import dicemaster.common.GameDTO;

public interface GameEventHandler {
    void refreshGame(GameDTO game);
}
