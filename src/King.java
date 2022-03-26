public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isPositionCorrect(line, column, toLine, toColumn)) return false;

        boolean isNotEmpty = chessBoard.board[toLine][toColumn] != null;
        boolean isNotEnemy = isNotEmpty && chessBoard.board[toLine][toColumn].getColor().equals(color);
        return Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1 && !isNotEnemy;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        CheckAttack checkAttack = new CheckAttack(board, line, column);
        return checkAttack.check();
    }

    class CheckAttack {
        private ChessBoard board;
        private int line;
        private int column;

        public CheckAttack(ChessBoard board, int line, int column) {
            this.board = board;
            this.line = line;
            this.column = column;
        }

        private boolean checkLineCells(int lineIterator, int columnIterator, String[] searchPieces) {
            int tLine = line;
            int tColumn = column;
            ChessPiece piece;
            for (int i = 0; i < 8; i++) {
                tLine += lineIterator;
                tColumn += columnIterator;
                if (tLine < 0 | tLine > 7 | tColumn < 0 | tColumn > 7) break;
                piece = board.board[tLine][tColumn];
                if (piece == null) continue;
                if (piece.getColor().equals(color)) break;
                for (String pieceSymbol : searchPieces) {
                    if (piece.getSymbol().equals(pieceSymbol)) return true;
                }
                break;
            }
            return false;
        }

        private boolean checkHorseAttack() {
            ChessPiece tPiece;
            boolean inBoard;
            int tLine, tColumn;

            tLine = line - 1;
            tColumn = column - 2;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }

            tLine = line - 2;
            tColumn = column - 1;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }

            tLine = line - 2;
            tColumn = column + 1;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }

            tLine = line - 1;
            tColumn = column + 2;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }


            tLine = line + 1;
            tColumn = column + 2;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }

            tLine = line + 2;
            tColumn = column + 1;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }

            tLine = line + 2;
            tColumn = column - 1;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }


            tLine = line + 1;
            tColumn = column - 2;
            inBoard = tLine > 0 && tLine < 8 && tColumn > 0 && tColumn < 8;
            if (inBoard) {
                tPiece = board.board[tLine][tColumn];
                if (inBoard && tPiece != null && tPiece.getSymbol().equals("H") && !tPiece.getColor().equals(color))
                    return true;
            }
            return false;
        }

        public boolean check() {
            //horisontal and vertical

            //left
            boolean res = checkLineCells(-1, 0, new String[]{"Q", "R"});
            if (res) return true;
            //right
            res = checkLineCells(1, 0, new String[]{"Q", "R"});
            if (res) return true;
            //top
            res = checkLineCells(0, 1, new String[]{"Q", "R"});
            if (res) return true;
            //bottom
            res = checkLineCells(0, -1, new String[]{"Q", "R"});
            if (res) return true;
            //left-top diagonal
            res = checkLineCells(1, -1, new String[]{"Q", "B", "P"});
            if (res) return true;
            //left-Bottom diagonal
            res = checkLineCells(-1, -1, new String[]{"Q", "B", "P"});
            if (res) return true;
            //right-top diagonal
            res = checkLineCells(1, 1, new String[]{"Q", "B", "P"});
            if (res) return true;
            //right-bottom diagonal
            res = checkLineCells(-1, 1, new String[]{"Q", "B", "P"});
            if (res) return true;
            //Horses
            return checkHorseAttack();
        }
    }
}


