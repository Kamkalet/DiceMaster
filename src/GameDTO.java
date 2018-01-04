import java.util.List;

public class GameDTO implements DTO{
    public final int gameId;
    public final GameConfigDTO gameConfig;
    public final List<UserInGame> players;

    public GameDTO(GameConfigDTO gameOptions, int gameId, int currentPlayer, List<UserInGame> players) {
        this.gameConfig = gameOptions;
        this.gameId = gameId;
        this.players = players;
    }

    @Override
    public void fromJSON(String JSON) {

    }

    @Override
    public String toJSON() {
        return null;
    }
}
