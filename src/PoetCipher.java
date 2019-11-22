import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PoetCipher {
    public static void main(String[] args){
        Scanner filePrompter = new Scanner(System.in);
        System.out.println("File path?");
        File poem = new File(filePrompter.nextLine());
        Scanner sc = null;

        //initialize file scanner
        try {
            sc = new Scanner(poem);
        } catch(FileNotFoundException e){
            System.out.println("No file found.");
            return;
        }

        //2D arraylist
        ArrayList<ArrayList<String>> words = new ArrayList<>();

        String cur = sc.nextLine();
        while(!cur.contains("END")) {
            //split the lines into words
            words.add(alphabetify(new ArrayList<>(Arrays.asList(cur.split(" ")))));
            cur = sc.nextLine();
        }

        //fetch the cipher
        ArrayList<String> cipher = new ArrayList<>();
        cur = cur.substring(cur.indexOf("END") + 3).trim();
        while(true){
            cipher.addAll(Arrays.asList(cur.split(" ")));
            try {
                cur = sc.nextLine();
            } catch(NoSuchElementException e){
                break;
            }
        }

        ArrayList<Integer> filteredCipher = new ArrayList<>();
        for(String c : cipher){
            if(c.matches("^[a-zA-Z]*$") && !c.isEmpty()){
                break;
            }
            try {
                filteredCipher.add(Integer.parseInt(c));
            } catch(NumberFormatException e){

            }
        }

        StringBuilder finalAnswer = new StringBuilder();
        finalAnswer.append("message: ");
        for(int c : filteredCipher){
            String curString = c + "";
            if(curString.length() == 3){
                curString = "0" + curString;
            }
            int lineNum = Integer.parseInt(curString.substring(0, 2));
            int wordNum = Integer.parseInt(curString.substring(2, 3));
            int letterNum = Integer.parseInt(curString.substring(3));

            finalAnswer.append(words.get(lineNum - 1).get(wordNum - 1).substring(letterNum - 1, letterNum));
        }

        System.out.println(finalAnswer.toString());
    }

    //removes all non-alphabetic chars from a string array
    public static ArrayList<String> alphabetify(ArrayList<String> arr){
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).replaceAll("[^a-zA-Z]", ""));
        }
        return arr;
    }
}
