import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Towers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        ArrayList<Integer> splint = new ArrayList<Integer>(IntStream.of(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList()));
        sc.close();

        ArrayList<Integer> newList = new ArrayList<Integer>();
        int bruh = mode(splint) != 0 ? mode(splint) : splint.get(0);
        int counter = 0;
        for (int cur : splint) {
            if (!newList.contains(cur)) {
                newList.add(cur);
            }
            if(cur == bruh){
                counter++;
            }
        }
        System.out.print(counter + " " + newList.size());
    }

    public static int mode(ArrayList<Integer> n) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max  = 1;
        int temp = 0;

        for(int i = 0; i < n.size(); i++) {

            if (hm.get(n.get(i)) != null) {

                int count = hm.get(n.get(i));
                count++;
                hm.put(n.get(i), count);

                if(count > max) {
                    max  = count;
                    temp = n.get(i);
                }
            }

            else
                hm.put(n.get(i),1);
        }
        return temp;
    }
}