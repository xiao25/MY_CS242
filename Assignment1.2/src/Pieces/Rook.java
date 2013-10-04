package Pieces;


import Board.MyBoard;
import ChessGame.MoveCheck;
import MyException.OtherpiecesException;
import MyException.RookException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:25 AM
 * This class is to check whether a move method is legal for a Rook.
 */
public class Rook extends Pieces {


    /**
     * @param color
     * @param type
     */
    public Rook(MyBoard.MyColor color, String type) {
        super(color, type);
    }

    @Override
    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        int count = -1;
        if (curx != desx && cury != desy) {
            throw new RookException("Rook can only walk in column or row!");
        } else if (curx == desx && desy < cury) {
            count = MoveCheck.leftcheck(curx, cury, desy, chessboard);

        } else if (curx == desx && desy > cury) {
            count = MoveCheck.rightcheck(curx, cury, desy, chessboard);
        } else if (cury == desy && desx < curx) {
            count = MoveCheck.upcheck(curx, cury, desx, chessboard);
        } else if (cury == desy && desx > curx) {
            count = MoveCheck.downcheck(curx, cury, desx, chessboard);
        }

        if (count != 0) {

            throw new OtherpiecesException("There are other pieces on the Rook road!");
        }


    }
}
