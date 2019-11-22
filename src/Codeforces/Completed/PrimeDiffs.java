package Codeforces.Completed;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/1238/A
//Do I even need to explain this algorithm?
public class PrimeDiffs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long b, c;
        for(int i = 0; i < a; i++){
            sc.nextLine();
            b = sc.nextLong();
            c = sc.nextLong();
            System.out.println((b - c == 1) ? "NO" : "YES");
        }
    }
}
