import com.game.domain.GamingBoard;
import com.game.domain.Player;
import com.game.literals.GameLiterals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGameTest {

    GamingBoard gamingBoard;
    List<Player> players = new ArrayList<Player>();

    @Before
    public void setUp() throws Exception {

        gamingBoard = new GamingBoard();
        players.add(new Player(GameLiterals.FIRST_PLAYER));
        players.add(new Player(GameLiterals.SECOND_PLAYER));

    }

    @Test
    public void should_create_gamingboard_with_ladder_information_on_it_when_game_begins(){

        //When
         SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();

        //Then
        Assert.assertEquals(gamingBoard.getLadderBaseToUpMap(), snakeAndLadderGame.gamingBoard.getLadderBaseToUpMap());

    }

    @Test
    public void should_create_gamingboard_with_snake_information_on_it_when_game_begins(){

        //When
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();

        //Then
        Assert.assertEquals(gamingBoard.getSnakeHeadToTailMap(), snakeAndLadderGame.gamingBoard.getSnakeHeadToTailMap());

    }

    @Test
    public void should_create_gamingboard_with_board_number_on_it_when_game_begins(){

        //When
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();

        //Then
        Assert.assertEquals(gamingBoard.getBoardNumbers(), snakeAndLadderGame.gamingBoard.getBoardNumbers());

    }

    @Test
    public void  return_true_if_any_player_won_in_game(){
        //Given

        //When
       /* SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        setFinishPointCondtionInPlayerOne();
        boolean actualOutput = snakeAndLadderGame.checkIfAnyPlayerHasWon();*/

        //boolean actualCondition = snakeAndLadderGame.checkIfAnyPlayerHasWon();
        //Then

    }



}


