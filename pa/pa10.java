import java.util.*;

public class pa10 {
    public static int travMaze(char[][] maze, int row, int col) {
        if (row > 5 || col > 5 || maze[row][col] == '#') {
            return 0;
        }

        if (row == 5 && col == 5) {
            return 1;
        }

        return travMaze(maze, row + 1, col) + travMaze(maze, row, col + 1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            char[][] maze = new char[6][6];
            for (int i = 0; i < 6; i++) {
                maze[i] = sc.next().toCharArray();
            }

            System.out.println(travMaze(maze, 0, 0));
        }
    }
}