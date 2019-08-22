import java.util.Scanner;

class hello {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, N = scanner.nextInt();
        while (N-- > 0) {
            sum += scanner.nextInt();
        }

        System.out.println(sum);
    }
}