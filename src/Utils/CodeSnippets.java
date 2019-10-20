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

    //I don't know how this works. It's also really inefficient.
    public static boolean isPrimeShort(int n) {
        return !new String(new char[n]).matches(".?|(..+?)\\1+");
    }

    //This one works better.
    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}
