import java.util.*;

public class pa13 {
    private static char[][] getGrid(Scanner sc) {
        char[][] grid = new char[4][4];
        for (int i = 0; i < 4; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        return grid;
    }

    private static boolean find(String query, char[][] grid, String word, int row, int col, int count) {
        if (word.length() >= query.length()
        || row < 0 || row > 3
        || col < 0 || col > 3
        || grid[row][col] == '0') {
            return false;
        }

        char c = grid[row][col];

        if (c != query.charAt(count)) {
            return false;
        }

        if (query.equals(word + c)) {
            return true;
        }

        boolean status = false;
        grid[row][col] = '0';

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) { continue; }

                if (find(query, grid, word + c, row + i, col + j, count + 1)) {
                    status = true;
                    break;
                }
            }
            if (status == true) { break; }
        }

        grid[row][col] = c;

        return status;
    }

    private static void findWord(String query, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (find(query, grid, "", i, j, 0)) {
                    System.out.printf("Row %d, Column %d\n", i + 1, j + 1);
                    return;
                }
            }
        }
        System.out.println("No");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-->0) {
            char[][] grid = getGrid(sc);
            int Q = Integer.parseInt(sc.nextLine());
            while (Q-->0) {
                String query = sc.nextLine();
                findWord(query, grid);
            }
        }
    }
}