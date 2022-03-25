public class Main {
    public static void main(String[] args) {
        int line,column, toLine, toColumn;
        ChessBoard board = new ChessBoard("White");
        Rook rook = new Rook("White");

        line=3; column=3; toLine=3; toColumn=5;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+rook.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=3; toColumn=0;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+rook.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=5; toColumn=3;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+rook.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=0; toColumn=3;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+rook.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=4; toColumn=1;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+rook.canMoveToPosition(board,line,column,toLine,toColumn));
    }
}
