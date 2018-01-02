package com.dicemaster.server.api.server;

import com.dicemaster.server.api.common.GameDTO;

public abstract class GameParticipant {
    public abstract void notifyGameStateChange(GameDTO gameDTO);
    public abstract void registerPlayerEventHandler(PlayerEventHandler playerEventHandler);

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
