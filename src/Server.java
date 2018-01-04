import java.util.List;


//done?

public interface Server {
    boolean registerClient(String nickname);
    ServerGame requestJoinGame(GameDTO game, GameEventHandler handler, PlayerType type);
    ServerGame createGame(GameConfigDTO gameConfig, GameEventHandler handler, PlayerType type);
    List<GameDTO> getListOfTables();
}
