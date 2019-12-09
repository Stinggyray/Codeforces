package AdventOfCode;

import Utils.LoggingUtil;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Advent of Code Day 7
public class AmplificationCircuit {
    public static void main(String[] args) {
        runPart1();
    }

    public static void runPart1() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
        ArrayList<Integer> original = new ArrayList<>();

        original.addAll(splint);

        int i = 0; //pointer pos

        ArrayList<ArrayList<Integer>> combines = new ArrayList<>();

        for(int a = 0; a <= 4; a++){
            for(int b = 0; b <= 4; b++){
                if(b==a) continue;
                for(int c = 0; c <= 4; c++){
                    if(c==a || c==b) continue;
                    for(int d = 0; d <= 4; d++){
                        if(d==a || d==b || d==c) continue;
                        for(int e = 0; e <= 4; e++){
                            if(e==a || e==b || e==c || e==d) continue;
                            combines.add(new ArrayList<>(Arrays.asList(a, b, c, d, e)));
                        }
                    }
                }
            }
        }

        int curMax = Integer.MIN_VALUE;

        for(ArrayList<Integer> cur : combines) {

            System.out.println(LoggingUtil.logArrayListInts(cur));

            int lastOutput = 0;

            for (int bruhh = 0; bruhh < 5; bruhh++) {
                splint.clear();
                splint.addAll(original);
                i = 0;
                int inputNums = 0;

                while (true) {
                    //System.out.println("Currently at pos: " + i);

                    int opTypeStart = splint.get(i);
                    String opTypeParser = "" + opTypeStart;

                    while (opTypeParser.length() != 5) {
                        opTypeParser = "0" + opTypeParser;
                    }

                    int mode1 = opTypeParser.substring(2, 3).equals("0") ? 0 : 1;
                    int mode2 = opTypeParser.substring(1, 2).equals("0") ? 0 : 1;
                    int mode3 = opTypeParser.substring(0, 1).equals("0") ? 0 : 1;

                    int opType = splint.get(i) % 100;

                    if (opType == 99) {
                        break;
                    } else if (opType == 1) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int targetPos;
                        targetPos = splint.get(i + 3);
                        splint.set(targetPos, pos1 + pos2);

                        i += 4;
                    } else if (opType == 2) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int targetPos;
                        targetPos = splint.get(i + 3);
                        splint.set(targetPos, pos1 * pos2);

                        i += 4;
                    } else if (opType == 3) {
                        System.out.println("Input num: " + inputNums);
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(i + 1);
                        } else {
                            pos1 = i + 1;
                        }
                        System.out.println("Input?");
                        if(inputNums == 0){
                            System.out.println(cur.get(bruhh));
                            splint.set(pos1, cur.get(bruhh));
                        }
                        else {
                            System.out.println(lastOutput);
                            splint.set(pos1, lastOutput);
                        }

                        inputNums++;

                        i += 2;
                    } else if (opType == 4) {
                        int pos1 = splint.get(i + 1);
                        System.out.println("Opcode 4 Output:");
                        if (mode1 == 0) {
                            System.out.println(splint.get(pos1));
                            lastOutput = splint.get(pos1);
                        } else {
                            System.out.println(pos1);
                            lastOutput = pos1;
                        }

                        if(bruhh == 4){
                            System.out.println("We made it!");
                            curMax = Math.max(lastOutput, curMax);
                            System.out.println("Current max: " + curMax);
                        }
                        i += 2;
                    } else if (opType == 5) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        if (pos1 != 0) {
                            int pos2;
                            if (mode2 == 0) {
                                pos2 = splint.get(splint.get(i + 2));
                            } else {
                                pos2 = splint.get(i + 2);
                            }
                            i = pos2;
                        } else {
                            i += 3;
                        }
                    } else if (opType == 6) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        if (pos1 == 0) {
                            int pos2;
                            if (mode2 == 0) {
                                pos2 = splint.get(splint.get(i + 2));
                            } else {
                                pos2 = splint.get(i + 2);
                            }
                            i = pos2;
                        } else {
                            i += 3;
                        }
                    } else if (opType == 7) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int pos3;
                        if (mode3 == 0) {
                            pos3 = splint.get(i + 3);
                        } else {
                            pos3 = i + 3;
                        }

                        splint.set(pos3, pos1 < pos2 ? 1 : 0);
                        //System.out.println("Setting " + pos3 + " to:" + (pos1 < pos2 ? 1 : 0));
                        i += 4;
                    } else if (opType == 8) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int pos3;
                        if (mode3 == 0) {
                            pos3 = splint.get(i + 3);
                        } else {
                            pos3 = i + 3;
                        }
                        splint.set(pos3, pos1 == pos2 ? 1 : 0);
                        //System.out.println("Setting " + pos3 + " to:" + (pos1 == pos2 ? 1 : 0));
                        i += 4;
                    } else {
                        throw new InvalidParameterException();
                    }
                }
                //System.out.println(LoggingUtil.logArrayListInts(splint));
            }
        }
    }

    public static void runPart2() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
        ArrayList<Integer> original = new ArrayList<>();

        original.addAll(splint);

        int i = 0; //pointer pos

        ArrayList<ArrayList<Integer>> combines = new ArrayList<>();

        for(int a = 5; a <= 9; a++){
            for(int b = 5; b <= 9; b++){
                if(b==a) continue;
                for(int c = 5; c <= 9; c++){
                    if(c==a || c==b) continue;
                    for(int d = 5; d <= 9; d++){
                        if(d==a || d==b || d==c) continue;
                        for(int e = 5; e <= 9; e++){
                            if(e==a || e==b || e==c || e==d) continue;
                            combines.add(new ArrayList<>(Arrays.asList(a, b, c, d, e)));
                        }
                    }
                }
            }
        }

        int curMax = Integer.MIN_VALUE;

        for(ArrayList<Integer> cur : combines) {

            System.out.println(LoggingUtil.logArrayListInts(cur));

            int lastOutput = 0;

            for (int bruhh = 0; bruhh < 5; bruhh++) {
                splint.clear();
                splint.addAll(original);
                i = 0;
                int inputNums = 0;

                while (true) {
                    //System.out.println("Currently at pos: " + i);

                    int opTypeStart = splint.get(i);
                    String opTypeParser = "" + opTypeStart;

                    while (opTypeParser.length() != 5) {
                        opTypeParser = "0" + opTypeParser;
                    }

                    int mode1 = opTypeParser.substring(2, 3).equals("0") ? 0 : 1;
                    int mode2 = opTypeParser.substring(1, 2).equals("0") ? 0 : 1;
                    int mode3 = opTypeParser.substring(0, 1).equals("0") ? 0 : 1;

                    int opType = splint.get(i) % 100;

                    if (opType == 99) {
                        break;
                    } else if (opType == 1) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int targetPos;
                        targetPos = splint.get(i + 3);
                        splint.set(targetPos, pos1 + pos2);

                        i += 4;
                    } else if (opType == 2) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int targetPos;
                        targetPos = splint.get(i + 3);
                        splint.set(targetPos, pos1 * pos2);

                        i += 4;
                    } else if (opType == 3) {
                        System.out.println("Input num: " + inputNums);
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(i + 1);
                        } else {
                            pos1 = i + 1;
                        }
                        System.out.println("Input?");
                        if(inputNums == 0){
                            System.out.println(cur.get(bruhh));
                            splint.set(pos1, cur.get(bruhh));
                        }
                        else {
                            System.out.println(lastOutput);
                            splint.set(pos1, lastOutput);                        }

                        inputNums++;

                        i += 2;
                    } else if (opType == 4) {
                        int pos1 = splint.get(i + 1);
                        System.out.println("Opcode 4 Output:");
                        if (mode1 == 0) {
                            System.out.println(splint.get(pos1));
                            lastOutput = splint.get(pos1);
                        } else {
                            System.out.println(pos1);
                            lastOutput = pos1;
                        }

                        if(bruhh == 4){
                            System.out.println("We made it!");
                            curMax = Math.max(lastOutput, curMax);
                            System.out.println("Current max: " + curMax);
                        }
                        i += 2;
                    } else if (opType == 5) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        if (pos1 != 0) {
                            int pos2;
                            if (mode2 == 0) {
                                pos2 = splint.get(splint.get(i + 2));
                            } else {
                                pos2 = splint.get(i + 2);
                            }
                            i = pos2;
                        } else {
                            i += 3;
                        }
                    } else if (opType == 6) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        if (pos1 == 0) {
                            int pos2;
                            if (mode2 == 0) {
                                pos2 = splint.get(splint.get(i + 2));
                            } else {
                                pos2 = splint.get(i + 2);
                            }
                            i = pos2;
                        } else {
                            i += 3;
                        }
                    } else if (opType == 7) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int pos3;
                        if (mode3 == 0) {
                            pos3 = splint.get(i + 3);
                        } else {
                            pos3 = i + 3;
                        }

                        splint.set(pos3, pos1 < pos2 ? 1 : 0);
                        //System.out.println("Setting " + pos3 + " to:" + (pos1 < pos2 ? 1 : 0));
                        i += 4;
                    } else if (opType == 8) {
                        int pos1;
                        if (mode1 == 0) {
                            pos1 = splint.get(splint.get(i + 1));
                        } else {
                            pos1 = splint.get(i + 1);
                        }
                        int pos2;
                        if (mode2 == 0) {
                            pos2 = splint.get(splint.get(i + 2));
                        } else {
                            pos2 = splint.get(i + 2);
                        }
                        int pos3;
                        if (mode3 == 0) {
                            pos3 = splint.get(i + 3);
                        } else {
                            pos3 = i + 3;
                        }
                        splint.set(pos3, pos1 == pos2 ? 1 : 0);
                        //System.out.println("Setting " + pos3 + " to:" + (pos1 == pos2 ? 1 : 0));
                        i += 4;
                    } else {
                        throw new InvalidParameterException();
                    }
                }
                //System.out.println(LoggingUtil.logArrayListInts(splint));
            }
        }
    }
}
