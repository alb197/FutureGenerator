import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Alina Bengert on 7/24/2015.
 */
public class FutureGen {
    public static void main (String [] args){
        try {
            System.out.println(displayFutureGenMessga(new ByteArrayOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String displayFutureGenMessga(ByteArrayOutputStream userDisplay) throws IOException {
        byte [] b = "hello".getBytes();
        userDisplay.write(b);
        return userDisplay.toString();
    }

}
