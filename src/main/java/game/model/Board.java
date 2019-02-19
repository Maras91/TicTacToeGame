package game.model;

import org.springframework.stereotype.Component;

@Component
public class Board {
    private String[][] board;
    public Board() {
        board = new String[3][3];
    }

    @Override
    public String toString() {
        return "Board:"+"\n"+
                "["+board[0][0]+"]"+"["+board[0][1]+"]"+"["+board[0][2]+"]"+"\n"+
                "["+board[1][0]+"]"+"["+board[1][1]+"]"+"["+board[1][2]+"]"+"\n"+
                "["+board[2][0]+"]"+"["+board[2][1]+"]"+"["+board[2][2]+"]"+"\n";
    }

    public void addMove(int move, int playerId) {
        int xAxis;
        int yAxis;
        xAxis = move % 10;
        yAxis = move / 10;

        if (playerId==1) {
            board[yAxis][xAxis] = "x";
        } else {
            board[yAxis][xAxis] = "o";
        }
    }

    private boolean checkWinCondition() {
        return false;
    }


}
