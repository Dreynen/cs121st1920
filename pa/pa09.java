import java.util.*;

public class pa9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            map.put(k, map.containsKey(k) ? map.get(k) + 1 : 1);
        }

        for (int k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }
    }
}