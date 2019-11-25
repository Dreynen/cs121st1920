import java.util.*;

public class pa16 {
    private static int[] memo;
    private static int frogger(int[] a, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.abs(a[n] - a[n - 1]);
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = Math.min(
            Math.abs(a[n] - a[n - 1]) + frogger(a, n - 1),
            Math.abs(a[n] - a[n - 2]) + frogger(a, n - 2)
        );
        return memo[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int N = sc.nextInt();
            int[] a = new int[N];
            memo = new int[10001];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(frogger(a, N - 1));
        }
    }
}