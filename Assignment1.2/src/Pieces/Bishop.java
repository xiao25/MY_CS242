package Pieces;


import Board.MyBoard;
import ChessGame.MoveCheck;
import MyException.BishopException;
import MyException.OtherpiecesException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:29 AM
 * This class is used to detect whether a specific move method is legal for a Bishop.
 */
public class Bishop extends Pieces {
    /**
     * @param color
     * @param type
     */
    public Bishop(MyBoard.MyColor color, String type) {
        super(color, type);

    }

    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {

        int count = -1;
        if (Math.abs(curx - desx) == Math.abs(cury - desy) && curx != desx && cury != desy) {

            if (curx > desx) {
                if (cury > desy) {
                    count = MoveCheck.leftupcheck(curx, cury, desx, chessboard);
                } else {
                    count = MoveCheck.rightupcheck(curx, cury, desx, chessboard);
                }
            } else if (curx < desx) {
                if (cury < desy) {
                    count = MoveCheck.rightdowncheck(curx, cury, desx, chessboard);
                } else {
                    count = MoveCheck.leftdowncheck(curx, cury, desx, chessboard);
                }
            }

            if (count != 0) {
                throw new OtherpiecesException("There are other pieces on the Bishop road!");
            }

        } else {
            throw new BishopException("Bishop can only move in diagonal!");
        }

    }
}
