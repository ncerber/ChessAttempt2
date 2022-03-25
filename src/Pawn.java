public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isPositionCorrect(line, column, toLine, toColumn)) return false;
        if (column != toColumn) return false;

        boolean isLineMove = line + 2 == toLine | line + 1 == toLine;
        isLineMove = isLineMove | line - 2 == toLine | line - 1 == toLine;
        if (color.equals("White") && line == 1 && isLineMove) return true;
        return color.equals("Black") && line == 6 && isLineMove;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
