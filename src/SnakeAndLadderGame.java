import com.game.domain.*;
import com.game.literals.GameLiterals;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

    GamingBoard gamingBoard;
    List<Player> players = new ArrayList<Player>();
    int diceNumber;

    public SnakeAndLadderGame() {
        gamingBoard = new GamingBoard();
        players.add(new Player(GameLiterals.FIRST_PLAYER));
        players.add(new Player(GameLiterals.SECOND_PLAYER));
        diceNumber = GameLiterals.START_POINT;
    }

    public void playGame(){

        System.out.println(" --Game Begins--");

        do{
            for (Player player : players) {
                System.out.println(" Chance For --> " + player.getPlayerName());
                    diceNumber = player.rollDice();
                    setNewPositionAsPerDiceNumber(diceNumber, player);
                    if(player.isWon()) break;
          }
        }while (!checkIfAnyPlayerHasWon());

        System.out.println(" --Game Ends--");
    }

    public boolean checkIfAnyPlayerHasWon() {
        for (Player player : players) {
           if(player.isWon()) return true;
        }
        return false;
    }

    private void setNewPositionAsPerDiceNumber(int diceNumber, Player player) {

        player.setPosition(player.getPosition() + diceNumber);

        player.setNewPositionsIfSnakeConditionIsMet(gamingBoard);

        player.setNewPositionsIfLadderConditionIsMet(gamingBoard);

        System.out.println("Player Playing --> " + player.getPlayerName() + " Got Position " + player.getPosition() + " As total moves he got " + diceNumber);
    }

    //Main method To Run The Program
    public static void main(String[] args){
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        snakeAndLadderGame.playGame();
    }
 
    
}
