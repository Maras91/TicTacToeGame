package game.service;

import game.model.Field;
import game.model.PlayerMark;
import org.springframework.stereotype.Service;

@Service
public class HumanService {

    private final PlayerMark MYMARK = PlayerMark.x;


    public Field makeMove (int move) {
       int xAxis = move % 10;
       int yAxis = move / 10;
       return new Field (xAxis,yAxis);
    }

    public PlayerMark getMYMARK() {
        return MYMARK;
    }

}
