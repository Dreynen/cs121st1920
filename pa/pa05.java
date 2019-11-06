import java.util.Scanner;

public class pa5 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-->0) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            int[][] matrix = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = i%2 == 0 ? 0 : 1 - y, s = i%2 == 0 ? y : 1; j < s; j++) {
                    System.out.print(matrix[i%2 == 0 ? j : -j][i] + " ");
                }
                System.out.println();
            }
        }
    }
}