import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class matheif {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your input");
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
        splint.add(0,0);
        splint.add(0,0);
        int total = 0;
        for(int k = 0; k<splint.size(); k=k){
            if(k+2>=splint.size()){
                k=splint.size();
                break;
            }
            if (k + 3 >= splint.size()) {
                total+=splint.get(k+2);
                k=splint.size();
                break;
            }
            if (k + 4 >= splint.size()) {
                if (splint.get(k + 2) > splint.get(k + 3)) {
                    total += splint.get(k + 2);
                } else {
                    total += splint.get(k + 3);
                }
                k = splint.size();
                break;
            }
            else{
                splint.add(0);
                splint.add(0);
                if(splint.get(k+2) + splint.get(k+4) < splint.get(k+3)){
                    total += splint.get(k+3);
                    k=k+3;
                }else if(splint.get(k+2) + splint.get(k+4) > splint.get(k+3) + splint.get(k+5)){
                    total += splint.get(k+2);
                    k=k+2;
                }else if(splint.get(k+3) + splint.get(k+5) >splint.get(k+2) + splint.get(k+4) + splint.get(k+6)){
                    total += splint.get(k+3);
                    k=k+3;
                }else if(splint.get(k+2) + splint.get(k+5) > splint.get(k+3) + splint.get(k+6) && splint.get(k+2) + splint.get(k+4) > splint.get(k+3) + splint.get(k+6)){
                    total += splint.get(k+2);
                    k=k+2;
                }else{
                    total += splint.get(k+3);
                    k=k+3;
                }
                splint.remove(splint.size()-1);
                splint.remove(splint.size()-1);
            }
        }
        System.out.println(total);
    }
}
