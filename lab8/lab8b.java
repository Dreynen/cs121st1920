import java.util.*;

public class lab8b {
	private static boolean canSum(int S, int[] A) {
	    if (S < 0) {
	        return false;
	    }

		if (S == 0) {
			return true;
		}

        for (int x : A) {
            if (canSum(S - x, A)) { return true; }
        }

        return false;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while (T-->0) {
			String[] s = sc.nextLine().split(" ");
			int S = Integer.parseInt(s[0]);
			int[] A = new int[s.length - 1];
			for (int i = 1; i < A.length + 1; i++) {
			    A[i - 1] = Integer.parseInt(s[i]);
			}
			boolean summable = canSum(S, A);

			System.out.println(summable ? "YES" : "NO");
		}
	}
}