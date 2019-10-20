package Utils;

import java.util.List;

public class LoggingUtil {
    public static String logArrayList(List<String> bruh){
        StringBuilder cur = new StringBuilder();
        cur.append("[");
        for(String curObj : bruh){
            cur.append(curObj);
            cur.append(",");
        }
        return cur.substring(0, cur.length() - 1) + "]";
    }
    public static String logArrayListInts(List<Integer> bruh){
        StringBuilder cur = new StringBuilder();
        cur.append("[");
        for(int curObj : bruh){
            cur.append(curObj);
            cur.append(",");
        }
        return cur.substring(0, cur.length() - 1) + "]";
    }
}
