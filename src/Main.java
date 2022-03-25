public class Main {
    public static void printTest(ChessBoard board,King king, ChessPiece piece, int line, int column){

        board.board[line][column] = piece;
        boolean isAttack = king.isUnderAttack(board, 3, 3);
        System.out.println(piece.getClass().getName()+" on line "+line+" and column "+column+".  Is attack: "+isAttack+". it`s "+(isAttack?"right":"wrong"));
        board.board[line][column] = null;
    }
    public static void main(String[] args) {
        int line,column, toLine, toColumn;
        boolean isAttack;
        ChessBoard board = new ChessBoard("White");

        Queen queen = new Queen("Black");
        Rook rook = new Rook("Black");
        Bishop bishop = new Bishop("Black");
        Pawn pawn = new Pawn("Black");
        Horse horse = new Horse("Black");

        King king = new King("White");
        board.board[3][3] = king;

        printTest(board,king,rook,0,3);
        printTest(board,king,queen,3,5);
        printTest(board,king,queen,5,3);
        printTest(board,king,rook,3,1);

        System.out.println("diagonals");
        //diagonals
        printTest(board,king,queen,1,5);
        printTest(board,king,bishop,5,5);
        printTest(board,king,queen,5,1);
        printTest(board,king,bishop,1,1);

        printTest(board,king,pawn,2,2);
        printTest(board,king,pawn,2,4);
        printTest(board,king,pawn,4,2);
        printTest(board,king,pawn,4,4);

        //horse
        System.out.println("horse");
        printTest(board,king,horse,5,4);
        printTest(board,king,horse,4,5);
        printTest(board,king,horse,2,5);
        printTest(board,king,horse,1,4);
        printTest(board,king,horse,1,2);
        printTest(board,king,horse,2,1);
        printTest(board,king,horse,4,1);
        printTest(board,king,horse,5,2);
    }
}
