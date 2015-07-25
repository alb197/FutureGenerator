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
    public void displayCorrectIntroToUSer() throws IOException //testing to see if the system.out.println works correctly
    {
        FutureGen fut = new FutureGen();
        String st = fut.displayFutureGenMessageIntro(userDisplay);
        assertEquals("Welcome to the Future Generator", st);
    }
    @Test
    public void displayCorrectInstructionsToUser() throws IOException //testing to see if the system.out.println works correctly
    {
        FutureGen futu = new FutureGen();
        String str = futu.displayFutureGenMessageInstructions(userDisplay);
        assertEquals("For each category choose two options you want in your future and one you don't. What will your future hold?", str);
    }

    @After
    public void cleanUP(){
        System.setOut(null);
    }
}
