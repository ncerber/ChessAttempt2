public class Main {
    public static void main(String[] args) {
        int line, column, toLine, toColumn;
        boolean isAttack;
        ChessBoard board = new ChessBoard("White");
        Rook rook = new Rook("White");
        King king = new King("White");
        board.board[0][4] = king;
        board.board[0][7] = rook;
//        board.printBoard();
        System.out.println("White castling:" + board.castling7());
//        board.printBoard();

        Rook rook1 = new Rook("Black");
        King king1 = new King("Black");
        board.board[7][4] = king1;
        board.board[7][7] = rook1;
//        board.printBoard();
        System.out.println("Black castling:" + board.castling7());
        board.printBoard();
    }
}
