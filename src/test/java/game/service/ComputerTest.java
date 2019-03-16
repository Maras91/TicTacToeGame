package game.service;


import game.model.Field;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class ComputerTest {

    @Test
    public void getRandomFieldTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Computer computer = new Computer();
        HashSet<Field> occupiedFields = new HashSet<>();
        occupiedFields.add(new Field(0,0));
        occupiedFields.add(new Field(0,1));
        occupiedFields.add(new Field(0,2));

        occupiedFields.add(new Field(1,0));
        occupiedFields.add(new Field(1,1));

        occupiedFields.add(new Field(2,0));
        occupiedFields.add(new Field(2,1));
        occupiedFields.add(new Field(2,2));

        Method getRandomFieldMethod = Computer.class.getDeclaredMethod("getRandomField", HashSet.class);
        getRandomFieldMethod.setAccessible(true);
        //when
        Field setField = (Field) getRandomFieldMethod.invoke(computer,occupiedFields);
        //then
        assertEquals(new Field(1,2),setField);
    }
}
