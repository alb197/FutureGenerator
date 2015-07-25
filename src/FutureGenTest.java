/**
 * Created by Alina Bengert on 7/24/2015.
 */

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.awt.image.RescaleOp;
import java.io.*;

import static org.junit.Assert.*;

public class FutureGenTest {
    private final ByteArrayOutputStream userDisplay = new ByteArrayOutputStream();
    private ByteArrayInputStream userAnswer;
    private FutureGen fut = new FutureGen();

    @Before
    public void init(){ //setting up all the tests

        System.setOut(new PrintStream(userDisplay));
        userAnswer = new ByteArrayInputStream("Test Input".getBytes());
        System.setIn(userAnswer);
    }

    @Test
    public void testDisplayCorrectIntroToUSer() throws IOException //testing to see if the system.out.println works correctly
    {

        String st = fut.displayFutureGenMessageIntro(userDisplay);
        assertEquals("Welcome to the Future Generator", st);
    }
    @Test
    public void testDisplayCorrectInstructionsToUser() throws IOException //testing to see if the system.out.println works correctly
    {

        String str = fut.displayFutureGenMessageInstructions(userDisplay);
        assertEquals("For each category choose two options you want in your future and one you don't. What will your future hold?", str);
    }
    @Test
    public void testCorrectUserInputIsCaptured() throws IOException //testing to see if the scanner works
    {
        String [] stAr = new String [3];
        fut.getUserResponse(userAnswer, stAr);
        assertEquals("Chris", stAr[0]);
    }



    @After
    public void cleanUP(){
        System.setOut(null);
        System.setIn(null);
    }
}
