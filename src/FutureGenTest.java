/**
 * Created by Alina Bengert on 7/24/2015.
 */

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.awt.image.RescaleOp;
import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FutureGenTest {
    private final ByteArrayOutputStream userDisplay = new ByteArrayOutputStream();
    private ByteArrayInputStream userAnswer;
    private FutureGen fut = new FutureGen();
    private String sts = "Test Input";

    @Before
    public void init(){ //setting up all the tests

        System.setOut(new PrintStream(userDisplay));
        userAnswer = new ByteArrayInputStream("Test Input".getBytes());
        System.setIn(userAnswer);
    }

    @Test
    public void testDisplayCorrectIntroToUSer() throws IOException //testing to see if the system.out.println works correctly
    {

        String st = fut.displayFutureGenMessage(userDisplay, sts);
        assertEquals(st, sts);
    }
    @Test
    public void testCorrectUserInputIsCaptured() throws IOException //testing to see if the scanner works
    {
        ArrayList <String> stAr = new ArrayList<String>();
        fut.getUserResponse(userAnswer, stAr);
        assertEquals("Test Input", stAr.get(stAr.lastIndexOf("Test Input")));
    }



    @After
    public void cleanUP(){
        System.setOut(null);
        System.setIn(null);
    }
}
