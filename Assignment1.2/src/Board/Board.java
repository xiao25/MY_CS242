/**
 *
 */
package Board;


import Pieces.Pieces;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:29 AM
 * This class is the base class for a rectangle or square board class.
 */
public abstract class Board {


    public Pieces[][] getChessboard() {
        return chessboard;
    }

    protected Pieces[][] chessboard;


    public void printboard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j] == null) {
                    System.out.print("__" + " ");
                } else {
                    System.out.print(chessboard[i][j].color);
                    System.out.print(chessboard[i][j].type + " ");
                }
            }
            System.out.println("");


        }
        System.out.println("");
        System.out.println("***********************");
        System.out.println("");
    }
}
