package game.controller;

import game.model.Board;
import game.model.FieldState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private Board board;

    public HomeController() {
    }

    @GetMapping("/clickevent")
    public void clickEvent(@RequestParam int move, int playerId) {
        FieldState fieldState = board.givePlayerFieldStatus(playerId);
        board.addMove(move, fieldState);
        if (board.checkWinCondition(fieldState)) {
            System.out.println("Player '"+fieldState+"' win!!!");
        }
        //return "index";
    }

}
