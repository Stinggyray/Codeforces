import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//Problem:
//https://codeforces.com/contest/1058/problem/C

//Algorithm:
/* 1. Add all numbers in the scanner's second line to an array of the digits, excluding all 0's as they don't matter
 * 2. Add up the first n numbers, looping through the whole thing
 * 3. Iterate and add to the cumulative counter until that cumulative sum is greater than or equal to n, then respond accordingly
 */
public class VasyaAndGoldenTicket {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        ArrayList<Integer> nums = new ArrayList<>();
        String[] numStrings = sc.nextLine().split("(?<=\\G.)");
        for(String cur : numStrings){
            if(!cur.equals("0")) {
                nums.add(parseInt(cur));
            }
        }
        if(nums.isEmpty()){
            System.out.println("YES");
            return;
        }
        sc.close();
        int curSum = 0;
        int counter = 0;
        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j <= i; j++){
                curSum += nums.get(j);
            }
            counter = 0;
            for(int k = i + 1; k < nums.size(); k++){
                counter += nums.get(k);
                if(counter == curSum && k == nums.size() - 1){
                    System.out.println("YES");
                    return;
                }
                else if(counter == curSum){
                    counter = 0;
                }
                else if(counter > curSum){
                    break;
                }
            }
            curSum = 0;
        }

        System.out.println("NO");
    }
}
