package game.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import game.GameState;
import game.model.Field;
import game.service.Computer;
import game.service.PlayerSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoveController {

    @Autowired
    private GameState gameState;

    @Autowired
    private PlayerSwitcher playerSwitcher;

    @Autowired
    private Computer computer;

    @PostMapping("/clickevent")
    public String clickEvent(@RequestParam int move) throws JsonProcessingException {

        gameState.addMove(new Field(move), playerSwitcher.getPlayer());
        playerSwitcher.switchPlayer();
        if (!gameState.isPlayerWin()) {
            gameState = computer.makeMove(gameState, playerSwitcher.getPlayer());
        }
        playerSwitcher.switchPlayer();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(gameState);
        return json;
    }

    @PostMapping("/restart")
    public void restart(){
        gameState.clearMoves();
    }
}
