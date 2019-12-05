package AdventOfCode;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RocketEquation {
    //Advent of Code day 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cur = sc.nextLine();
        StringBuilder answer = new StringBuilder();
        int sum = 0;
        int curInt = 0;
        while (true) {
            try {
                //Part 2
                curInt = ((Integer.parseInt(cur) / 3) - 2);
                while(curInt > 0){
                    sum += curInt;
                    curInt /= 3;
                    curInt -= 2;
                }
                cur = sc.nextLine();
            } catch (NoSuchElementException | NumberFormatException e){
                break;
            }
        }
        sc.close();
        System.out.println(sum);
    }
}
