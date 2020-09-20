class Board {
    private Piece[][] board = new Piece[8][9];
    private Piece FL;
    private Piece fl;

    public Board(Piece[] pieces) {
        for (Piece p : pieces) {
            this.board[p.getR()][p.getC()] = p;

            if ("FL".equals(p.getType())) {
                this.FL = p;
            }

            if ("fl".equals(p.getType())) {
                this.fl = p;
            }
        }
    }

    public boolean move(boolean turn, Coord src, Coord dest) {
        Piece p = getPiece(src);

        if (p == null
        || src.getR() == -1 || src.getC() == -1
        || dest.getR() == -1 || dest.getC() == -1
        || Math.abs(src.getR() + src.getC() - dest.getR() - dest.getC()) != 1
        || p.getColor() != turn) {
            return false;
        }

        Piece q = getPiece(dest);

        String result = p.challenge(q);

        switch(result) {
            case "W":
                board[src.getR()][src.getC()] = null;
                board[dest.getR()][dest.getC()] = p;
                p.setPosition(dest);
                break;
            case "D":
                board[dest.getR()][dest.getC()] = null;
            case "L":
                board[src.getR()][src.getC()] = null;
                break;
            default:
                return false;
        }
        return true;
    }

    private Piece getPiece(Coord coord) {
        return board[coord.getR()][coord.getC()];
    }

    public boolean checkWinCondition(boolean turn) {
        if (FL != getPiece(FL.getPosition())
        || fl != getPiece(fl.getPosition())) {
            return true;
        }

        if (FL.getR() == 0 || fl.getR() == 7) {
            Piece flag = FL.getR() == 0 ? this.FL : this.fl;
            Piece right = null;
            Piece left = null;
            if (flag.getC() < 7 ) {
                right = getPiece(new Coord(flag.getR(), flag.getC() + 1));
            }
            if (flag.getC() > 0) {
                left = getPiece(new Coord(flag.getR(), flag.getC() - 1));
            }

            String result = "WN";

            if ((flag.getC() == 7 && left.getRank() != 0 && result.contains(flag.challenge(left)))
            || (flag.getC() == 0 && right.getRank() != 0 && result.contains(flag.challenge(right)))
            || (((right == null || right.getRank() != 0) && result.contains(flag.challenge(right)))
                && ((left == null || left.getRank() != 0) && result.contains(flag.challenge(left))))) {
                    return true;
            }
        }

        flag = turn ? this.FL : this.fl;
        if ((turn && flag.getR() == 0)
        || (!turn && flag.getR() == 7)) {
            return true;
        }

        return false;
    }

    public String toString() {
        String s = "";
        for (Piece[] a : this.board) {
            for (Piece p : a) {
                s+=((p == null) ? ".." : p.getType()) + " ";
            }
            s+="\n";
        }
        return s;
    }

    public String toString(boolean turn) {
        String s = "";
        for (Piece[] a : this.board) {
            for (Piece p : a) {
                s+=((p == null) ? ".." : p.getColor() == turn ? p.getType() : "##") + " ";
            }
            s+="\n";
        }
        return s;
    }
}