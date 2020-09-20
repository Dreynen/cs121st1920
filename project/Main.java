import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]) {

        Game game = new Game(new Board(getPieces()), getTurn(input.nextLine()));

        while(input.hasNextLine()) {
            if (game.checkWinCondition()) {
                break;
            }

            String[] command = input.nextLine().split(" ");

            if ("display".equals(command[0])) {
                game.display(getTurn(command[1]));
                continue;
            }

            if (isValidInput(command)) {
                boolean isValidMove = game.move(
                    new Coord(getRow(command[0]), getCol(command[0])),
                    new Coord(getRow(command[1]), getCol(command[1]))
                );

                if (isValidMove) {
                    game.changeTurn();
                }
            }
        }
        game.display();
    }

/*
    I/O
*/

    static boolean isValidInput(String [] a) {
        if (a.length == 2 && a[0].length() == 2 && a[1].length() == 2) {
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

    static boolean getTurn(String s) {
        return "W".equals(s);
    }

    static int getRank(String s) {
        s = s.toUpperCase();
        switch(s) {
            case "SP": return 14;
            case "5G": return 13;
            case "4G": return 12;
            case "3G": return 11;
            case "2G": return 10;
            case "1G": return 9;
            case "CL": return 8;
            case "LC": return 7;
            case "MJ": return 6;
            case "CP": return 5;
            case "1L": return 4;
            case "2L": return 3;
            case "SG": return 2;
            case "PV": return 1;
            default: return 0;
        }
    }

    static boolean getColor(String s) {
        return Character.isUpperCase(s.charAt(1));
    }

    static int getRow(String s) {
        char c = s.charAt(1);
        switch(c) {
            case '8': return 0;
            case '7': return 1;
            case '6': return 2;
            case '5': return 3;
            case '1': return 7;
            case '4': return 4;
            case '3': return 5;
            case '2': return 6;
            default: return -1;
        }
    }

    private static int getCol(String s) {
        char c = s.charAt(0);
        switch(c) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            case 'i': return 8;
            default: return -1;
        }
    }
}

class Game {
    private Board board;
    private boolean currentTurn;

    public Game(Board board, boolean startingTurn) {
        this.board = board;
        this.currentTurn = startingTurn;
    }

    public boolean checkWinCondition() {
        if (!board.existsFlags()
        || board.backrankFlags(currentTurn)) {
            return true;
        }
        return false;
    }

    public boolean move(Coord src, Coord dest) {
        Piece p = board.getPiece(src);

        if (p == null
        || src.getR() == -1 || src.getC() == -1
        || dest.getR() == -1 || dest.getC() == -1
        || Math.abs(src.getR() + src.getC() - dest.getR() - dest.getC()) != 1
        || p.getColor() != currentTurn) {
            return false;
        }

        Piece q = board.getPiece(dest);

        String result = p.challenge(q);

        switch (result) {
            case "W":
                board.setPiece(src, null);
                board.setPiece(dest, p);
                p.setPosition(dest);
                break;
            case "D":
                board.setPiece(dest, null);
            case "L":
                board.setPiece(src, null);
                break;
            default:
                return false;
        }
        return true;
    }

    public void changeTurn() {
        this.currentTurn = !this.currentTurn;
    }

    public void display(boolean turn) {
        System.out.println(board.toString(turn));
    }

    public void display() {
        System.out.println(board);
    }
}

class Board {
    private Piece[][] board = new Piece[8][9];
    private Piece FL;
    private Piece fl;

    public Board(Piece[] pieces) {
        for (Piece p : pieces) {
            this.board[p.getPos().getR()][p.getPos().getC()] = p;

            if ("FL".equals(p.getType())) {
                this.FL = p;
            }

            if ("fl".equals(p.getType())) {
                this.fl = p;
            }
        }
    }

    public Piece getPiece(Coord c) {
        return board[c.getR()][c.getC()];
    }

    public void setPiece(Coord c, Piece p) {
        board[c.getR()][c.getC()] = p;
    }

    public boolean existsFlags() {
        if (FL == getPiece(FL.getPos())
        && fl == getPiece(fl.getPos())) {
            return true;
        }
        return false;
    }

    public boolean backrankFlags(boolean currentTurn) {
        Piece flag = !currentTurn ? this.FL : this.fl;
        if (flag.getPos().getR() == (flag.getColor() ? 0 : 7)) {
            Piece right = null;
            Piece left = null;
            if (flag.getPos().getC() < 7 ) {
                right = getPiece(new Coord(flag.getPos().getR(), flag.getPos().getC() + 1));
            }
            if (flag.getPos().getC() > 0) {
                left = getPiece(new Coord(flag.getPos().getR(), flag.getPos().getC() - 1));
            }

            String result = "WN";

            boolean resultR = (right == null || right.getRank() != 0) && result.contains(flag.challenge(right));
            boolean resultL = (left == null || left.getRank() != 0) && result.contains(flag.challenge(left));

            if ((flag.getPos().getC() == 0 && resultR)
            || (flag.getPos().getC() == 7 && resultL)
            || (resultR && resultL)) {
                return true;
            }
        }

        flag = currentTurn ? this.FL : this.fl;
        if (flag.getPos().getR() == (flag.getColor() ? 0 : 7)) {
            return true;
        }

        return false;
    }

    public String toString() {
        String s = "";
        for (Piece[] a : this.board) {
            for (Piece p : a) {
                s+=(p == null ? ".." : p) + " ";
            }
            s+="\n";
        }
        return s;
    }

    public String toString(boolean turn) {
        String s = "";
        for (Piece[] a : this.board) {
            for (Piece p : a) {
                s+=(p == null ? ".." : p.getColor() == turn ? p : "##") + " ";
            }
            s+="\n";
        }
        return s;
    }
}

class Piece {
    private static final int SP = 14;
    private static final int PV = 1;
    private static final int FL = 0;

    private final String type;
    private final boolean color;
    private final int rank;
    private Coord position;

    public Piece(String type, int rank, boolean color, Coord position) {
        this.type = type;
        this.rank = rank;
        this.color = color;
        this.position = position;
    }

    public String challenge(Piece q) {
        String result;

        if (q == null) {
            result = "W";
        } else if (this.color == q.getColor()) {
            result = "N";
        } else if (q.getRank() == FL
        || (this.rank == PV && q.getRank() == SP)
        || this.rank > q.getRank()) {
            result = "W";
        } else if ((this.rank == SP && q.getRank() == PV)
        || this.rank < q.getRank()) {
            result = "L";
        } else {
            result = "D";
        }
        return result;
    }

    public String getType() {
        return this.type;
    }

    public int getRank() {
        return this.rank;
    }

    public boolean getColor() {
        return this.color;
    }

    public Coord getPos() {
        return this.position;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }

    public String toString() {
        return this.type;
    }
}

class Coord {
    private int row;
    private int col;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getR() {
        return this.row;
    }

    public int getC() {
        return this.col;
    }
}