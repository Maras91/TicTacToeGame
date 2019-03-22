package game.service;

import game.model.Field;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanServiceTest {

    @Test
    public void makeMoveTest () {
        //given
        HumanService humanService = new HumanService();
        //when
        Field field = humanService.makeMove(2);
        //then
        assertEquals(new Field(2,0),field);
    }
}
