public class Main {
    public static void main(String[] args) {
        int line,column, toLine, toColumn;
        ChessBoard board = new ChessBoard("White");
        Bishop bishop = new Bishop("White");

        line=3; column=3; toLine=5; toColumn=5;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+bishop.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=5; toColumn=1;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+bishop.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=0; toColumn=0;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+bishop.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=0; toColumn=6;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+bishop.canMoveToPosition(board,line,column,toLine,toColumn));

        line=3; column=3; toLine=1; toColumn=6;
        System.out.println("line"+line+"; column:"+column+"; toLine:"+toLine+"; toColumn:"+toColumn+"; canMove:"+bishop.canMoveToPosition(board,line,column,toLine,toColumn));
    }
}
