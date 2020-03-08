import org.junit.Test;

import static org.junit.Assert.*;

public class Homework1Test {

    @Test
    public void isGivenTest() {
        assertEquals(true,new Homework1().isGiven(3));
        assertEquals(false,new Homework1().isGiven(4));
        assertEquals(true,new Homework1().isGiven(1000));
        assertEquals(true,new Homework1().isGiven(93));

    }
}