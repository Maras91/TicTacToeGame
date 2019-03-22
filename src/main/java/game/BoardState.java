package game;

import game.model.Field;
import game.model.PlayerMark;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
public class BoardState {

    private Map<PlayerMark,HashSet<Field>> board;
    private PlayerMark whichPlayerWon;
    private boolean playerWin;

    public BoardState() {
        board = new HashMap<>();
        playerWin = false;
        board.put(PlayerMark.x,new HashSet<>());
        board.put(PlayerMark.o,new HashSet<>());
    }
    public void addMove (Field field,PlayerMark playerMark) {
        board.get(playerMark).add(field);
    }

    private boolean isPlayerWin(PlayerMark playerMark) {
        HashSet<Field> playerFields = board.get(playerMark);
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

    public void checkWinCondition (PlayerMark playerMark) {
        if (isPlayerWin(playerMark)) {
            playerWin = true;
            whichPlayerWon = playerMark;
        }
    }

    public void clearMoves() {
        playerWin = false;
        board.clear();
        board.put(PlayerMark.x,new HashSet<>());
        board.put(PlayerMark.o,new HashSet<>());
    }

    public Map<PlayerMark, HashSet<Field>> getBoard() {
        return board;
    }

    public PlayerMark getWhichPlayerWon() {
        return whichPlayerWon;
    }

    public boolean isPlayerWin() {
        return playerWin;
    }
}
