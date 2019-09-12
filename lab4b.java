import java.util.*;

public class lab4b {
    static boolean endsWithVowelY (String s) {
        String[] vowels = "aeiou".split("");
        s = s.substring(0, s.length() - 1);
        for (int i = 0; i < 5; i++) {
            if (s.endsWith(vowels[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> dict = new HashMap<String,String>();
        char[] vowels = "aeiou".toCharArray();

        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String[] input = sc.nextLine().split("\\s+");
            dict.put(input[0], input[1]);
        }
        int Q = sc.nextInt();
        sc.nextLine();
        while (Q-->0) {
            String str = sc.next();
            if (dict.containsKey(str)) {
                str = dict.get(str);
            } else if (str.endsWith("y") && !endsWithVowelY(str)) {
                str = str.substring(0, str.length() - 1) + "ies";
            } else {
                if (str.endsWith("o")
                || str.endsWith("s")
                || str.endsWith("x")
                || str.endsWith("ch")
                || str.endsWith("sh")) {
                    str = str + "es";
                } else {
                    str = str + "s";
                }
            }
            System.out.println(str);
        }
    }
}