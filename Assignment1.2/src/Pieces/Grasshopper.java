package Pieces;

import Board.MyBoard;
import MyException.GrasshopperException;
import MyException.QueenException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/12/13
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Grasshopper extends Queen {
    /**
     * @param color
     * @param type
     */
    public Grasshopper(MyBoard.MyColor color, String type) {
        super(color, type);

    }

    @Override
    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        int count = -1;
        if (curx == desx && cury == desy) {
            throw new QueenException("You can't stay at here!");

        }

        count = super.helpper(curx, cury, desx, desy, chessboard);

        if (count != 1) {
            throw new GrasshopperException("There should have one and only one piece to hop!");
        }


    }


}
