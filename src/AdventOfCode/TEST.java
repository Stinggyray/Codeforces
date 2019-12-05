package AdventOfCode;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Advent of Code Day 5
public class TEST {
    public static void main(String[] args){
        runPart2();
    }

    public static void runPart1(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));

        for(int i = 0; i < splint.size(); i += 4){
            int opTypeStart = splint.get(i);
            String opTypeParser = "" + opTypeStart;

            while(opTypeParser.length() != 5){
                opTypeParser = "0" + opTypeParser;
            }

            //System.out.println(opTypeParser);

            int mode1 = opTypeParser.substring(2, 3).equals("0") ? 0 : 1;
            int mode2 = opTypeParser.substring(1, 2).equals("0") ? 0 : 1;
            int mode3 = opTypeParser.substring(0, 1).equals("0") ? 0 : 1;

            int opType = splint.get(i) % 100;

            if(opType == 99){
                break;
            }
            else if(opType == 1){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                int pos2;
                if(mode2 == 0){
                    pos2 = splint.get(splint.get(i + 2));
                } else {
                    pos2 = splint.get(i + 2);
                }
                int targetPos;
                targetPos = splint.get(i + 3);
                splint.set(targetPos, pos1 + pos2);
            }
            else if(opType == 2){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                int pos2;
                if(mode2 == 0){
                    pos2 = splint.get(splint.get(i + 2));
                } else {
                    pos2 = splint.get(i + 2);
                }
                int targetPos;
                targetPos = splint.get(i + 3);
                splint.set(targetPos, pos1 * pos2);
            }
            else if(opType == 3){
                int pos1 = splint.get(i + 1);
                System.out.println("Input?");
                splint.set(pos1, sc.nextInt());
                i -= 2;
            }
            else if(opType == 4){
                int pos1 = splint.get(i + 1);
                System.out.println("Opcode 4 Output:");
                if(mode1 == 0){
                    System.out.println(splint.get(pos1));
                } else {
                    System.out.println(pos1);
                }
                i -= 2;
            }
            else {
                System.out.println(opTypeParser);
                throw new InvalidParameterException();
            }
        }
    }

    public static void runPart2(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));

        int i = 0; //pointer pos

        while(true){
            int opTypeStart = splint.get(i);
            String opTypeParser = "" + opTypeStart;

            while(opTypeParser.length() != 5){
                opTypeParser = "0" + opTypeParser;
            }

            //System.out.println(opTypeParser);

            int mode1 = opTypeParser.substring(2, 3).equals("0") ? 0 : 1;
            int mode2 = opTypeParser.substring(1, 2).equals("0") ? 0 : 1;
            int mode3 = opTypeParser.substring(0, 1).equals("0") ? 0 : 1;

            int opType = splint.get(i) % 100;

            if(opType == 99){
                break;
            }
            else if(opType == 1){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                int pos2;
                if(mode2 == 0){
                    pos2 = splint.get(splint.get(i + 2));
                } else {
                    pos2 = splint.get(i + 2);
                }
                int targetPos;
                targetPos = splint.get(i + 3);
                splint.set(targetPos, pos1 + pos2);

                i += 4;
            }
            else if(opType == 2){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                int pos2;
                if(mode2 == 0){
                    pos2 = splint.get(splint.get(i + 2));
                } else {
                    pos2 = splint.get(i + 2);
                }
                int targetPos;
                targetPos = splint.get(i + 3);
                splint.set(targetPos, pos1 * pos2);

                i += 4;
            }
            else if(opType == 3){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(i + 1);
                } else {
                    pos1 = i + 1;
                }
                System.out.println("Input?");
                splint.set(pos1, sc.nextInt());
                i += 2;
            }
            else if(opType == 4){
                int pos1 = splint.get(i + 1);
                System.out.println("Opcode 4 Output:");
                if(mode1 == 0){
                    System.out.println(splint.get(pos1));
                } else {
                    System.out.println(pos1);
                }
                i += 2;
            }
            else if(opType == 5){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                if(pos1 != 0){
                    int pos2;
                    if(mode2 == 0){
                        pos2 = splint.get(splint.get(i + 2));
                    } else {
                        pos2 = splint.get(i + 2);
                    }
                    i = pos2;
                } else {
                    i += 3;
                }
            }
            else if(opType == 6){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                if(pos1 == 0){
                    int pos2;
                    if(mode2 == 0){
                        pos2 = splint.get(splint.get(i + 2));
                    } else {
                        pos2 = splint.get(i + 2);
                    }
                    i = pos2;
                } else {
                    i += 3;
                }
            }
            else if(opType == 7){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                int pos2;
                if(mode2 == 0){
                    pos2 = splint.get(splint.get(i + 2));
                } else {
                    pos2 = splint.get(i + 2);
                }
                int pos3;
                if(mode3 == 0){
                    pos3 = splint.get(splint.get(i + 2));
                } else {
                    pos3 = splint.get(i + 2);
                }
                splint.set(pos3, pos1 < pos2 ? 1 : 0);
                i += 4;
            }
            else if(opType == 8){
                int pos1;
                if(mode1 == 0){
                    pos1 = splint.get(splint.get(i + 1));
                } else {
                    pos1 = splint.get(i + 1);
                }
                int pos2;
                if(mode2 == 0){
                    pos2 = splint.get(splint.get(i + 2));
                } else {
                    pos2 = splint.get(i + 2);
                }
                int pos3;
                if(mode3 == 0){
                    pos3 = splint.get(splint.get(i + 2));
                } else {
                    pos3 = splint.get(i + 2);
                }
                splint.set(pos3, pos1 == pos2 ? 1 : 0);
                i += 4;
            }
            else {
                throw new InvalidParameterException();
            }
        }
    }
}
