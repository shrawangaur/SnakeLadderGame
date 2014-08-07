import com.game.domain.*;
import com.game.literals.GameLiterals;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

    GamingBoard gamingBoard;
    List<Player> players = new ArrayList<Player>();
    PlayerFactory playerFactory  = new PlayerFactory();

    public SnakeAndLadderGame() {
        gamingBoard = new GamingBoard();
        players.add(playerFactory.createPlayer(GameLiterals.FIRST_PLAYER));
        players.add(playerFactory.createPlayer(GameLiterals.SECOND_PLAYER));
    }

    void playGame(){

        int diceNumber =0;

        System.out.println(" --Game Begins--");

        do{
            for (Player player : players) {
                    diceNumber = player.rollDice();
                    setNewPositionAsPerDiceNumber(diceNumber, player);
                    if(player.isWon()) break;
          }
        }while (!players.get(0).isWon() && !players.get(1).isWon());

        System.out.println(" --Game Ends--");
    }

    private void setNewPositionAsPerDiceNumber(int diceNumber, Player player) {

        player.setPosition(player.getPosition() + diceNumber);

        player.setNewPositionsIfSnakeConditionIsMet(gamingBoard);

        player.setNewPositionsIfLadderConditionIsMet(gamingBoard);

        System.out.println("Player " + player.getPlayerName() + " Position " + player.getPosition() + " Dice " + diceNumber);
    }


    //
    public static void main(String[] args){
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        snakeAndLadderGame.playGame();
    }

}
