package agh.to2.dicemaster.bot.model;

import agh.to2.dicemaster.bot.DiceInputDTO;
import agh.to2.dicemaster.bot.DiceOutputDTO;
import agh.to2.dicemaster.bot.IOConverter;
import agh.to2.dicemaster.common.api.GameDTO;
import agh.to2.dicemaster.common.api.MoveDTO;
import agh.to2.dicemaster.server.User;

public abstract class Bot extends User{

    protected DiceOutputDTO result;

    abstract DiceOutputDTO getDicesToThrow(DiceInputDTO input);

    Bot(){
        result = new DiceOutputDTO();
    }

    @Override
    public void notifyGameStateChange(GameDTO gameDTO) {

        IOConverter converter = new IOConverter();

        DiceInputDTO diceInput = converter.getDiceInputDTO(gameDTO);

        DiceOutputDTO diceOutput = this.getDicesToThrow(diceInput);

        // FIXME fix the problem with abstraction of MoveDTO or make in a different way
        MoveDTO moveDTO = converter.makeNewMoveDTO(diceOutput);

        //this field is assigned to every User
        this.playerEventHandler.onMoveRequest(moveDTO);

    }

}
