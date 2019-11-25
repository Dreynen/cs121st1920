import java.util.*;

public class lab8a {
	private static void printAll(String S, String output, int i) {
		if (S.length() == i) {
			System.out.println(output);
			return;
		}

		if (S.charAt(i) == '!') {
			for (char c = 'a'; c <= 'h'; c++) {
				printAll(S, output + c, i + 1);
			}
		}
		if (S.charAt(i) == '@') {
			for (char c = '0'; c <= '9'; c++) {
				printAll(S, output + c, i + 1);
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while (T-->0) {
			String str = sc.nextLine();
			printAll(str, "", 0);
		}
	}
}