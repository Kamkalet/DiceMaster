package agh.to2.dicemaster.server.managers;

import agh.to2.dicemaster.common.UserType;
import agh.to2.dicemaster.common.api.GameConfigDTO;
import agh.to2.dicemaster.common.api.GameDTO;
import agh.to2.dicemaster.server.User;
import agh.to2.dicemaster.server.api.Game;
import agh.to2.dicemaster.server.services.SenderService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public class GamesManagerTest {

    private GamesManager gamesManager = new GamesManager();
    private List<Game> games = new ArrayList<>();


    @Mock
    SenderService senderService;
    @Mock
    private
    User user;
//    TODO: Pass game Factory to the manager
//    @Mock
//    GameFactory gameFactory;


    @BeforeClass
    public void setUpGameFactory() throws NoSuchFieldException {
        for(int i = 0 ; i < 5 ; i++){
            Game game = mock(Game.class);
            when(game.getId()).thenReturn(i);
            games.add(game);
        }
    }

    @Before
    public void setUp() {
        for (Game game : games) {
//            TODO: Uncomment this
//                    when(gameFactory.createGame(gameConfigDTO)).thenReturn(game);
            gamesManager.createGame(new GameConfigDTO());
        }
    }

    @After
    public void tearDown() throws Exception {
        gamesManager.getAllAsGameDTO().forEach(gameDTO -> gamesManager.removeGame(gameDTO.getId()));
    }

    @Test
    public void createGame() throws Exception {
//        given
        Game game = mock(Game.class);
        when(game.getId()).thenReturn(UUID.randomUUID().hashCode());
//        TODO: Uncomment this
//        when(gameFactory.createGame(gameConfigDTO)).thenReturn(game);

        Game gameCreated = gamesManager.createGame(new GameConfigDTO());
//        when
        Optional<Game> gameRetrieved = gamesManager.getGameById(game.getId());
//        then
        assert gameRetrieved.isPresent();
        assert gameCreated.getId() == gameRetrieved.get().getId();
        assert gameCreated.getId() == game.getId();
    }
    @Test
    public void getGameById() throws Exception {
//        given
        Game game = games.get(0);
//        when
        Optional<Game> game1 = gamesManager.getGameById(game.getId());
//        then
        assert game1.isPresent();
        assert game.getId() == game1.get().getId();
    }

    @Test
    public void getAll() throws Exception {
//        given
        Collection<GameDTO> games1 = gamesManager.getAllAsGameDTO();
//        when
        Collection<Integer> game1Ids = games1.stream().map(GameDTO::getId).collect(Collectors.toList());
        Collection<Integer> gameIds = games.stream().map(Game::getId).collect(Collectors.toList());
//        then
        assert gameIds.containsAll(game1Ids);
    }

    @Test
    public void removeGame() throws Exception {
//        given
        gamesManager.removeGame(games.get(0).getId());
//        when
        Optional<Game> gameOptional = gamesManager.getGameById(games.get(0).getId());
//        then
        assert !gameOptional.isPresent();
    }

    @Test
    public void addPlayerToGame() throws Exception {
//        given
        int gameID = games.get(0).getId();
        gamesManager.addUserToGame(UserType.PLAYER, user, gameID);
//        when
        Optional<Game> game = gamesManager.getGameById(gameID);
        assert game.isPresent();
//        then
        verify(games.get(0), times(1)).addPlayer(user);
    }

    @Test
    public void addObserverToGame() throws Exception {
        //        given
        int gameID = games.get(0).getId();
        gamesManager.addUserToGame(UserType.OBSERVER, user, gameID);
//        when
        Optional<Game> game = gamesManager.getGameById(gameID);
        assert game.isPresent();
//        then
        verify(games.get(0), times(1)).addObserver(user);
    }

    @Test
    public void removeIdleGames() throws Exception {
//        given
//        when
        gamesManager.removeIdleGames(); // no game contains any player
//        then
        assert gamesManager.getAllAsGameDTO().isEmpty();
    }

}