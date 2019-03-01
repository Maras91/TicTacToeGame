package game.controller;

import game.model.Board;
import game.model.FieldState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private Board board;

    @GetMapping("/")
    public String index(){
        board.clearMoves();
        return "indexView";
    }

    @GetMapping("/clickevent")
    public String clickEvent(@RequestParam int move, int playerId, Model model) {
        FieldState fieldState = board.givePlayerFieldStatus(playerId);
        board.addMove(move, fieldState);
        if (board.checkWinCondition(fieldState)) {
            System.out.println("Player '"+fieldState+"' win!!!");
            model.addAttribute("winPlayer",fieldState);
        }
        return "indexView";
    }

}
