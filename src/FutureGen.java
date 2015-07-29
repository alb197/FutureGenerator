import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

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
    private static final ArrayList<ArrayList<String>> categoriesArray = new ArrayList<ArrayList<String>>();
    private static String person;
    private static String place;
    private static String children;
    private static String residence;
    private static String pet;
    private static String car;
    private static final String [] categories = new String []{"Person you will marry (ex: Chris, Channing etc.)", " Country you will live in (ex: Russia, Japan etc.)", "Type of car you will drive (ex: Subaru, Limo etc.)"," Pet you will have (ex: Dog, Tiger etc.)", "Residence you will live in (ex: House, Mansion etc.)", "Number of Children you will pop out (ex: 2, 11 etc.)" };
    private static final String PositiveMessage = "Please enter %s that you do like.";
    private static final String NegativeMessage = "Please enter %s that you do not like.";
    public static void main (String [] args){
        try {
            FutureGen futureGen = new FutureGen();
            System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), "Welcome to the Future Generator"));
            System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), "For each category choose two options you want in your future and one you don't. What will your future hold?"));
            addCategories();
           //populateArrayList();
            for (int i = 0; i < categories.length; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (j == 0 || j == 1) {
                        System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), String.format(PositiveMessage, categories[i])));
                    } else {
                        System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), String.format(NegativeMessage, categories[i])));
                    }
                    getUserResponse(System.in, categoriesArray.get(i));
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String displayFutureGenMessage(ByteArrayOutputStream userDisplay, String stringthis) throws IOException {
        byte [] info = stringthis.getBytes();
        userDisplay.write(info);
        return userDisplay.toString();
    }
    public static String getUserResponse(InputStream input, ArrayList st){
        Scanner scan = new Scanner (input);
        String inp =scan.nextLine();
        st.add(inp);
        return String.valueOf(st.get(st.lastIndexOf(inp)));
    }
    /*public static void populateArrayList(InputStream input) throws IOException {

                getUserResponse(input, categoriesArray.get(i));
    }*/
        public static void addCategories(){
        categoriesArray.add(personToMarry);
        categoriesArray.add(PlaceToLive);
        categoriesArray.add(typeOfCar);
        categoriesArray.add(typeOfPet);
        categoriesArray.add(typeOfResidence);
        categoriesArray.add(numberOfChildren);
    }

    public ArrayList<ArrayList<String>> getCategoriesArray(){
        return categoriesArray;
    }
    public int getRandomNumber (){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(300);
        return randomInt;
    }
   /* public String showResults(String [] s, int r){
        for( int i =0; i<r; i++){
            getUserResponse();
        }

            System.out.println();
        return null;
    }*/

}
