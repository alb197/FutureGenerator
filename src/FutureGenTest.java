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
    private static final String [] cat = new String []{"Person you will marry (ex: Chris, Channing etc.)", " Country you will live in (ex: Russia, Japan etc.)", "Type of car you will drive (ex: Subaru, Limo etc.)"," Pet you will have (ex: Dog, Tiger etc.)", "Residence you will live in (ex: House, Mansion etc.)", "Number of Children you will pop out (ex: 2, 11 etc.)" };
    private ArrayList<ByteArrayInputStream> allUsersAnswers = new ArrayList<ByteArrayInputStream>();
    private String[] userInput = new String[] {"Chris", "Elad", "Ryan", "Moscow", "Pittsburgh", "Chicago", "Subaru", "Limo", "Toyota", "Cat", "Fish", "House", "Box", "Hotel", "7", "2", "1"};
    private static final String PositiveMessage = "Please enter %s that you do like.";
    private static final String NegativeMessage = "Please enter %s that you do not like.";


    @Before
    public void init(){ //setting up all the tests

        System.setOut(new PrintStream(userDisplay));
        userAnswer = new ByteArrayInputStream("Test Input".getBytes());
        for(int i = 0; i < userInput.length; i++){
            allUsersAnswers.add(new ByteArrayInputStream(userInput[i].getBytes()));
        }
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
    @Test
    public void checkAddCategoriesMethod(){
        fut.addCategories();
        fut.getCategoriesArray();
        assertEquals(fut.getCategoriesArray().size(), 6);
    }
   /*@Test
     public void testAbleToPopulateArrayList()throws IOException{ //testing to see if the arraylist is populating user input
        fut.addCategories();
        String fml = null;
       ArrayList<ArrayList<String>> list = fut.getCategoriesArray();
       for (int i = 0; i < cat.length; i++) {
           for (int j = 0; j <= 2; j++) {
               if (j == 0 || j == 1) {
                   System.out.println(fut.displayFutureGenMessage(new ByteArrayOutputStream(), String.format(PositiveMessage, cat[i])));
               } else {
                   System.out.println(fut.displayFutureGenMessage(new ByteArrayOutputStream(), String.format(NegativeMessage, cat[i])));
               }
               fml= fut.getUserResponse(allUsersAnswers.get(i), list.get(i));
           }
               assertEquals(userInput[i], fml);
        }
    }*/
    @Test
    public void numberWasGeneratedInRange() {
        int random;
        int min =0;
        int max = 300;
        for (int i = 0; i < 300; i++) {
            random = fut.getRandomNumber();
            assert(random>=min && random<=max);

        }
    }
    /*@Test
    public void correctResultsAreShown(){
        int rand = fut.getRandomNumber();
        fut.showResults(userInput,rand);

    }
*/

    @After
    public void cleanUP(){
        System.setOut(null);
        System.setIn(null);
    }
}
