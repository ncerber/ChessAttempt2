public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    private boolean checkAsBishop(ChessBoard board, int line, int column, int toLine, int toColumn) {
        boolean isRight = column < toColumn, isTop = line < toLine;
        int vIterator = isTop ? 1 : -1, gIterator = isRight ? 1 : -1;
        int tLine = line, tColumn = column;
        for (int i = 0; i < 8; i++) {
            tLine += vIterator;
            tColumn += gIterator;
            boolean isNotEmpty = board.board[tLine][tColumn] != null;
            boolean isEnemy = isNotEmpty && !board.board[tLine][tColumn].getColor().equals(color);
            if (tLine == toLine && tColumn == toColumn) {
                if (isEnemy) return true;
                return !isNotEmpty;
            }
            if (tLine == toLine || tColumn == toColumn || isNotEmpty) return false;
        }

        return false;
    }

    private boolean checkAsRook(ChessBoard board, int line, int column, int toLine, int toColumn) {
        boolean isVertical = line != toLine, isHorizontal = column != toColumn;
        int vIterator = 0, hIterator = 0;

        if (isVertical) {
            if (line > toLine) {
                vIterator = -1;
            } else {
                vIterator = 1;
            }
        } else if (isHorizontal) {
            if (column > toColumn) {
                hIterator = -1;
            } else {
                hIterator = 1;
            }
        }

        int tLine = line;
        int tColumn = column;
        boolean isNullCell;
        for (int i = 0; i < 8; i++) {
            tLine += vIterator;
            tColumn += hIterator;
            if (tLine > 7 || tLine < 0 || tColumn > 7 || tColumn < 0) break;
            isNullCell = board.board[tLine][tColumn] == null;
            if (tLine == toLine && tColumn == toColumn) return isRightDestination(board, toLine, toColumn);
            if (!isNullCell) break;
        }
        return false;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isPositionCorrect(line, column, toLine, toColumn)) return false;

        if (line == toLine | column == toColumn) {
            return checkAsRook(chessBoard, line, column, toLine, toColumn);
        }
        return checkAsBishop(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
