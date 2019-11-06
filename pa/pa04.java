import java.util.Scanner;

public class pa4 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-->0) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            int[][] matrix = new int[y][x];
            for (int i = 0; i < x; i++) {
                for (int j = 0 ; j < y; j++) {
                    matrix[j][i] = scanner.nextInt();
                }
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}