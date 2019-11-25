import java.util.*;

public class pa14 {
    public static String[] getOptions(int N, Scanner sc) {
        String[] options = new String[N];
        while (N-->0) {
            options[N] = sc.nextLine();
        }

        return options;
    }

    public static boolean mayPizzaBa(String[] options, String choices, int count) {
        if (options.length == 1 || count == options.length) {
            return true;
        }

        for (int i = 0; i < options[count].length(); i+=2) {
            String next = options[count].substring(i, i + 2);
            String other = (next.charAt(0) == '+' ? "-" : "+") + next.charAt(1);
            if (choices.contains(other)) {
                continue;
            }
            if (mayPizzaBa(options, choices + next, count + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-->0) {
            int N = Integer.parseInt(sc.nextLine());
            String[] options = getOptions(N, sc);

            System.out.println(mayPizzaBa(options, "", 0) ? "YES" : "Pancit canton na lang");
        }
    }
}