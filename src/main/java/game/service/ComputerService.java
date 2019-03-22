package game.service;

import game.BoardState;
import game.model.Field;
import game.model.PlayerMark;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
public class ComputerService {

    private final PlayerMark MYMARK = PlayerMark.o;

    public Field makeMove(BoardState boardState) {
        PlayerMark opponent;
        if (getMYMARK() ==PlayerMark.x) {
            opponent=PlayerMark.o;
        }else {
            opponent=PlayerMark.x;
        }
        HashSet<Field> opponentMoves = boardState.getBoard().get(opponent);
        HashSet<Field> myMoves = boardState.getBoard().get(getMYMARK());
        HashSet<Field> allMoves = new HashSet<>();
        allMoves.addAll(opponentMoves);
        allMoves.addAll(myMoves);
        if (allMoves.size()>=9) {
            return new Field(-1,-1);
        }
        Field fieldToAdd = new Field(1,1);
        if (allMoves.add(fieldToAdd)) {
            return fieldToAdd;
        }
        fieldToAdd = obviousMove(myMoves,allMoves);
        if (!fieldToAdd.equals(new Field(-1,-1))) {
            return fieldToAdd;
        }
        fieldToAdd = obviousMove(opponentMoves,allMoves);
        if (!fieldToAdd.equals(new Field(-1,-1))) {
           return fieldToAdd;
        }
        return getRandomField(allMoves);
    }

    private Field obviousMove(HashSet<Field> PlayerMoves, HashSet<Field> allMoves) {
        Field fieldToWin;
        for (int i=0; i<3; i++) {
            int finalI = i;
            if (PlayerMoves.stream().filter(field -> field.getxAxis() == finalI).count()==2) {
                for (int j=0; j<3;j++){
                    fieldToWin = new Field(finalI,j);
                    if (allMoves.add(fieldToWin)) {
                        return fieldToWin;
                    }
                }
            }
            if (PlayerMoves.stream().filter(field -> field.getyAxis() == finalI).count()==2) {
                for (int j=0; j<3;j++){
                    fieldToWin = new Field(j,finalI);
                    if (allMoves.add(fieldToWin)) {
                        return fieldToWin;
                    }
                }
            }
        }
        if (PlayerMoves.stream().filter(field -> field.getxAxis()==field.getyAxis()).count()==2) {
            for (int j=0; j<3;j++){
                fieldToWin = new Field(j,j);
                if (allMoves.add(fieldToWin)) {
                    return fieldToWin;
                }
            }
        }
        if (PlayerMoves.stream().filter(field -> field.getyAxis()+field.getxAxis()==2).count()==2) {
            for (int j=0; j<3;j++){
                fieldToWin = new Field(j,2-j);
                if (allMoves.add(fieldToWin)) {
                    return fieldToWin;
                }
            }
        }
        return new Field(-1,-1);
    }


    private Field getRandomField (HashSet<Field> makeMoves) {
        Field randomField;
        Random randomNumber = new Random();
         do {
            randomField = new Field(randomNumber.nextInt(3),randomNumber.nextInt(3));
        } while (!makeMoves.add(randomField));
         return randomField;
    }

    public PlayerMark getMYMARK() {
        return MYMARK;
    }
}
