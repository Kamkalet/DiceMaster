public class GameConfigDTO implements DTO{
    public final String tableName;
    public final int maxPlayers;
    public final int roundsToWin;
    public final GameType gameType;
    public final int hardBotsCount;
    public final int easyBotsCount;

    public GameConfigDTO(int maxPlayers, int roundsToWin, GameType gameType, int hardBotsCount, int easyBotsCount,String tableName ){
        this.maxPlayers = maxPlayers;
        this.roundsToWin = roundsToWin;
        this.gameType = gameType;
        this.hardBotsCount = hardBotsCount;
        this.easyBotsCount = easyBotsCount;
        this.tableName = tableName;
    }

    @Override
    public void fromJSON(String JSON) {

    }

    @Override
    public String toJSON() {
        return null;
    }
}
