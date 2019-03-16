package game.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import game.GameState;
import game.model.Field;
import game.service.Computer;
import game.service.PlayerSwitcher;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class MoveControllerTest {




    @Test
    public void clickEventTest() throws JsonProcessingException {

        //given
        GameState gameState = mock(GameState.class);
        PlayerSwitcher playerSwitcher = mock(PlayerSwitcher.class);
        Computer computer = mock(Computer.class);
        MoveController moveController = new MoveController(gameState,playerSwitcher,computer);
        //when
        moveController.clickEvent(11);
        //then
        verify(gameState).addMove(new Field(1,1),null);
        verify(playerSwitcher,atLeast(1)).switchPlayer();
    }

}
