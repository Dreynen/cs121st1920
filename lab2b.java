import java.util.Scanner;

public class lab2b {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            boolean isSub = true;
            String sub = scanner.nextLine();
            String str = scanner.nextLine();
            boolean[] checker = new boolean[sub.length()];
            int offset = 0;
            for (int j = 0, len = str.length(); j < len; j++) {
                if (checker[sub.length() - 1] == true) {
                    break;
                }

                if (sub.charAt(j - offset) == str.charAt(j)) {
                    checker[j - offset] = true;
                }
                else {
                    offset++;
                }
            }

            for (int j = 0, len = checker.length; j < len; j++) {
                if (checker[j] == false) {
                    isSub = false;
                    break;
                }
            }

            if (isSub) {
                System.out.println("Subsequence");
            }
            else {
                System.out.println("Not a subsequence");
            }
        }
    }
}