package AdventOfCode;

import Utils.LoggingUtil;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Advent of Code day 2
public class ProgramAlarm {
    public static void main(String[] args) throws InvalidParameterException {
        //runPart1();
        runPart2();
    }

    public static void runPart1(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));

        for(int i = 0; i < splint.size(); i += 4){
            int opType = splint.get(i);
            int pos1 = splint.get(splint.get(i + 1));
            int pos2 = splint.get(splint.get(i + 2));
            int targetPos = splint.get(i + 3);

            if(opType == 99){
                break;
            }
            else if(opType == 1){
                splint.set(targetPos, pos1 + pos2);
            }
            else if(opType == 2){
                splint.set(targetPos, pos1 * pos2);
            }
            else {
                throw new InvalidParameterException();
            }
        }
        System.out.println(LoggingUtil.logArrayListInts(splint));
    }

    public static void runPart2(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));

        ArrayList<Integer> origList = new ArrayList<>();

        for(int cur : splint){
            origList.add(cur);
        }

        for(int splint1 = 0; splint1 < 100; splint1++) {
            for(int splint2 = 0; splint2 < 100; splint2++) {
                splint.set(1, splint1);
                splint.set(2, splint2);
                for (int i = 0; i < splint.size(); i += 4) {
                    int opType = splint.get(i);
                    int pos1 = splint.get(splint.get(i + 1));
                    int pos2 = splint.get(splint.get(i + 2));
                    int targetPos = splint.get(i + 3);

                    if (opType == 99) {
                        break;
                    } else if (opType == 1) {
                        splint.set(targetPos, pos1 + pos2);
                    } else if (opType == 2) {
                        splint.set(targetPos, pos1 * pos2);
                    } else {
                        throw new InvalidParameterException();
                    }
                }
                if (splint.get(0) == 19690720) {
                    System.out.println("" + splint1 + splint2);
                    return;
                }
                else{
                    splint.clear();
                    for(int cur : origList){
                        splint.add(cur);
                    }
                }
            }
        }

    }
}
