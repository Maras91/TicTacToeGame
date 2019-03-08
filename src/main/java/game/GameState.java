package game;

import game.model.Field;
import game.model.Player;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameState {
    private Map<Player,HashSet<Field>> board;
    private Player whichPlayerWon;
    private boolean playerWin;
    public GameState() {
        board = new HashMap<>();
        playerWin = false;
        board.put(Player.x,new HashSet<>());
        board.put(Player.o,new HashSet<>());
    }

    public void addMove(Field field, Player player) {
        board.get(player).add(field);
        checkWinCondition(player);
    }

    private void checkWinCondition (Player player) {
        if (isPlayerWin(player)) {
            playerWin = true;
            whichPlayerWon = player;
        }
    }

    private boolean isPlayerWin(Player player) {
        HashSet<Field> playerFields = board.get(player);
        for (int i=0; i<3; i++) {
            int finalI = i;
            if (playerFields.stream().filter(field -> field.getxAxis() == finalI).count()==3) {
                return true;
            }
            if (playerFields.stream().filter(field -> field.getyAxis() == finalI).count()==3) {
                return true;
            }
        }
        if (playerFields.stream().filter(field -> field.getxAxis()==field.getyAxis()).count()==3) {
            return true;
        }
        if (playerFields.stream().filter(field -> field.getyAxis()+field.getxAxis()==2).count()==3) {
            return true;
        }
        return false;
    }
    public void clearMoves() {
        playerWin = false;
        board.clear();
        board.put(Player.x,new HashSet<>());
        board.put(Player.o,new HashSet<>());
    }
    public Map<Player, HashSet<Field>> getBoard() {
        return board;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }

    public Player getWhichPlayerWon() {
        return whichPlayerWon;
    }
}
