package MSOE.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PizzaSchedule {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> schedules = new ArrayList<>();
        while(true){
            int cur = sc.nextInt();
            if(cur == 0){
                break;
            }
            schedules.add(cur);
        }
        Collections.sort(schedules);
        sc.close();

        int[] bruh = new int[365];


        boolean success = true; // a global schedule was found
        for (int idx = 1; idx < schedules.size(); ++idx) {
            int left = 0; // left scheduling bound
            int right = schedules.get(idx)-1;
            while (right >= left)
            {
                if (bruh[right] == 0)
                {
                    bruh[right] = schedules.get(idx); // schedule it
                    left = right + 1;
                    right = left + schedules.get(idx) - 1;
                    if (right >= 365) // element satisfied through end of schedule
                        break;
                } else {
                    right = right - 1;
                    if (right < left) {
                        System.err.println("Cannot schedule");
                        success = false;
                    }
                }
            }
        }
        if(success) {
            System.out.println("The schedule is...");
            System.out.println(bruh.toString());
        }
    }
}
