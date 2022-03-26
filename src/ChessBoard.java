public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {

                if (board[startLine][startColumn].getSymbol().equals("K") ||  // check position for castling
                        board[startLine][startColumn].getSymbol().equals("R") ||
                        board[startLine][startColumn].getSymbol().equals("P")) {
                    board[startLine][startColumn].check = false;
                }

                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    private boolean doCastling(int line, int rookColumn, int kingColumn) {
        String color = nowPlayer;
        int newKingColumn, newRookColumn;
        if (rookColumn == 7) {
            newRookColumn = 5;
            newKingColumn = 6;
        } else {
            newRookColumn = 3;
            newKingColumn = 2;
        }

        if (board[line][rookColumn] == null || board[line][kingColumn] == null) return false;
        int maxColumn = Math.max(rookColumn, kingColumn);
        int minColumn = Math.min(rookColumn, kingColumn);
        for (int i = minColumn + 1; i < maxColumn; i++) {
            if (board[line][i] != null) return false;
        }
        if (!board[line][rookColumn].getColor().equals(board[line][kingColumn].getColor())) return false;
        if (!board[line][rookColumn].getSymbol().equals("R")) return false;
        if (!board[line][kingColumn].getSymbol().equals("K")) return false;
        if (!(board[line][rookColumn].check && board[line][kingColumn].check)) return false;
        if (new King(color).isUnderAttack(this, line, newKingColumn)) return false;

        board[line][kingColumn] = null;
        board[line][newKingColumn] = new King(color);   // move King
        board[line][newKingColumn].check = false;
        board[line][rookColumn] = null;
        board[line][newRookColumn] = new Rook(color);   // move Rook
        board[line][newRookColumn].check = false;
        nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";  // next turn
        return true;
    }

    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            return doCastling(0, 0, 4);
        }
        return doCastling(7, 0, 4);
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            return doCastling(0, 7, 4);
        } else {
            return doCastling(7, 7, 4);
        }
    }
}
