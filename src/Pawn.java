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
        if (Math.abs(column - toColumn) > 1) return false;

        boolean isLineMove1, isLineMove2, isDiagonalMove;
        int transitLine;

        if (color.equals("White")) {
            isLineMove1 = line + 1 == toLine && Math.abs(column - toColumn) == 0;
            isLineMove2 = line + 2 == toLine && check && Math.abs(column - toColumn) == 0;
            transitLine = line + 1;
        } else {
            isLineMove1 = line - 1 == toLine && Math.abs(column - toColumn) == 0;
            isLineMove2 = line - 2 == toLine && check && Math.abs(column - toColumn) == 0;
            transitLine = line - 1;
        }
        isDiagonalMove = Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1;

        if (isLineMove1) {
            return chessBoard.board[toLine][toColumn] == null;
        } else if (isLineMove2) {
            return chessBoard.board[toLine][toColumn] == null && chessBoard.board[transitLine][toColumn] == null;
        }else if(isDiagonalMove){
            return isRightDestination(chessBoard,toLine,toColumn);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
