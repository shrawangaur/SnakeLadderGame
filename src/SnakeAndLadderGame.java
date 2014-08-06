import com.game.domain.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

    GamingBoard gamingBoard;
    List<Player> players = new ArrayList<Player>();

    public SnakeAndLadderGame() {
        gamingBoard = new GamingBoard();
        players.add(new PlayerOne());
        players.add(new PlayerTwo());
    }

    void playGame(){
        int diceNumber =0;
        System.out.println(" --Game Begins--");
        do{
            for (Player player : players) {
                if (player.isChanceToRollDice(diceNumber)){

                    diceNumber = player.rollDice();

                    player.setPosition(player.getPosition() + diceNumber);

                    setNewPositionsIfSnakeConditionIsMet(player);

                    setNewPositionsIfLadderConditionIsMet(player);

                    System.out.println("Player " + player.getPlayerName() + " Position " + player.getPosition() + " Dice " + diceNumber);
                }
            }

        }while (!players.get(0).isWon() && !players.get(1).isWon());
    }

    private void setNewPositionsIfLadderConditionIsMet(Player player) {
        for (Integer ladderBase : gamingBoard.getLadderBaseToUpMap().keySet()){
            if(player.getPosition() == ladderBase){
                player.setPosition(gamingBoard.getLadderBaseToUpMap().get(ladderBase));
                System.out.println("Ladder Condition For "+player.getPlayerName());
            }
        }
    }

    private void setNewPositionsIfSnakeConditionIsMet(Player player) {
        for(Integer snakeHead : gamingBoard.getSnakeHeadToTailMap().keySet()){
            if (player.getPosition() == snakeHead){
                player.setPosition(gamingBoard.getSnakeHeadToTailMap().get(snakeHead));
                System.out.println("Snake Condition For " + player.getPlayerName());
            }
        }
    }

    //
    public static void main(String[] args){
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        snakeAndLadderGame.playGame();
    }

}
