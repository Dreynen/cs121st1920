import java.util.*;

public class lab4a {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String L = sc.nextLine();
            boolean isBal = true;
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < L.length(); i++) {
                char c = L.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    char p;
                    if (stack.empty()) {
                        isBal = false;
                        break;
                    } else {
                        p = stack.peek();
                    }

                    if ((p == '(' && c == ')')
                        || (p == '[' && c == ']')
                        || (p == '{' && c == '}')) {
                        stack.pop();
                    } else {
                        isBal = false;
                        break;
                    }
                }
            }

            if (!stack.empty()) {
                isBal = false;
            }

            if (isBal) {
                System.out.println("Balanced");
            } else {
                System.out.println("Not balanced");
            }
        }
    }
}