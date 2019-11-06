import java.util.*;

public class lab8c {
    public static int sumOf(int[][] board, int[] coord) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += board[i][coord[i]];
        }
        return sum;
    }

    public static int nqueens(int[][] board, int[] coord, int row) {
        if (row == 8) {
            return sumOf(board, coord);
        }

        int score = 0;

        for (int col = 0; col < 8; col++) {
            boolean isPossible = true;
            for (int i = 0; i < row; i++) {
                if (coord[i] == col || Math.abs(coord[i] - col) == Math.abs(i - row)) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                coord[row] = col;
                score = Math.max(score, nqueens(board, coord, row + 1));
            }
        }
        return score;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int[][] board = new int[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int[] coord = new int[8];

            System.out.println(nqueens(board, coord, 0));
        }
    }
}