import java.util.*;

public class lab9a {
    private static long[][] memof = new long[67][67];
    private static long[][] memog = new long[67][67];

    private static long f(int n, int s) {
        if (s < 0 || n <= 0) { return 0; }

        if (memof[n][s] != -1) { return memof[n][s]; }

        long v;
        if (s > n || (n == 1 && s == 1)) {
            v = 0;
        } else if (n == 1 && s == 0) {
            v = 1;
        } else {
            v = f(n - 1, s) + g(n - 1, s + 1);
        }

        memof[n][s] = v;
        return v;
    }

    private static long g(int n, int s) {
        if (s < 0 || n <= 0) { return 0; }

        if (memog[n][s] != -1) { return memog[n][s]; }

        long v;
        if (s > n || (n == 1 && s == 0)) {
            v = 0;
        } else if (n == 1 && s == 1) {
            v = 1;
        } else {
            v = f(n - 1, s - 1) + g(n - 1, s - 1);
        }

        memog[n][s] = v;

        return v;
    }

    private static void init() {
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {
                memof[i][j] = -1;
                memog[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T, N, S;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-->0) {
            N = sc.nextInt();
            S = sc.nextInt();
            init();
            System.out.println(f(N, S) + g(N, S));
        }
    }
}