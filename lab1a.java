import java.util.Scanner;

public class lab1a {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int S = scanner.nextInt();

            while (S > 0) {
                System.out.println(S);
                if (S % 2 == 1 && S != 1) {
                    S = 3 * S + 1;
                }
                else {
                    S/=2;
                }
            }
        }
    }
}