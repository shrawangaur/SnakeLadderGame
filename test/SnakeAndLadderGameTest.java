import com.game.domain.GamingBoard;
import com.game.domain.Player;
import com.game.literals.GameLiterals;
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

        System.setOut(new PrintStream(sysOutBegin).append("--Game Begins--"));
        System.setOut(new PrintStream(sysOutEnd).append("--Game Ends--"));

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

    @Test
    public void  should_print_end_game_when_player_won(){

        assertEquals("--Game Ends--", sysOutEnd.toString());

    }

    @Test
    public void  should_print_start_game_when_game_starts(){

        assertEquals("--Game Begins--", sysOutBegin.toString());

    }

}


