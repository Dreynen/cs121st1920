import java.util.Scanner;

public class pa3 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-->0) {
        	String str = scanner.next(), jumble = scanner.next();
        	int uniqueLetters = 0, differ = 0, swaps = 0, len = str.length();
        	boolean[] alphabet = new boolean[26];
        	for (int i = 0; i < len; i++) {
        		alphabet[str.charAt(i) - 'a'] = true;
        	}

        	for (int i = 0; i < 26; i++) {
        		if (alphabet[i] == true) {
        			uniqueLetters++;
        		}
        	}

        	for (int i = 0; i < len; i++) {
        		if (str.charAt(i) != jumble.charAt(i)) {
        			differ++;
        		}
        	}

        	for (int i = 1; i < len; i++) {
        		if (str.charAt(i) == jumble.charAt(i - 1) && str.charAt(i - 1) == jumble.charAt(i)) {
        			swaps++;
        		}
        	}
        	System.out.printf("%d %d %d\n", uniqueLetters, differ, swaps);
        }
    }
}