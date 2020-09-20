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

    public int getR() {
        return this.position.getR();
    }

    public int getC() {
        return this.position.getC();
    }

    public Coord getPosition() {
        return this.position;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }

    public String toString() {
        return this.getType();
    }
}