import java.util.*;

public class lab9c {
    static int[][] memo = new int[101][101];
    static final int MAX_VAL = 200000;

    private static int shortestPath(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        if (row == 0) {
            return grid[row][col] + shortestPath(grid, row, col - 1);
        }
        if (col == 0) {
            return grid[row][col] + shortestPath(grid, row - 1, col);
        }
        if (memo[row][col] != MAX_VAL) {
            return memo[row][col];
        }
        memo[row][col] = Math.min(
            shortestPath(grid, row - 1, col - 1),
            Math.min(
                shortestPath(grid, row - 1, col),
                shortestPath(grid, row, col - 1)
            )
        ) + grid[row][col];
        return memo[row][col];
    }
    private static void init(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                memo[i][j] = MAX_VAL;
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int N = sc.nextInt(), M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            init(N, M);
            System.out.println(shortestPath(grid, N - 1, M - 1));
        }
    }
}