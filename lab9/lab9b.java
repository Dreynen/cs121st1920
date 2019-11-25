import java.util.*;
import java.io.*;

public class lab9b {
    private static int memo[] = new int[1001];
    private static int MAX_VAL = 200000;

    public static int knapsack(int weights[], int values[], int capacity) {
        if (capacity == 0) {
            return 0;
        }
        if (memo[capacity] != -1) {
            return memo[capacity];
        }
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            if (capacity < weights[i]) { continue; }
            max = Math.max(max, knapsack(weights, values, capacity - weights[i]) + values[i]);
        }
        memo[capacity] = max;
        return memo[capacity];
    }

    private static void init(int capacity) {
        for (int i = 0; i < capacity; i++) {
            memo[i] = -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int B = sc.nextInt(), N = sc.nextInt();
            int[] W = new int[N], V = new int[N];
            init(B);
            for (int i = 0; i < N; i++) {
                V[i] = sc.nextInt();
                W[i] = sc.nextInt();
            }
            System.out.println(knapsack(W, V, B));
        }
    }
}
