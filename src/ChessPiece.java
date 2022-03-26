public abstract class ChessPiece {
    String color;
    boolean check;

    public ChessPiece(String color) {
        this.color = color;
        this.check = true;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean isPositionCorrect(int line, int column, int toLine, int toColumn) {
        if (toLine > 7 | toLine < 0) return false;
        if (toColumn > 7 | toColumn < 0) return false;
        return line != toLine || column != toColumn;
    }

    public boolean isRightDestination(ChessBoard board, int line, int column) {
        if (board.board[line][column] == null) return true;
        return !board.board[line][column].getColor().equals(color);
    }
}
