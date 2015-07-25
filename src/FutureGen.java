import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Alina Bengert on 7/24/2015.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FutureGen {
    private static ArrayList<String> personToMarry = new ArrayList<String> ();
    private static ArrayList<String> PlaceToLive = new ArrayList<String> ();
    private static ArrayList<String> typeOfCar = new ArrayList<String> ();
    private static ArrayList<String> numberOfChildren = new ArrayList<String> ();
    private static ArrayList<String> typeOfResidence = new ArrayList<String> ();
    private static ArrayList<String> typeOfPet = new ArrayList<String> ();
    private static String person;
    private static String place;
    private static String children;
    private static String residence;
    private static String pet;
    private static String car;
    public static void main (String [] args){
        try {
            FutureGen futureGen = new FutureGen();
            System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), "Welcome to the Future Generator"));
            System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), "For each category choose two options you want in your future and one you don't. What will your future hold?"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String displayFutureGenMessage(ByteArrayOutputStream userDisplay, String stringthis) throws IOException {
        byte [] introduction = stringthis.getBytes();
        userDisplay.write(introduction);
        return userDisplay.toString();
    }
    public static String getUserResponse(InputStream input, ArrayList st){
        Scanner scan = new Scanner (input);
        String inp =scan.nextLine();
        st.add(inp);
        return String.valueOf(st.get(st.lastIndexOf(inp)));
    }

}
