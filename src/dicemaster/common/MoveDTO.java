package dicemaster.common;

public class MoveDTO implements DTO {
    private boolean[] dicesToReRoll;
    public MoveDTO(boolean [] dicesToReRoll){
        this.dicesToReRoll = dicesToReRoll;
    }
    public boolean[] getDicesToReRoll() {
        return dicesToReRoll;
    }

    public void setDicesToReRoll(boolean[] dicesToReRoll) {
        this.dicesToReRoll = dicesToReRoll;
    }

    @Override
    public void fromJSON() {

    }

    @Override
    public String toJSON() {
        return null;
    }
}
