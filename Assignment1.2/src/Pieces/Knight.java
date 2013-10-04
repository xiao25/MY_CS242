package Pieces;

import Board.MyBoard;
import MyException.KnightException;


/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:30 AM
 * This class is empty since all Knight rules are checked in the move method of Pieces.
 */
public class Knight extends Pieces {
    /**
     * @param color
     * @param type
     */
    public Knight(MyBoard.MyColor color, String type) {
        super(color, type);

    }

    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        if (curx == desx && cury == desy) {
            throw new KnightException("You can't stay at here!");

        }
        if (Math.abs(curx - desx) > 2 || Math.abs(cury - desy) > 2 || Math.abs(curx - desx) + Math.abs(desy - cury) != 3) {
            throw new KnightException("Kingiht can only walk in L shape");

        }


    }
}
