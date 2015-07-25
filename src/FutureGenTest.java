/**
 * Created by Alina Bengert on 7/24/2015.
 */

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class FutureGenTest {
     private final ByteArrayOutputStream userDisplay = new ByteArrayOutputStream();

    @Before
    public void init(){ //setting up all the tests
        System.setOut(new PrintStream(userDisplay));
    }

    @Test
    public void displayCorrectInstructionsToUSer() //testing to see if the system.out.println works correctly
    {
       FutureGen fut = new FutureGen();
       assertEquals("Welcome to the Future Generator",userDisplay.toString());
    }



    @After
    public void cleanUP(){
        System.setOut(null);
    }
}
