import java.util.*;

public class pa17 {
    private final static int MAX_VAL = 6000;
    private static int[][] memo = new int[MAX_VAL + 1][1001];

    private static int maxTower(int[] weights, int[] limits, int limit, int i) {
        if (limit == 0 || i == weights.length) {
            return 0;
        }

        if (memo[limit][i] != -1) {
            return memo[limit][i];
        }

        if (weights[i] > limit) {
            memo[limit][i] = maxTower(weights, limits, limit, i + 1);
        } else {
            memo[limit][i] = Math.max(
                maxTower(weights, limits, Math.min(limits[i], limit - weights[i]), i + 1) + 1,
                maxTower(weights, limits, limit, i + 1)
            );
        }

        return memo[limit][i];
    }

    private static void init() {
        for (int i = 0; i <= MAX_VAL; i++) {
            for (int j = 0; j < 1001; j++) {
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int N = sc.nextInt();
            int[] weights = new int[N], limits = new int[N];
            for (int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
                limits[i] = sc.nextInt();
            }
            init();

            System.out.println(maxTower(weights, limits, MAX_VAL, 0));
        }
    }
}