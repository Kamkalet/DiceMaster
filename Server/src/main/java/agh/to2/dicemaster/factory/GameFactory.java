package agh.to2.dicemaster.factory;

import agh.to2.dicemaster.common.api.GameConfigDTO;
import agh.to2.dicemaster.common.api.GameType;
import agh.to2.dicemaster.ngames.NGame;
import agh.to2.dicemaster.poker.PokerGame;
import agh.to2.dicemaster.server.api.Game;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GameFactory {

    private int id = 0;

    public Game createGame(GameConfigDTO gameConfigDTO) {
        this.id += 1;
        if(gameConfigDTO.getGameType().equals(GameType.POKER)){
            return new PokerGame(this.id,gameConfigDTO);
        }
        if(gameConfigDTO.getGameType().equals(GameType.NPLUS)){
            return new NGame(this.id,gameConfigDTO);
        }
        if(gameConfigDTO.getGameType().equals(GameType.NTIMES)){
            return new NGame(this.id,gameConfigDTO);
        }

        throw new NotImplementedException();
    }
}