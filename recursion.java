import java.util.*;

class ArraySum {
    public static int sum(int i, int[] a) {
        if (i == a.length) return 0;
        return a[i] + sum(++i, a);
    }
}

class Tribonacci {
    public static int trib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return trib(n-1) + trib(n-2) + trib(n-3);
    }
}

class DoubleFx {
    public static int H(int a, int b) {
        return F(a, b) + G(a, b);
    }

    private static int F(int a, int b) {
        if (a <= 0 || b < 0 || b > a) {
            return 0;
        }

        if (a == 1 && (b == 0 || b == 1)) {
            return 1;
        }

        return F(a - 1, b) + G(a - 1, b + 1);
    }

    private static int G(int a, int b) {
        if ((a <= 0 || b < 0 || b > a)
        || (a == 1 && b == 0)) {
            return 0;
        }

        if (a ==1 && b == 1) {
            return 1;
        }

        return F(a - 1, b - 1) + G(a - 1, b - 1);
    }
}

class Reverse {
    public static String reverse(String s) {
        if (s.length() == 1) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}

class GCF {
    public static int gcf(int x, int y) {
        if (y == 0) return x;
        return gcf(y, x % y);
    }
}

class FlashDrive {
    private static int max(int a, int b) { return a > b ? a : b; }

    public static int flashDrive(int N, int i, int[] tracks) {
        if (N == 0 || i == tracks.length) {
            return 0;
        }

        if (tracks[i] > N) {
            return flashDrive(N, i + 1, tracks);
        }

        return max(tracks[i] + flashDrive(N - tracks[i], i + 1, tracks), flashDrive(N, i + 1, tracks));
    }
}

class Engg {
    private static boolean first = true;

	public static boolean engg(String s) {
        if (s.equals("GG") && !first) {
        	first = true;
        	return true;
        }

        if (s.length() <= 2
        || (first && s.charAt(0) != 'E')
        || (s.charAt(0) == 'E' && s.charAt(1) != 'N')
        || (s.charAt(1) == 'E' && s.charAt(0) != 'N')) {
        	first = true;
            return false;
        }

        if (first) first = false;

        return engg(s.substring(1));
    }

	/*
     A function that does the exact same as
     Engg.engg(S), but in python and nicer.

        def engg(S, first = True):

            # Base case
            if S == "GG" and not first:
            	return True

            if (len(S) <= 2
            or (first and S[0] is not 'E')
            or (S[0] is 'E' and S[1] is not 'N')
            or (S[1] is 'E' and S[0] is not 'N')):
                return False

            return engg(S[1:], False)
    */
}

class Reachable {
    public static boolean reachable(int sx, int sy, int dx, int dy) {
        if (sx > dx || sy > dy) return false;
        if (sx == dx && sy == dy) return true;

        return reachable(sx, sx + sy, dx, dy) || reachable(sx + sy, sy, dx, dy);
    }
}

class recursion {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Engg.engg(sc.next()));
    }
}