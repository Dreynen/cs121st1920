import java.util.*;

public class lab8a {
	private static void printAll(char[] str, int i) {
		if (str.length == i) {
		    System.out.println(str);
		    return;
		}

		char [] a = str.clone();

		if (a[i] == '!') {
			for (char c = 'a'; c != 'h' + 1; c++) {
				a[i] = c;
				printAll(a, i + 1);
			}
		} else if (a[i] == '@') {
			for (char c = '0'; c != '9' + 1; c++) {
				a[i] = c;
				printAll(a, i + 1);
			}
		} else {
		    printAll(a, i + 1);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while (T-->0) {
			char[] str = sc.next().toCharArray();
			printAll(str, 0);
		}
	}
}