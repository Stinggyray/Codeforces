package AdventOfCode;

//Advent of Code Day 4
public class SecureContainer {
    public static void main(String[] args){
        runPart2();
    }

    public static void runPart1(){
        int counter = 0;
        for(int i = 178416; i <= 676461; i++) {
            if (hasConsecutives(i+"") && (i + "").matches("^1*2*3*4*5*6*7*8*9*$")) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void runPart2(){
        int counter = 0;
        for(int i = 178416; i <= 676461; i++) {
            if (hasDoubleConsecutives(i+"") && (i + "").matches("^1*2*3*4*5*6*7*8*9*$")) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static boolean hasConsecutives(String input){
        char[] bruh = input.toCharArray();
        for(int i = 0; i < bruh.length - 1; i++){
            if(bruh[i] == bruh[i+1]){
                return true;
            }
        }
        return false;
    }

    public static boolean hasDoubleConsecutives(String input){
        char[] bruh = input.toCharArray();
        for(int i = 0; i < bruh.length - 1; i++){
            if(bruh[i] == bruh[i+1]){
                if(i == 0){
                    if(bruh[i] != bruh[i + 2]){
                        return true;
                    }
                }
                else if(i == bruh.length - 2){
                    if(bruh[i - 1] != bruh[i]){
                        return true;
                    }
                }
                else {
                    if(bruh[i - 1] != bruh[i] && bruh[i + 2] != bruh[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
