package agh.to2.dicemaster.common.api;

import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CommonClassesSerializationTest {

    private MessageConverter messageConverter = new Jackson2JsonMessageConverter();

    @Test
    public void dices() {
        Dices dices = new Dices();
        dices.getDicesScore()[2] = DiceNumbers.TWO;
        dices.getDicesScore()[3] = DiceNumbers.FIVE;
        dices.getDicesScore()[4] = DiceNumbers.FOUR;
        
        Message dicesMessage = messageConverter.toMessage(dices, createJsonProperties());

        Dices unserialized = (Dices) messageConverter.fromMessage(dicesMessage);

        assertEquals(unserialized.getDicesScore()[2], dices.getDicesScore()[2]);
        assertEquals(unserialized.getDicesScore()[3], dices.getDicesScore()[3]);
        assertEquals(unserialized.getDicesScore()[4], dices.getDicesScore()[4]);
    }

    @Test
    public void gameConfigDto() {
        GameConfigDTO gameConfigDTO = new GameConfigDTO();
        gameConfigDTO.setRoundsToWin(4);
        gameConfigDTO.setEasyBotsCount(3);
        gameConfigDTO.setTableName("test");

        Message gameConfigMessage = messageConverter.toMessage(gameConfigDTO, createJsonProperties());

        GameConfigDTO unserialized = (GameConfigDTO) messageConverter.fromMessage(gameConfigMessage);

        assertEquals(unserialized.getRoundsToWin(), gameConfigDTO.getRoundsToWin());
        assertEquals(unserialized.getEasyBotsCount(), gameConfigDTO.getEasyBotsCount());
        assertEquals(unserialized.getTableName(), gameConfigDTO.getTableName());
    }


    @Test
    public void gameDto() {
        UserInGame user1 = new UserInGame();
        user1.setUserName("tester1");

        UserInGame user2 = new UserInGame();
        user2.setUserName("tester2");

        GameDTO gameDTO = new GameDTO();
        gameDTO.setScoreToWin(12);
        gameDTO.setObservers(Arrays.asList("test1", "test2", "test3"));
        gameDTO.setPlayers(Arrays.asList(user1, user2));

        Message message = messageConverter.toMessage(gameDTO, createJsonProperties());

        GameDTO unserialized = (GameDTO) messageConverter.fromMessage(message);

        assertEquals(unserialized.getScoreToWin(), gameDTO.getScoreToWin());
        assertEquals(unserialized.getObservers(), gameDTO.getObservers());
        assertEquals(unserialized.getPlayers().get(0).getUserName(),
                gameDTO.getPlayers().get(0).getUserName());

        assertEquals(unserialized.getPlayers().get(1).getUserName(),
                gameDTO.getPlayers().get(1).getUserName());
    }


    @Test
    public void moveDto() {
        MoveDTO moveDTO = new MoveDTO();
        moveDTO.setDicesToReRoll(new boolean[]{true, false, false, true, true, false});

        Message message = messageConverter.toMessage(moveDTO, createJsonProperties());

        MoveDTO unserialized = (MoveDTO) messageConverter.fromMessage(message);

        assertEquals(unserialized.getDicesToReRoll()[0], moveDTO.getDicesToReRoll()[0]);
        assertEquals(unserialized.getDicesToReRoll()[1], moveDTO.getDicesToReRoll()[1]);
        assertEquals(unserialized.getDicesToReRoll()[2], moveDTO.getDicesToReRoll()[2]);
        assertEquals(unserialized.getDicesToReRoll()[3], moveDTO.getDicesToReRoll()[3]);
        assertEquals(unserialized.getDicesToReRoll()[4], moveDTO.getDicesToReRoll()[4]);
        assertEquals(unserialized.getDicesToReRoll()[5], moveDTO.getDicesToReRoll()[5]);
    }

    @Test
    public void userInGame() {
        Dices dices = new Dices();
        dices.getDicesScore()[0] = DiceNumbers.FIVE;
        dices.getDicesScore()[1] = DiceNumbers.FOUR;

        UserInGame userInGame = new UserInGame();
        userInGame.setDices(dices);
        userInGame.setUserName("tester");

        Message message = messageConverter.toMessage(userInGame, createJsonProperties());

        UserInGame unserialized = (UserInGame) messageConverter.fromMessage(message);

        assertEquals(unserialized.getUserName(), userInGame.getUserName());
        assertEquals(unserialized.getDices().getDicesScore()[0], userInGame.getDices().getDicesScore()[0]);
        assertEquals(unserialized.getDices().getDicesScore()[1], userInGame.getDices().getDicesScore()[1]);
    }
    
    private MessageProperties createJsonProperties() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("application/json");
        return messageProperties;
    }
}