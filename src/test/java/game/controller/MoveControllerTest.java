package game.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import game.BoardState;
import game.model.Game;
import game.service.ComputerService;
import game.service.GameService;
import game.service.HumanService;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class MoveControllerTest {

    @Test
    public void clickEventTest() throws JsonProcessingException {

        //given
        ComputerService computerService = new ComputerService();
        HumanService humanService = new HumanService();
        BoardState boardState = new BoardState();
        Game game = new Game(computerService,humanService, boardState);
        GameService gameService = spy(new GameService(game));
        MoveController moveController = new MoveController(gameService);
        //when
        moveController.clickEvent(11);
        //then
        verify(gameService).addPlayerMove(11);
        verify(gameService).addComputerMove();
    }

}
