public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isPositionCorrect(line, column, toLine, toColumn)) return false;

        boolean isRight = column < toColumn, isTop = line < toLine;
        int vIterator = isTop ? 1 : -1, gIterator = isRight ? 1 : -1;
        int tLine = line, tColumn = column;
        for (int i = 0; i < 8; i++) {
            tLine += vIterator;
            tColumn += gIterator;
            boolean isNotEmpty = chessBoard.board[tLine][tColumn] != null;
            boolean isEnemy = isNotEmpty && !chessBoard.board[tLine][tColumn].getColor().equals(color);
            if (tLine == toLine && tColumn == toColumn) {
                if (isEnemy) return true;
                return !isNotEmpty;
            }
            if (tLine == toLine || tColumn == toColumn || isNotEmpty) return false;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
