import java.util.Scanner;

public class pa1a {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String M = scanner.next();

            // init mutable string
            StringBuilder romanNum = new StringBuilder();

            for (int j = 0, len = M.length(); j < len; j++) {
                // subtract ascii '0' from char to get actual value
                int currentNum = M.charAt(j) - '0';

                // count by difference of full length and current index
                switch (len - j) {
                    case 4:
                        for (int k = 0; k < currentNum; k++) {
                            romanNum.append("M");
                        }
                        break;
                    case 3:
                        if (currentNum == 9) {
                            romanNum.append("CM");
                        } else if (currentNum >= 5) {
                            romanNum.append("D");
                            for (int k = 5; k < currentNum; k++) {
                                romanNum.append("C");
                            }
                        } else if (currentNum == 4) {
                            romanNum.append("CD");
                        } else {
                            for (int k = 0; k < currentNum; k++) {
                                romanNum.append("C");
                            }
                        }
                        break;
                    case 2:
                        if (currentNum == 9) {
                            romanNum.append("XC");
                        } else if (currentNum >= 5) {
                            romanNum.append("L");
                            for (int k = 5; k < currentNum; k++) {
                                romanNum.append("X");
                            }
                        } else if (currentNum == 4) {
                            romanNum.append("XL");
                        } else {
                            for (int k = 0; k < currentNum; k++) {
                                romanNum.append("X");
                            }
                        }
                        break;
                    case 1:
                        if (currentNum == 9) {
                            romanNum.append("IX");
                        } else if (currentNum >= 5) {
                            romanNum.append("V");
                            for (int k = 5; k < currentNum; k++) {
                                romanNum.append("I");
                            }
                        } else if (currentNum == 4) {
                            romanNum.append("IV");
                        } else {
                            for (int k = 0; k < currentNum; k++) {
                                romanNum.append("I");
                            }
                        }
                        break;
                }
            }
            System.out.println(romanNum);
        }
    }
}