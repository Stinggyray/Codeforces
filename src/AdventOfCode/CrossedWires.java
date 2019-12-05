package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//Advent of Code Day 3
public class CrossedWires {
    public static void main(String[] args){
        runPart2();
    }

    public static void runPart1(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> line1 = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
        ArrayList<String> line2 = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));

        HashMap<String, Integer> bruh = new HashMap<>();

        int curX = 0;
        int curY = 0;

        int counter = 0;

        for(String cur : line1){
            String direction = cur.substring(0, 1);
            cur = cur.substring(1);

            int curSteps = Integer.parseInt(cur);
            for(int i = 0; i < curSteps; i++){
                switch(direction){
                    case "U":
                        curY++;
                        break;
                    case "D":
                        curY--;
                        break;
                    case "L":
                        curX--;
                        break;
                    case "R":
                        curX++;
                        break;
                }
                bruh.put(curX + "," + curY, ++counter);
            }
        }

        ArrayList<ArrayList<Integer>> points = new ArrayList<>();
        curX = 0;
        curY = 0;

        for(String cur : line2){
            String direction = cur.substring(0, 1);
            cur = cur.substring(1);

            int curSteps = Integer.parseInt(cur);
            for(int i = 0; i < curSteps; i++){
                switch(direction){
                    case "U":
                        curY++;
                        break;
                    case "D":
                        curY--;
                        break;
                    case "L":
                        curX--;
                        break;
                    case "R":
                        curX++;
                        break;
                }

                if(bruh.containsKey(curX + "," + curY)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(curX);
                    temp.add(curY);

                    points.add(temp);
                }
            }
        }

        int curMin = Integer.MAX_VALUE;
        for(ArrayList<Integer> cur : points){
            if(Math.abs(cur.get(0)) + Math.abs(cur.get(1)) < curMin){
                curMin = Math.abs(cur.get(0)) + Math.abs(cur.get(1));
            }
        }
        System.out.println(curMin);
    }

    public static void runPart2(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> line1 = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
        ArrayList<String> line2 = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));

        HashMap<String, Integer> bruh = new HashMap<>();

        int curX = 0;
        int curY = 0;

        int counter = 0;

        for(String cur : line1){
            String direction = cur.substring(0, 1);
            cur = cur.substring(1);

            int curSteps = Integer.parseInt(cur);
            for(int i = 0; i < curSteps; i++){
                switch(direction){
                    case "U":
                        curY++;
                        break;
                    case "D":
                        curY--;
                        break;
                    case "L":
                        curX--;
                        break;
                    case "R":
                        curX++;
                        break;
                }
                bruh.put(curX + "," + curY, ++counter);
            }
        }

        curX = 0;
        curY = 0;

        int curMin = Integer.MAX_VALUE;

        counter = 0;

        for(String cur : line2){
            String direction = cur.substring(0, 1);
            cur = cur.substring(1);

            int curSteps = Integer.parseInt(cur);
            for(int i = 0; i < curSteps; i++){
                switch(direction){
                    case "U":
                        curY++;
                        break;
                    case "D":
                        curY--;
                        break;
                    case "L":
                        curX--;
                        break;
                    case "R":
                        curX++;
                        break;
                }

                counter++;

                if(bruh.containsKey(curX + "," + curY)){
                    curMin = Math.min(curMin, bruh.get(curX + "," + curY) + counter);
                }
            }
        }

        System.out.println(curMin);
    }
}
