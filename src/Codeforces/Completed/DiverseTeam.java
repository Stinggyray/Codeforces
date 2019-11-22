package Codeforces.Completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiverseTeam {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int distincts = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
        sc.close();

        ArrayList<Integer> bruh = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 0; i < splint.size(); i++){
            if(!bruh.contains(splint.get(i))){
                bruh.add(splint.get(i));
                indices.add(i);
            }
        }

        System.out.println(distincts <= bruh.size() ? "YES" : "NO");
        if(distincts <= bruh.size()){
            for(int i = 0 ; i < distincts; i++){
                System.out.print((indices.get(i) + 1)+ " ");
            }
        }
    }
}
