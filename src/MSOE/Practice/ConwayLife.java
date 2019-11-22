package MSOE.Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConwayLife {
    public static void main(String[] args){
        System.out.println("File path?");
        Scanner filereader = new Scanner(System.in);
        File txt = new File(filereader.nextLine());
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(txt);

        } catch(FileNotFoundException e){
            System.out.println("File not located.");
            return;
        }
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        sc.nextInt();
        int a = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < a; i++){
            board.add(new ArrayList<>(Arrays.asList(sc.nextLine().split("(?<=\\G.)"))));
        }

        String[][] array = new String[board.size()][];
        for (int i = 0; i < board.size(); i++) {
            ArrayList<String> row = board.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }

        String[][] bruh = createBorder(array);

        board.clear();
        for(int i = 0; i < bruh.length; i++){
            ArrayList<String> test = new ArrayList<>();
            test.addAll(Arrays.asList(bruh[i]));
            board.add(test);
        }
        System.out.println(display(board));

        while(true){
            for(int i = 1; i < board.size() - 1; i++){
                for(int j = 1; j < board.get(0).size() - 1; j++){
                    int neighbors = 0;
                    if(board.get(i).get(j).equals("1")){
                        neighbors--;
                    }
                    for(int row = i - 1; row <= i+1; row++){
                        for(int col = j - 1; col <= j+1; col++){
                            if(board.get(row).get(col).equals("1")){
                                neighbors++;
                            }
                        }
                    }
                    if(board.get(i).get(j).equals("1")){
                        if(neighbors <= 1 || neighbors >= 4){
                            board.get(i).set(j, "0");
                        }
                    }
                    else if(!board.get(i).get(j).equals("-1")){
                        if(neighbors == 3){
                            board.get(i).set(j, "1");
                        }
                    }
                }
            }
            System.out.println("==========");
            System.out.println(display(board));
        }

    }

    private static String display(ArrayList<ArrayList<String>> eee){
        StringBuilder finalAns = new StringBuilder();
        for(ArrayList<String> cur : eee){
            for(String bruh : cur){
                if(bruh.equals("-1")){
                    continue;
                }
                if(bruh.equals("0")){
                    finalAns.append(" ");
                }
                else {
                    finalAns.append("*");
                }
            }
            finalAns.append("\n");
        }
        return finalAns.toString();
    }

    private static String[][] createBorder(String[][] matrix) {
        //this is our 4x4 matrix
        String[][] borderedMatrix = new String[matrix.length+2][matrix[0].length+2];

        //fill the 4x4 matrix with -1's
        for(int i = 0; i < borderedMatrix.length; i++) {
            for(int j = 0; j < borderedMatrix[0].length; j++) {
                borderedMatrix[i][j] = "-1";
            }
        }

        //copy the values of the 2x2 into the 4x4 matrix, but push them one step to the right, and one step downwards
        for(int k = 0; k < matrix.length; k++) {
            for(int l = 0; l < matrix[0].length; l++) {
                borderedMatrix[k+1][l+1] = matrix[k][k];
            }
        }
        return borderedMatrix;
    }
}
