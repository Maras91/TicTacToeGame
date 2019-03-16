package game;

import game.model.Field;
import game.model.Player;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.TestCase.*;


public class GameStateTest {

    @Test
    public void addMoveTest() {
        //given
        GameState gameState = new GameState();
        //when
        gameState.addMove(new Field(1,1),Player.o);
        gameState.addMove(new Field(1,2),Player.x);
        //then
        assertTrue(gameState.getBoard().get(Player.o).contains(new Field(1,1)));
        assertTrue(gameState.getBoard().get(Player.x).contains(new Field(1,2)));

    }

    @Test
    public void isPlayerWinTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //given
        GameState gameState = new GameState();
        GameState gameState2 = new GameState();
        GameState gameState3 = new GameState();
        GameState gameState4 = new GameState();
        gameState.addMove(new Field(1,1),Player.o);
        gameState.addMove(new Field(1,2),Player.o);
        gameState.addMove(new Field(1,0),Player.o);
        gameState.addMove(new Field(0,2),Player.x);

        gameState2.addMove(new Field(0,0),Player.o);
        gameState2.addMove(new Field(1,1),Player.o);
        gameState2.addMove(new Field(2,2),Player.o);

        gameState3.addMove(new Field(0,2),Player.x);
        gameState3.addMove(new Field(1,1),Player.x);
        gameState3.addMove(new Field(2,0),Player.x);

        gameState4.addMove(new Field(0,0),Player.x);
        gameState4.addMove(new Field(1,0),Player.x);
        gameState4.addMove(new Field(2,0),Player.x);

        Method isPlayerWinMethod = GameState.class.getDeclaredMethod("isPlayerWin", Player.class);
        isPlayerWinMethod.setAccessible(true);

        //then
        assertEquals("true", isPlayerWinMethod.invoke(gameState, Player.o).toString());
        assertEquals("false", isPlayerWinMethod.invoke(gameState, Player.x).toString());
        assertEquals("true", isPlayerWinMethod.invoke(gameState2, Player.o).toString());
        assertEquals("true", isPlayerWinMethod.invoke(gameState3, Player.x).toString());
        assertEquals("true", isPlayerWinMethod.invoke(gameState4, Player.x).toString());
    }

    @Test
    public void clearMovesTest() {
        //given
        GameState gameState = new GameState();
        gameState.addMove(new Field(1,1),Player.o);
        gameState.addMove(new Field(1,2),Player.o);
        gameState.addMove(new Field(1,0),Player.o);
        gameState.addMove(new Field(0,2),Player.x);
        //when
        gameState.clearMoves();
        //then
        assertFalse(gameState.isPlayerWin());
        assertEquals(0,gameState.getBoard().get(Player.x).size());
        assertEquals(0,gameState.getBoard().get(Player.o).size());
    }

    @Test
    public void checkWinConditionTest() throws Exception {
//        //given
//        GameState gameState = spy(new GameState());
//        doReturn(true).when(gameState,"isPlayerWin",Player.x);
//        doReturn(false).when(gameState,"isPlayerWin",Player.o);
//        //when
//        verifyPrivate(gameState).invoke("checkWinCondition",Player.o);
//        boolean isPlayerOWin = gameState.isPlayerWin();
//        verifyPrivate(gameState).invoke("checkWinCondition",Player.x);
//
//        assertFalse(isPlayerOWin);
//        assertTrue(gameState.isPlayerWin());
//        assertEquals(Player.x,gameState.getWhichPlayerWon());
    }
}
