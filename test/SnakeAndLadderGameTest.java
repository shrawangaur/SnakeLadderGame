import com.game.domain.GamingBoard;
import com.game.domain.Player;
import com.game.literals.GameLiterals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SnakeAndLadderGameTest {

    GamingBoard gamingBoard;
    List<Player> players = new ArrayList<Player>();
    private final ByteArrayOutputStream sysOutBegin = new ByteArrayOutputStream();
    private final ByteArrayOutputStream sysOutEnd = new ByteArrayOutputStream();



    @Before
    public void setUp() throws Exception {

        gamingBoard = new GamingBoard();
        players.add(new Player(GameLiterals.FIRST_PLAYER));
        players.add(new Player(GameLiterals.SECOND_PLAYER));
   }

    @Test
    public  void should_return_true_if_any_player_won_game(){
        //Given
         List<Player> playerList =  new ArrayList<Player>();
        Player player = new Player(GameLiterals.FIRST_PLAYER);
        player.setPosition(100);
        playerList.add(player);

        //When
         SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
         boolean ifGameEndsInActual = snakeAndLadderGame.checkIfAnyPlayerHasWon(playerList);

        //Then
        Assert.assertTrue(ifGameEndsInActual);
    }

    @Test
    public  void should_return_false_if_any_player_has_not_won_game(){
        //Given
        List<Player> playerList =  new ArrayList<Player>();
        Player player = new Player(GameLiterals.FIRST_PLAYER);
        player.setPosition(65);
        playerList.add(player);

        //When
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        boolean ifGameEndsInActual = snakeAndLadderGame.checkIfAnyPlayerHasWon(playerList);

        //Then
        Assert.assertFalse(ifGameEndsInActual);
    }

    @Test
    public void should_return_winning_player_if_condition_of_winning_is_met(){
        //Given
        List<Player> playerList =  new ArrayList<Player>();
        Player expectedPlayerForWinning = new Player(GameLiterals.FIRST_PLAYER);
        Player secondPlayer = new Player(GameLiterals.SECOND_PLAYER);
        expectedPlayerForWinning.setPosition(100);
        secondPlayer.setPosition(45);
        playerList.add(expectedPlayerForWinning);
        playerList.add(secondPlayer);
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        //When
        Player actualWinningplayer = snakeAndLadderGame.playGame(players);
        //Then
        Assert.assertEquals(expectedPlayerForWinning.getPlayerName(),actualWinningplayer.getPlayerName());

    }

    @Test (expected = RuntimeException.class)
    public void should_throw_exception_if_no_player_won(){
        List<Player> playerList =  new ArrayList<Player>();
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        snakeAndLadderGame.playGame(playerList);
    }

    @Test
    public void should_create_gamingboard_with_ladder_information_on_it_when_game_begins(){

        //When
         SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();

        //Then
        assertEquals(gamingBoard.getLadderBaseToUpMap(), snakeAndLadderGame.gamingBoard.getLadderBaseToUpMap());

    }

    @Test
    public void should_create_gamingboard_with_snake_information_on_it_when_game_begins(){

        //When
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();

        //Then
        assertEquals(gamingBoard.getSnakeHeadToTailMap(), snakeAndLadderGame.gamingBoard.getSnakeHeadToTailMap());

    }

    @Test
    public void should_create_gamingboard_with_board_number_on_it_when_game_begins(){

        //When
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();

        //Then
        assertEquals(gamingBoard.getBoardNumbers(), snakeAndLadderGame.gamingBoard.getBoardNumbers());

    }
 }


