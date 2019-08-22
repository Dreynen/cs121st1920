import java.util.Scanner;

public class lab2c {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            boolean isMagic = true;
            int S = scanner.nextInt();
            int [][] sqr = new int[S][S];
            for (int j = 0; j < S; j++) {
                for (int k = 0; k < S; k++) {
                    sqr[j][k] = scanner.nextInt();
                }
            }

            int checksum = 0;
            for (int j = 0; j < S; j++) {
                checksum += sqr[0][j];
            }

            int sum = 0;

            for (int j = 0; j < S; j++) {
                sum = 0;
                for (int k = 0; k < S; k++) {
                    sum += sqr[j][k];
                }

                if (sum != checksum) {
                    isMagic = false;
                }
            }

            for (int j = 0; j < S; j++) {
                sum = 0;
                for (int k = 0; k < S; k++) {
                    sum += sqr[k][j];
                }

                if (sum != checksum) {
                    isMagic = false;
                }
            }

            if (isMagic) {
                System.out.println("Magic square");
            }
            else {
                System.out.println("No magic");
            }
        }
    }
}