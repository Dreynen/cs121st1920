import java.util.*;

public class pa8 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-->0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i] == b[j]) {
                        a[i] = -1;
                        b[j] = -1;
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] != -1) {
                    count++;
                }
            }

            for (int i = 0; i < m; i++) {
                if (b[i] != -1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}