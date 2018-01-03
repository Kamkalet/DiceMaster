package dicemaster.common;

import java.util.List;

public class GameDTO implements DTO {
    private int id;
    private GameConfigDTO gameConfig;
    private List<UserInGame> players;
    private List<User> observers;

    @Override
    public void fromJSON() {

    }

    @Override
    public String toJSON() {
        return null;
    }
}
