import java.util.*;

public class pa11 {
    public static void burger(int N, int current) {
        if (current > N) { return; }

        int width = 2 * current + 3, padding = N - current + 1;
        String s = "";
        for (int i = 0; i < padding; i++) {
            s+=" ";
        }
        for (int i = 0; i < width - 2; i++) {
            s+="_";
        }
        System.out.println(s);

        s = "";
        for (int i = 0; i < padding - 1; i++) {
            s+=" ";
        }
        s+="/";
        for (int i = 0; i < width - 2; i++) {
            s+=" ";
        }
        System.out.println(s + "\\");

        if (current % 3 == 1) {
            s = "";
            for (int i = 0; i < padding - 1; i++) {
                s+=" ";
            }
            for (int i = 0; i < width; i++) {
                s+="~";
            }
            System.out.println(s);
        }

        s = "";
        for (int i = 0; i < padding - 1; i++) {
            s+=" ";
        }

        for (int i = 0; i < width; i++) {
            s+="=";
        }

        for (int i = 0; i < (current % 2 == 0 ? current / 2 : current / 2 + 1); i++) {
            System.out.println(s);
        }

        burger(N, current + 1);

        for (int i = 0; i < current / 2; i++) {
            System.out.println(s);
        }

        if (current % 3 == 2) {
            s = "";
            for (int i = 0; i < padding - 1; i++) {
                s+=" ";
            }
            for (int i = 0; i < width; i++) {
                s+="o";
            }
            System.out.println(s);
        }

        s = "";
        for (int i = 0; i < padding - 1; i++) {
            s+=" ";
        }
        s+="\\";
        for (int i = 0; i < width - 2; i++) {
            s+="_";
        }
        s+="/";
        System.out.println(s);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            burger(sc.nextInt(), 1);
        }
    }
}