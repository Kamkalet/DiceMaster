package com.dicemaster.server.api.client;

import com.dicemaster.server.api.common.GameConfigDTO;
import com.dicemaster.server.api.common.GameDTO;

import java.util.List;

public interface Server {

    ServerGame createGame(GameConfigDTO gameConfigDTO, GameEventHandler gameEventHandler, UserType userType);
    ServerGame requestJoinGame(GameDTO gameDTO, GameEventHandler gameEventHandler, UserType userType);

    List<GameDTO> getAvailableGames();
    boolean registerClient(String username);
}
