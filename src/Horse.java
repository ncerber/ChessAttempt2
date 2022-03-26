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
        if (!isPositionCorrect(line, column, toLine, toColumn)) return false;

        boolean res;

        boolean isColumnFlag = column - 2 == toColumn | column + 2 == toColumn;
        boolean isLineFlag = line + 1 == toLine | line - 1 == toLine;
        res = isLineFlag && isColumnFlag;

        isColumnFlag = column - 1 == toColumn | column + 1 == toColumn;
        isLineFlag = line + 2 == toLine | line - 2 == toLine;
        res = res || (isLineFlag && isColumnFlag);
        if (res) {
            boolean isNotEmpty = chessBoard.board[toLine][toColumn] != null;
            boolean isNotEnemy = isNotEmpty && chessBoard.board[toLine][toColumn].getColor().equals(color);
            return !isNotEnemy;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
