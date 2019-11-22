import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrypticPoets {
    public static void main(String[] args) {
        Scanner filePrompter = new Scanner(System.in);
        System.out.println("File path?");
        File poem = new File(filePrompter.nextLine());
        Scanner sc = null;

        //initialize file scanner
        try {
            sc = new Scanner(poem);
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
            return;
        }

        //2D arraylist
        ArrayList<ArrayList<String>> words = new ArrayList<>();

        String cur = sc.nextLine();
        while (!cur.contains("END")) {
            //split the lines into words
            words.add(alphabetify(new ArrayList<>(Arrays.asList(cur.split(" ")))));
            cur = sc.nextLine();
        }

        StringBuilder message = new StringBuilder();
        while(true){
            try {
                message.append(sc.nextLine().replaceAll(" ", ""));
            } catch(NoSuchElementException e){
                break;
            }
        }

        String msg = message.toString();
        StringBuilder finalCipher = new StringBuilder();
        char[] msgchars = msg.toCharArray();
        char curChar = msgchars[0];
        int counter = 0;
        for(int j = 0; j < words.size() && j < 99; j++) {
            for (int k = 0; k < words.get(j).size() && k < 9; k++) {
                if(counter == msg.length()){
                    break;
                }
                curChar = msgchars[counter];
                if (!words.get(j).get(k).contains(curChar+"")) {
                    continue;
                }
                StringBuilder curCharCipher = new StringBuilder();
                if(j < 9) {
                    curCharCipher.append("0");
                    curCharCipher.append(j + 1);
                } else {
                    curCharCipher.append(j + 1);
                }
                curCharCipher.append(k + 1);
                curCharCipher.append(words.get(j).get(k).indexOf(curChar) + 1);

                finalCipher.append(curCharCipher);
                finalCipher.append(" ");

                counter++;
                break;
            }
            if(counter == msg.length()){
                break;
            }
        }
        if(counter != msg.length()){
            System.out.println("NOT POSSIBLE");
        }
        else {
            System.out.println(finalCipher.toString().trim());
        }
    }

    public static ArrayList<String> alphabetify(ArrayList<String> arr){
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).replaceAll("[^a-zA-Z]", ""));
        }
        return arr;
    }
}
