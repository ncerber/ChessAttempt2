public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 | toLine < 0) return false;
        if (toColumn > 7 | toColumn < 0) return false;
        if (line == toLine && column == toColumn) return false;

        boolean isColumnFlag = column - 2 == toColumn | column + 2 == toColumn;
        boolean isLineFlag = line + 1 == toLine | line - 1 == toLine;
        if (isLineFlag && isColumnFlag) return true;

        isColumnFlag = column - 1 == toColumn | column + 1 == toColumn;
        isLineFlag = line + 2 == toLine | line - 2 == toLine;
        return isLineFlag && isColumnFlag;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
