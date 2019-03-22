package game;

import game.model.Field;
import game.model.PlayerMark;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.spy;


public class BoardStateTest {

    @Test
    public void addMoveTest() {
        //given
        BoardState boardState = spy(new BoardState());
        //when
        boardState.addMove(new Field(1,1),PlayerMark.o);
        boardState.addMove(new Field(1,2),PlayerMark.x);
        //then
        assertTrue(boardState.getBoard().get(PlayerMark.o).contains(new Field(1,1)));
        assertTrue(boardState.getBoard().get(PlayerMark.x).contains(new Field(1,2)));
    }

    @Test
    public void isPlayerWinTest() {

        //given
        BoardState boardState = new BoardState();
        BoardState boardState2 = new BoardState();
        BoardState boardState3 = new BoardState();
        BoardState boardState4 = new BoardState();

        boardState.addMove(new Field(1,1),PlayerMark.o);
        boardState.addMove(new Field(1,2),PlayerMark.o);
        boardState.addMove(new Field(1,0),PlayerMark.o);
        boardState.addMove(new Field(0,2),PlayerMark.x);

        boardState2.addMove(new Field(0,0),PlayerMark.o);
        boardState2.addMove(new Field(1,1),PlayerMark.o);
        boardState2.addMove(new Field(2,2),PlayerMark.o);

        boardState3.addMove(new Field(0,2),PlayerMark.x);
        boardState3.addMove(new Field(1,1),PlayerMark.x);
        boardState3.addMove(new Field(2,0),PlayerMark.x);

        boardState4.addMove(new Field(0,0),PlayerMark.x);
        boardState4.addMove(new Field(1,0),PlayerMark.x);
        boardState4.addMove(new Field(2,0),PlayerMark.x);

        //when
        boardState.checkWinCondition(PlayerMark.o);
        boardState2.checkWinCondition(PlayerMark.o);
        boardState3.checkWinCondition(PlayerMark.x);
        boardState4.checkWinCondition(PlayerMark.x);
        //then
        assertEquals(PlayerMark.o,boardState.getWhichPlayerWon());
        assertTrue(boardState.isPlayerWin());
        assertEquals(PlayerMark.o,boardState2.getWhichPlayerWon());
        assertEquals(PlayerMark.x,boardState3.getWhichPlayerWon());
        assertEquals(PlayerMark.x,boardState4.getWhichPlayerWon());
    }

    @Test
    public void clearMovesTest() {
        //given
        BoardState boardState = new BoardState();
        boardState.addMove(new Field(1,1),PlayerMark.o);
        boardState.addMove(new Field(1,2),PlayerMark.o);
        boardState.addMove(new Field(1,0),PlayerMark.o);
        boardState.addMove(new Field(0,2),PlayerMark.x);
        //when
        boardState.clearMoves();
        //then
        assertFalse(boardState.isPlayerWin());
        assertEquals(0,boardState.getBoard().get(PlayerMark.x).size());
        assertEquals(0,boardState.getBoard().get(PlayerMark.o).size());
    }

    @Test
    public void checkWinConditionTest() throws Exception {
//        //given
//        _GameState gameState = spy(new _GameState());
//        doReturn(true).when(gameState,"isPlayerWin",PlayerMark.x);
//        doReturn(false).when(gameState,"isPlayerWin",PlayerMark.o);
//        //when
//        verifyPrivate(gameState).invoke("checkWinCondition",PlayerMark.o);
//        boolean isPlayerOWin = gameState.isPlayerWin();
//        verifyPrivate(gameState).invoke("checkWinCondition",PlayerMark.x);
//
//        assertFalse(isPlayerOWin);
//        assertTrue(gameState.isPlayerWin());
//        assertEquals(PlayerMark.x,gameState.getWhichPlayerWon());
    }
}
