/**
 * Created by Alina Bengert on 7/24/2015.
 */

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.awt.image.RescaleOp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class FutureGenTest {
    private final ByteArrayOutputStream userDisplay = new ByteArrayOutputStream();

    @Before
    public void init(){ //setting up all the tests
        System.setOut(new PrintStream(userDisplay));
    }

    @Test
    public void displayCorrectInstructionsToUSer() throws IOException //testing to see if the system.out.println works correctly
    {
        FutureGen fut = new FutureGen();
        fut.displayFutureGenMessga(userDisplay);
        assertEquals("hello", userDisplay.toString());
    }


    @After
    public void cleanUP(){
        System.setOut(null);
    }
}
