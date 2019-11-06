import java.util.*;

public class lab6a {
    public static long boxFill(int N) {
        if (N == 1) {
            return 1;
        }

        if (N == 2) {
            return 5;
        }

        if (N == 3) {
            return 11;
        }


        return boxFill(N - 1) +  4 * boxFill(N - 2) + 2 * boxFill(N - 3);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int N = sc.nextInt();
            System.out.println(boxFill(N));
        }
    }
}