package game.service;

import game.GameState;
import game.model.Field;
import game.model.Player;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
public class Computer {

    private Player player;
    private Player opponent;

    public Computer(Player player) {
        this.player = player;
        if (player==Player.x) {
            opponent=Player.o;
        }else {
            opponent=Player.x;
        }
    }
    public GameState addRandomMove (GameState gameState) {
        Random randomNumber = new Random();
        HashSet<Field> opponentMoves = gameState.getBoard().get(opponent);
        HashSet<Field> myMoves = gameState.getBoard().get(player);
        HashSet<Field> allMoves = new HashSet<>();
        allMoves.addAll(opponentMoves);
        allMoves.addAll(myMoves);
        if (allMoves.size()>=9) {
            return gameState;
        }
        Field fieldToAdd = new Field(1,1);
        while (!allMoves.add(fieldToAdd)) {
            fieldToAdd = new Field(randomNumber.nextInt(3),randomNumber.nextInt(3));
        }
        gameState.getBoard().get(player).add(fieldToAdd);
        return gameState;

    }
//    public GameState computerMove(GameState gameState) {
//        HashSet<Field> opponentMoves = gameState.getBoard().get(opponent);
//        HashSet<Field> myMoves = gameState.getBoard().get(player);
//        HashSet<Field> allMoves = new HashSet<>();
//        allMoves.addAll(opponentMoves);
//        allMoves.addAll(myMoves);
//
//        if (opponentMoves.size()==0) {
//            gameState.addMove(11,player);
//            return gameState;
//        }
//        if (opponentMoves.size()==1) {
//            gameState.addMove(11,player);
//            return gameState;
//        }
//
//        return gameState;
//    }
}
