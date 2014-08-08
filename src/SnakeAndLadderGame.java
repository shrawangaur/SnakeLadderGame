import com.game.domain.*;
import com.game.literals.GameLiterals;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

     GamingBoard gamingBoard;

     int diceNumber;

    public SnakeAndLadderGame() {
        gamingBoard = new GamingBoard();
        diceNumber = GameLiterals.START_POINT;
    }

    public Player playGame(List<Player> players){
        System.out.println("--Game Begins--");

        while (!checkIfAnyPlayerHasWon(players)){
            for (Player player : players) {
                System.out.println(" Chance For --> " + player.getPlayerName());
                    diceNumber = player.rollDice();
                    setNewPositionAsPerDiceNumber(diceNumber, player);
                    if(player.isWon())
                    return player;
            }
        }



        System.out.println("--Game Ends--");
        throw new RuntimeException();
    }

    protected boolean checkIfAnyPlayerHasWon(List<Player> players) {

        if (checkIfPlayerPresentInGame(players)) return true;

        for (Player player : players) {
           if(player.isWon()) return true;
        }
        return false;
    }

    private boolean checkIfPlayerPresentInGame(List<Player> players) {
        if(players.size()==0){
            return true;
        }
        return false;
    }

    protected void setNewPositionAsPerDiceNumber(int diceNumber, Player player) {

        player.setPosition(player.getPosition() + diceNumber);

        player.setNewPositionsIfSnakeConditionIsMet(gamingBoard);

        player.setNewPositionsIfLadderConditionIsMet(gamingBoard);

        System.out.println("Player Playing --> " + player.getPlayerName() + " Got Position " + player.getPosition() + " As total moves he got " + diceNumber);
    }

    //Main method To Run The Program
    public static void main(String[] args){
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame();
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(GameLiterals.FIRST_PLAYER));
        players.add(new Player(GameLiterals.SECOND_PLAYER));
        snakeAndLadderGame.playGame(players);
    }
 
    
}
