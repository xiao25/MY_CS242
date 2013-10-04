/**
 *
 */

package Board;


import Pieces.*;


/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * This class creates a square chess board and the move method here is a public interface for test cases.
 * And this move will actually call the move method in pieces.
 */


public final class MyBoard extends Board {

    public enum MyColor {
        B, W
    }

    /**
     * new and put all pieces to their right places
     */
    public MyBoard() {


        // put the pieces on the board.
        chessboard = new Pieces[8][8];
        for (int i = 0; i < 8; i++) {
            chessboard[i] = new Pieces[8];
        }
        MyColor c = MyColor.B;
        chessboard[0][0] = new Rook(MyColor.B, "R");
        chessboard[0][1] = new Knight(MyColor.B, "N");
        chessboard[0][2] = new Bishop(MyColor.B, "B");
        chessboard[0][3] = new Queen(MyColor.B, "Q");
        chessboard[0][4] = new King(MyColor.B, "K");

        chessboard[0][5] = new Bishop(MyColor.B, "B");
        chessboard[0][6] = new Knight(MyColor.B, "N");
        chessboard[0][7] = new Rook(MyColor.B, "R");

        for (int j = 0; j < 8; j++) {
            chessboard[1][j] = new Pawn(MyColor.B, "P");
        }

        chessboard[7][0] = new Rook(MyColor.W, "R");
        chessboard[7][1] = new Knight(MyColor.W, "N");
        chessboard[7][2] = new Bishop(MyColor.W, "B");
        chessboard[7][3] = new Queen(MyColor.W, "Q");
        chessboard[7][4] = new King(MyColor.W, "K");

        chessboard[7][5] = new Bishop(MyColor.W, "B");
        chessboard[7][6] = new Knight(MyColor.W, "N");
        chessboard[7][7] = new Rook(MyColor.W, "R");

        for (int j = 0; j < 8; j++) {
            chessboard[6][j] = new Pawn(MyColor.W, "P");
        }


    }

    public void placeGrasshopper() {
        chessboard[0][3] = new Grasshopper(MyColor.B, "G");
        chessboard[7][3] = new Grasshopper(MyColor.W, "G");

    }

    public void placeNightride() {
        chessboard[0][1] = new Nightride(MyColor.B, "T");
        chessboard[7][1] = new Nightride(MyColor.W, "T");

    }

    public void placeStandardback() {
        chessboard[0][1] = new Knight(MyColor.B, "N");
        chessboard[7][1] = new Knight(MyColor.W, "N");

        chessboard[0][3] = new Queen(MyColor.B, "Q");
        chessboard[7][3] = new Queen(MyColor.W, "Q");

    }

}


