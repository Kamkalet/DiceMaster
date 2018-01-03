package dicemaster.server;

import dicemaster.common.GameConfigDTO;
import dicemaster.common.GameDTO;
import dicemaster.common.UserType;
import dicemaster.gui.GameEventHandler;

import java.util.List;

public interface Server {
    boolean registerClient(String nick);
    ServerGame createGame(GameConfigDTO gameConfigDTO, GameEventHandler gameEventHandler, UserType userType);
    ServerGame joinGame(GameDTO gameDTO, GameEventHandler gameEventHandler, UserType userType);
    List<GameDTO> getGames();
}
