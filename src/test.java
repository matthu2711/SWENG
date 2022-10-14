import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;


@RunWith(JUnit4.class)
public class test {
    
    @Test
    public void testBasicOps()
    {
        assertEquals(10, Main.Calculator("8+2"));
        assertEquals(true, Main.returnValid());
        assertEquals(16, Main.Calculator("4*4"));
        assertEquals(true, Main.returnValid());
        assertEquals(10, Main.Calculator("15-5"));
        assertEquals(true, Main.returnValid());
    }

    @Test
    public void testWrongInput()
    {
        assertEquals(-1, Main.Calculator("*()4+8"));
        assertEquals(false, Main.returnValid());

        //check if valid input works after failing input
        assertEquals(10, Main.Calculator("15-5"));
        assertEquals(true, Main.returnValid());
    }

    @Test
    public void testComplexOp()
    {
        assertEquals(50, Main.Calculator("2+6*8"));
        assertEquals(47, Main.Calculator("2+6*8-3"));
    }

}
