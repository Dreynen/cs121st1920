import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);
    public static void main(String arg[]) {

        Board board = new Board(getPieces());
        boolean currentTurn = "W".equals(input.nextLine());

        while (input.hasNext()) {
            if (board.checkWinCondition(currentTurn)) {
                break;
            }

            String[] command = input.nextLine().split(" ");

            if ("display".equals(command[0])) {
                System.out.println(board.toString(("W".equals(command[1]))));
                continue;
            }

            if (isValid(command)) {
                boolean isValidMove = board.move(
                    currentTurn,
                    new Coord(getRow(command[0]), getRow(command[0])),
                    new Coord(getRow(command[1]), getCol(command[1]))
                );

                if (isValidMove) {
                    currentTurn = !currentTurn;
                }
            }
        }
        System.out.println(board);
    }

/*
    I/O
*/

    static boolean isValid(String[] input) {
        if (input.length == 2 && input[0].length() == 2 && input[1].length() == 2) {
            return true;
        }
        return false;
    }

    static Piece[] getPieces() {
        Piece[] pieces = new Piece[42];
        for (int i = 0; i < 42; i++) {
            String[] arr = input.nextLine().split(" ");
            String type = arr[0];
            int rank = getRank(type);
            boolean color = getColor(type);
            Coord pos = new Coord(getRow(arr[1]), getCol(arr[1]));

            pieces[i] = new Piece(type, rank, color, pos);
        }
        return pieces;
    }

    static int getRank(String s) {
        s = s.toUpperCase();
        int rank = 0;
        switch(s) {
            case "SP":
                rank = 14;
                break;
            case "5G":
                rank = 13;
                break;
            case "4G":
                rank = 12;
                break;
            case "3G":
                rank = 11;
                break;
            case "2G":
                rank = 10;
                break;
            case "1G":
                rank = 9;
                break;
            case "CL":
                rank = 8;
                break;
            case "LC":
                rank = 7;
                break;
            case "MJ":
                rank = 6;
                break;
            case "CP":
                rank = 5;
                break;
            case "1L":
                rank = 4;
                break;
            case "2L":
                rank = 3;
                break;
            case "SG":
                rank = 2;
                break;
            case "PV":
                rank = 1;
                break;
            case "FL":
                rank = 0;
                break;
        }
        return rank;
    }

    static boolean getColor(String s) {
        return Character.isUpperCase(s.charAt(1));
    }

    static int getRow(String s) {
        char c = s.charAt(1);
        switch(c) {
            case '8':
                return 0;
            case '7':
                return 1;
            case '6':
                return 2;
            case '5':
                return 3;
            case '4':
                return 4;
            case '3':
                return 5;
            case '2':
                return 6;
            case '1':
                return 7;
            default:
                return -1;
        }
    }

    private static int getCol(String s) {
        char c = s.charAt(0);
        switch(c) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            default:
                return -1;
        }
    }
}