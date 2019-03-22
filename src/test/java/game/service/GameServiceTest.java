package game.service;

import game.BoardState;
import game.model.Game;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class GameServiceTest {

    @Test
    public void addPlayerMoveTest () {

        //given
        ComputerService computerService = new ComputerService();
        HumanService humanService = spy(new HumanService());
        BoardState boardState = spy(new BoardState());
        Game game = new Game(computerService,humanService, boardState);
        GameService gameService = new GameService(game);

        //when
        gameService.addPlayerMove(11);

        //then
        verify(humanService).makeMove(11);
        verify(boardState).addMove(any(),any());
        verify(boardState).checkWinCondition(any());
    }

    @Test
    public void addComputerMoveTest () {

        //given
        ComputerService computerService = spy(new ComputerService());
        HumanService humanService = new HumanService();
        BoardState boardState = spy(new BoardState());
        Game game = new Game(computerService,humanService, boardState);
        GameService gameService = new GameService(game);

        //when
        gameService.addComputerMove();
        //then
        verify(computerService).makeMove(any());
        verify(boardState).addMove(any(),any());
        verify(boardState).checkWinCondition(any());
    }
}
