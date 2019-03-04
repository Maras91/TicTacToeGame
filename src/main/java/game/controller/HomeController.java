package game.controller;

import game.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private GameState gameState;

    @GetMapping("/")
    public String index( Model model){
        gameState.clearMoves();
        model.addAttribute("isPlayerWin",gameState.isPlayerWin());
        return "indexView";
    }

    @GetMapping("/clickevent")
    public String clickEvent(@RequestParam int move, int playerId, Model model) {
        Player player = gameState.givePlayerFieldStatus(playerId);
        gameState.addMove(move, player);
        if (gameState.isPlayerWin()) {
            System.out.println("Player '"+ player +"' win!!!");
            model.addAttribute("winPlayer", gameState.getWhichPlayerWon());
        }
        model.addAttribute("isPlayerWin",gameState.isPlayerWin());
        return "indexView";
    }

}
