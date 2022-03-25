public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isPositionCorrect(line, column, toLine, toColumn)) return false;

        if (line != toLine && column != toColumn) return false;

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
        for (int i = 0; i < 8; i++) {
            tLine += vIterator;
            tColumn += hIterator;
            if(tLine == toLine && tColumn == toColumn) return true;
            if(tLine>7 | tLine<0) break;
            if(tColumn>7 | tColumn<0) break;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

