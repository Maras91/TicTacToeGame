package game.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {

    private GameService gameService;

    @Autowired
    public MoveController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/clickevent")
    public String clickEvent(@RequestParam int move) throws JsonProcessingException {
        gameService.addPlayerMove(move);
        if (!gameService.getGame().getBoardState().isPlayerWin()) {
            gameService.addComputerMove();
        }
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(gameService.getGame().getBoardState());
        return json;
    }

    @PostMapping("/restart")
    public void restart(){
        gameService.getGame().getBoardState().clearMoves();
    }
}
