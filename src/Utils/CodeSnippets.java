package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CodeSnippets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Add another dot after the G for the number of chars you want to split by (remainder will be kept)
        ArrayList<String> split = new ArrayList<>(Arrays.asList(sc.nextLine().split("(?<=\\G.)")));

        System.out.println(LoggingUtil.logArrayList(split));



        sc.close();
    }

    public static boolean isPrime(int n) {
        return !new String(new char[n]).matches(".?|(..+?)\\1+");
    }
}
