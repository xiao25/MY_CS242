/**
 *
 */
package Pieces;

import Board.MyBoard;
import MyException.KingException;


/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:50 AM
 * This class is used to detect whether a specific move method is legal for a King. In this case, just distance steps.
 */
public class King extends Pieces {


    /**
     * @param color
     * @param type
     */
    public King(MyBoard.MyColor color, String type) {
        super(color, type);

    }

    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        if (Math.abs(cury - desy) > 1 || Math.abs(curx - desx) > 1) {
            throw new KingException("King can only move one step!");

        }


    }

    ;


}


