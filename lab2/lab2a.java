import java.util.Scanner;

public class lab2a {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            // assume amazing square
            boolean isAmazing = true;
            int L = scanner.nextInt();

            // array to store numbers
            int[] array = new int[L];

            // array to check numbers from 1 to n
            boolean[] checker = new boolean[L - 1];

            // get input
            for (int j = 0; j < L; j++) {
                array[j] = scanner.nextInt();
            }

            // get differences of each consecutive pair
            for (int j = 1; j < L; j++) {
                int diff = Math.abs(array[j] - array[j - 1]);

                // if any difference is outside of 1:n-1, not amazing
                if (diff >= array.length || diff == 0) {
                    isAmazing = false;
                    break;
                }

                checker[diff - 1] = true;
            }

            // iterate through boolean array if there is any value not found
            for (int j = 0; j < L - 1; j++) {
                if (checker[j] == false) {
                    isAmazing = false;
                    break;
                }
            }

            if (L == 1 || isAmazing) {
                System.out.println("Amazing!");
            }
            else {
                System.out.println("Not amazing.");
            }
        }
    }
}