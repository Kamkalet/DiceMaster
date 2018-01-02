package com.dicemaster.server.api.client;

import com.dicemaster.server.api.common.GameDTO;
import com.dicemaster.server.api.common.MoveDTO;

public abstract class ServerGame {

    private GameDTO gameDTO;

    public ServerGame(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
    }

    abstract void makeMove(MoveDTO moveDTO);
    abstract void leaveGame();
}
