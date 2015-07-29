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
    private static final String [] categories = new String []{"Person to marry (ex: Chris)", " Country to live in (ex: Russia)", "Type of car (ex: Subaru)"," A pet you want (ex: Dog)", "Type of Residence (ex: Mansion)", "Number of Children (ex: 2)" };
    private static final String PositiveMessage = "Enter %s that you like.";
    private static final String NegativeMessage = "Enter %s that you do not like.";
    private static final PrintStream SYSTEM_OUT = null;
    private static final OutputStream Sys = null;

    public static void main (String [] args){
        try {
            FutureGen futureGen = new FutureGen();
            System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), "Welcome to the Future Generator"));
            System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), "For each category choose two options you want in your future and one you don't. What will your future hold?"));
            addCategories();
            //populateArrayList();
            for (int i = 0; i <categories.length; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (j == 0 || j == 1) {
                        System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), String.format(PositiveMessage, categories[i])));
                    } else {
                        System.out.println(displayFutureGenMessage(new ByteArrayOutputStream(), String.format(NegativeMessage, categories[i])));
                    }
                    getUserResponse(System.in, categoriesArray.get(i));

                }

            }
            ArrayList<String> pk = showResults();
            System.out.println("You will marry " + pk.get(0).toString()+" and live in a beautiful " + pk.get(4).toString()+" in " + pk.get(1).toString() + ". ");
            System.out.println("You will drive home in your " + pk.get(2).toString()+" with your " + pk.get(5).toString()+" kids to pick up your adorable new " + pk.get(3).toString());
            System.out.println(" ");


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
    public static int getRandomNumber(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(2);
        return randomInt;
    }
   public static ArrayList<String> showResults() throws IOException {
       ArrayList<String> finalResult = new ArrayList<String>(6);
       ArrayList<String> nonResults = new ArrayList<String>(12);
       int r = 0;
       for (int i = 0; i < categoriesArray.size(); i++) {
           r = getRandomNumber();
           finalResult.add(categoriesArray.get(i).get(r));
           categoriesArray.get(i).remove(r);
       }
       return finalResult;
   }

}
