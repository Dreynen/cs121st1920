import java.util.Scanner;

public class pa6 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-->0) {
            int S = scanner.nextInt();
            int[][] matrix = new int[S][S];
            for (int i = 0; i < S; i++) {
                for (int j = 0; j < S; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0, s = 2 * S - 1; i < s; i++) {
                for (int j = 0; j < S; j++) {
                    for (int k = 0; k < S; k++) {
                        if (i == j + k) {
                            System.out.print(matrix[k][j] + " ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}