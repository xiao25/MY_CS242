package Pieces;


import Board.MyBoard;
import ChessGame.MoveCheck;
import MyException.OtherpiecesException;
import MyException.QueenException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:22 AM
 * This class is empty because there is no specific walk limitation for Queen. The edge and barrier
 * problems will be checked in the move method of Pieces.
 */
public class Queen extends Pieces {
    /**
     * @param color
     * @param type
     */
    public Queen(MyBoard.MyColor color, String type) {
        super(color, type);

    }

    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        if (curx == desx && cury == desy) {
            throw new QueenException("You can't stay at here!");

        }
        int count = helpper(curx, cury, desx, desy, chessboard);
        if (count != 0) {
            throw new OtherpiecesException("There are some other peices on the Queen path!");
        }


    }


    protected int helpper(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws QueenException {
        int count = -1;
        if (curx == desx) {
            if (cury < desy) {
                count = MoveCheck.rightcheck(curx, cury, desy, chessboard);
            } else {
                count = MoveCheck.leftcheck(curx, cury, desy, chessboard);
            }

        } else if (cury == desy) {
            if (curx < desx) {
                count = MoveCheck.downcheck(curx, cury, desx, chessboard);
            } else {
                count = MoveCheck.upcheck(curx, cury, desx, chessboard);

            }

        } else if (Math.abs(curx - desx) != Math.abs(cury - desy)) {
            throw new QueenException("Queen can only move in diagonal or column or row!");
        } else {

            if (curx < desx) {
                if (cury < desy) {

                    count = MoveCheck.rightdowncheck(curx, cury, desx, chessboard);
                } else {
                    count = MoveCheck.leftdowncheck(curx, cury, desx, chessboard);
                }
            } else if (curx > desx) {
                if (cury < desy) {
                    count = MoveCheck.rightupcheck(curx, cury, desx, chessboard);
                } else {
                    count = MoveCheck.leftupcheck(curx, cury, desx, chessboard);
                }
            }


        }

        return count;
    }
}



