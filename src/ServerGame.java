public abstract class ServerGame {
    public final GameDTO gameDTO;

    public ServerGame(GameDTO gameDTO){
        this.gameDTO = gameDTO;
    }

    abstract void makeMove(MoveDTO move);

    abstract void leaveGame();

}
