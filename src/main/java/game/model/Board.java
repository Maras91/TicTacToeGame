package game.model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Board {
    private Map<FieldState,HashSet<Field>> board;
    public Board() {
        board = new HashMap<>();
        board.put(FieldState.x,new HashSet<>());
        board.put(FieldState.o,new HashSet<>());
    }

    public void addMove(int move, FieldState  player) {
        int xAxis;
        int yAxis;

        xAxis = move % 10;
        yAxis = move / 10;

        Field field = new Field(xAxis,yAxis);
        board.get(player).add(field);
    }

    public FieldState givePlayerFieldStatus (int playerId) {
        if (playerId==1) {
            return FieldState.x;
        } else {
            return FieldState.o;
        }
    }

    public boolean checkWinCondition(FieldState player) {
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
        board.clear();
        board.put(FieldState.x,new HashSet<>());
        board.put(FieldState.o,new HashSet<>());
    }
    public Map<FieldState, HashSet<Field>> getBoard() {
        return board;
    }
}
