package game.controller;

import game.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
    @Autowired
    private Board board;

    public HomeController() {
    }

    @GetMapping("/home")
    public void home(@RequestParam int move, int playerId) {
        board.addMove(move, playerId);
        System.out.println(board);
    }
}
