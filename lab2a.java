import java.util.Scanner;

public class lab2a {
    static final int MaxRow = 8, MaxCol = 8;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int R = scanner.nextInt(), C = scanner.nextInt(), legalMoves = 0;;
            if (R + 2 <= 8 && C + 1 <= 8) {
                legalMoves++;
            }
            if (R + 2 <= 8 && C - 1 >= 1) {
                legalMoves++;
            }
            if (R + 1 <= 8 && C + 2 <= 8) {
                legalMoves++;
            }
            if (R + 1 <= 8 && C - 2 >= 1) {
                legalMoves++;
            }
            if (R - 1 >= 1 && C - 2 >= 1) {
                legalMoves++;
            }
            if (R - 1 >= 1 && C + 2 <= 8) {
                legalMoves++;
            }
            if (R - 2 >= 1 && C - 1 >= 1) {
                legalMoves++;
            }
            if (R - 2 >= 1 && C + 1 <= 8) {
                legalMoves++;
            }

            System.out.println(legalMoves);
        }
    }
}