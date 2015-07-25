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
            System.out.println(displayFutureGenMessageIntro(new ByteArrayOutputStream()));
            System.out.println(displayFutureGenMessageInstructions(new ByteArrayOutputStream()));
            //System.out.println("Enter two people you want to  marry, and one you definitely don't");
            //String userInput = FutureGen.getUserResponse(System.in);
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
    public static String getUserResponse(InputStream input, ArrayList st){
        Scanner scan = new Scanner (input);
        String inp =scan.nextLine();
        st.add(inp);
        return String.valueOf(st.get(st.lastIndexOf(inp)));
    }

}
