public interface GameEventHandler {
    void onGameChange(GameDTO game);
    void onRoundWon(User winner);
}
