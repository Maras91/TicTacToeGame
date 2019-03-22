package game.service;


import game.BoardState;
import game.model.Field;
import game.model.PlayerMark;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerServiceTest {

    @Test
    public void makeMoveTest () {

        //given
        ComputerService computerService = new ComputerService();
        BoardState boardState = new BoardState();

        BoardState boardState2 = new BoardState();
        boardState2.addMove(new Field(0,0),PlayerMark.x);
        boardState2.addMove(new Field(0,1),PlayerMark.x);
        boardState2.addMove(new Field(0,2),PlayerMark.o);

        boardState2.addMove(new Field(1,0),PlayerMark.x);
        boardState2.addMove(new Field(1,1),PlayerMark.x);
        boardState2.addMove(new Field(1,2),PlayerMark.o);

        boardState2.addMove(new Field(2,0),PlayerMark.x);
        boardState2.addMove(new Field(2,1),PlayerMark.x);
        boardState2.addMove(new Field(2,2),PlayerMark.o);
        //when
        Field field = computerService.makeMove(boardState);
        Field field2 = computerService.makeMove(boardState2);
        //then
        assertEquals(new Field(1,1),field);
        assertEquals(new Field(-1,-1),field2);
    }



    @Test
   public void  obviousMoveTest () {
        //given
        ComputerService computerService = new ComputerService();
        BoardState boardState = new BoardState();
        boardState.addMove(new Field(0,1),PlayerMark.x);
        boardState.addMove(new Field(0,2),PlayerMark.x);
        boardState.addMove(new Field(1,1),PlayerMark.o);

        BoardState boardState2 = new BoardState();
        boardState2.addMove(new Field(0,0),PlayerMark.x);
        boardState2.addMove(new Field(1,1),PlayerMark.x);

        BoardState boardState3 = new BoardState();
        boardState3.addMove(new Field(0,0),PlayerMark.x);
        boardState3.addMove(new Field(1,0),PlayerMark.x);
        boardState3.addMove(new Field(1,1),PlayerMark.o);

        BoardState boardState4 = new BoardState();
        boardState4.addMove(new Field(0,2),PlayerMark.x);
        boardState4.addMove(new Field(1,1),PlayerMark.x);

        BoardState boardState5 = new BoardState();
        boardState5.addMove(new Field(0,0),PlayerMark.x);
        boardState5.addMove(new Field(0,1),PlayerMark.x);
        boardState5.addMove(new Field(1,0),PlayerMark.o);
        boardState5.addMove(new Field(1,1),PlayerMark.o);

        //when
        Field field = computerService.makeMove(boardState);
        Field field2 = computerService.makeMove(boardState2);
        Field field3 = computerService.makeMove(boardState3);
        Field field4 = computerService.makeMove(boardState4);
        Field field5 = computerService.makeMove(boardState5);

        //then
        assertEquals(new Field(0,0),field);
        assertEquals(new Field(2,2),field2);
        assertEquals(new Field(2,0),field3);
        assertEquals(new Field(2,0),field4);
        assertEquals(new Field(1,2),field5);
    }
    @Test
    public void getRandomFieldTest(){
        //given
        ComputerService computerService = new ComputerService();
        BoardState boardState = new BoardState();
        boardState.addMove(new Field(0,0),PlayerMark.o);
        boardState.addMove(new Field(0,1),PlayerMark.o);
        boardState.addMove(new Field(0,2),PlayerMark.x);

        boardState.addMove(new Field(1,0),PlayerMark.x);
        boardState.addMove(new Field(1,1),PlayerMark.x);
        boardState.addMove(new Field(1,2),PlayerMark.o);

        boardState.addMove(new Field(2,0),PlayerMark.o);
        boardState.addMove(new Field(2,2),PlayerMark.x);

        //when
        Field field = computerService.makeMove(boardState);
        //then
        assertEquals(new Field(2,1),field);
    }
}
