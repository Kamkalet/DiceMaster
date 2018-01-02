package com.dicemaster.server.api.client;

import com.dicemaster.server.api.common.GameDTO;

public interface GameEventHandler {
    void onGameChange(GameDTO gameDTO);
}
