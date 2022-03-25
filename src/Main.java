public class Main {
    public static void main(String[] args) {
        int line,column, toLine, toColumn;
        ChessBoard board = new ChessBoard("White");
        Pawn pawn = new Pawn("White");

        line=1; column=0; toLine=2; toColumn=1;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+pawn.canMoveToPosition(board,line,column,toLine,toColumn));
    }
}
