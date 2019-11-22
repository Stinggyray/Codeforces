import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxThievery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your input");
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
        System.out.println(maxSum(splint));
    }

    public static int maxSum(ArrayList<Integer> args){
        //Calculate max sum with and without current int
        int include = args.get(0);
        int exclude = 0;

        int temp;

        //Use this algorithm to find the maximum
        for(int i = 1; i < args.size(); i++){
            temp = Math.max(include, exclude);
            include = exclude + args.get(i);
            exclude = temp;
        }

        //Whichever one is greater is the correct one
        return Math.max(include, exclude);
    }
}
