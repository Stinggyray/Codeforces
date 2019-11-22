package MSOE.Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Dedekind {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> primes = primeFactors(num);
        ArrayList<Integer> nodupes = new ArrayList<>();
        for(int i = 0; i < primes.size(); i++){
            if(!nodupes.contains(primes.get(i))){
                nodupes.add(primes.get(i));
            }
        }
        int result = num;
        for(int cur : nodupes){
            result /= (cur);
        }
        for(int cur : nodupes){
            result *= (cur + 1);
        }
        System.out.println(result);
    }

    public static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        while (n%2==0) {
            primes.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2) {
            while (n%i == 0) {
                primes.add(i);
                n /= i;
            }
        }
        if (n > 2)
            primes.add(n);
        return primes;
    }
}
