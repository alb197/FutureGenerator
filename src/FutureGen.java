import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Alina Bengert on 7/24/2015.
 */
public class FutureGen {
    public static void main (String [] args){
        try {
            System.out.println(displayFutureGenMessageIntro(new ByteArrayOutputStream()));
            System.out.println(displayFutureGenMessageInstructions(new ByteArrayOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String displayFutureGenMessageIntro(ByteArrayOutputStream userDisplay) throws IOException {
        byte [] introduction = "Welcome to the Future Generator".getBytes();
        userDisplay.write(introduction);
        return userDisplay.toString();
    }

    public static String displayFutureGenMessageInstructions(ByteArrayOutputStream userDisplay) throws IOException {
        byte [] instructions = "For each category choose two options you want in your future and one you don't. What will your future hold?".getBytes();
        userDisplay.write(instructions);
        return userDisplay.toString();
    }


}
