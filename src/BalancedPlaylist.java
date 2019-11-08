import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BalancedPlaylist {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int iters = sc.nextInt();
        sc.nextLine();
        ArrayList<String> split = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        ArrayList<Integer> numbers = new ArrayList<>();

        for(String cur : split){
            numbers.add(parseInt(cur));
            System.out.println(cur);
        }
        sc.close();

        int maxCool = 0;
        for(int i = 0; i < iters; i++){
            for(int k = i; k != i - 1; k++){
                if(k >= iters){
                    k -= iters;
                }
                //if()
            }
        }
    }
}
