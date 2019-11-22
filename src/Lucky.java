import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lucky {
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
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        while (true) {
            //split the lines into integers, omitting spaces
            try {
                ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
                matrix.add(splint);
            } catch(NoSuchElementException e){
                break;
            }
        }

    }

    ArrayList<Integer> subArraySum(ArrayList<Integer> arr, int n, int sum)
    {
        int curr_sum, i, j;

        // Pick a starting point
        for (i = 0; i < n; i++)
        {
            curr_sum = arr.get(i);

            // try all subarrays starting with 'i'
            for (j = i + 1; j <= n; j++)
            {
                if (curr_sum == sum)
                {
                    int p = j - 1;
                    ArrayList<Integer> results = new ArrayList<Integer>();
                    for(int z = i; z <= p; z++){
                        results.add(arr.get(z));
                    }
                    return results;
                }
                if (curr_sum > sum || j == n)
                    break;
                curr_sum = curr_sum + arr.get(j);
            }
        }
        return null;
    }
}
