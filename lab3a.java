import java.util.Scanner;

public class lab3a {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++)
        {
            int x = scanner.nextInt(), y = scanner.nextInt(), numCarry = 0, carry = 0;
            while (x > 0 || y > 0) {
                int sum = x % 10 + y % 10 + carry;

                if (sum >= 10) {
                    numCarry++;
                    carry = sum / 10;
                }
                else
                {
                    carry = 0;
                }

                x/=10;
                y/=10;
            }
            System.out.println(numCarry);
        }
    }
}