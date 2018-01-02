package com.dicemaster.server.api.server;

import com.dicemaster.server.api.common.MoveDTO;

public interface PlayerEventHandler {
    void onMoveRequest(MoveDTO moveDTO);
    void onPlayerLeft();
}
