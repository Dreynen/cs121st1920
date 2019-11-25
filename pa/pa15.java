import java.util.*;
import java.io.*;

public class pa15 {
    private static int[][] memo = new int[1001][1001];

    public static int lcs(String s, String t, int si, int ti) {
        if(s.equals("") || t.equals("")) {
            return 0;
        }

        if (memo[si][ti] != -1) { return memo[si][ti]; }

        int ma = Math.max(
            lcs(s.substring(1, s.length()), t, si + 1, ti),
            lcs(s, t.substring(1, t.length()), si, ti + 1)
        );

        if(s.charAt(0) == t.charAt(0)) {
            int choice3 = 1 + lcs(
                s.substring(1, s.length()),
                t.substring(1, t.length()),
                si + 1,
                ti + 1
            );
            ma = Math.max(ma, choice3);
        }
        memo[si][ti] = ma;
        return ma;
    }

    public static void init() {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-->0) {
            String s = sc.nextLine(), t = sc.nextLine();
            init();
            System.out.println(lcs(s, t, 0, 0));
        }
    }
}
