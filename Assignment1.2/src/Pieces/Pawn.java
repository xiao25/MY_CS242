package Pieces;


import Board.MyBoard;
import ChessGame.MoveCheck;
import MyException.OtherpiecesException;
import MyException.PawnException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/4/13
 * Time: 12:46 AM
 * This class is created to detect the move method is legal for a Pawn.
 */
public class Pawn extends Pieces {
    /**
     * @param color
     * @param type
     */
    public Pawn(MyBoard.MyColor color, String type) {
        super(color, type);

    }


    public void setFirsttime(boolean firsttime) {
        this.firsttime = firsttime;
    }

    private boolean firsttime = true;

    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        int count = -1;
        if (Math.abs(curx - desx) > 2 || (Math.abs(curx - desx) == 2 && firsttime == false)) {
            throw new PawnException("Pawn can only walk one or two steps!");
        }

        if (chessboard[curx][cury].color == MyBoard.MyColor.W) {
            if (desy == cury && desx < curx) {
                count = MoveCheck.upcheck(curx, cury, desx, chessboard);
                if (count != 0) {

                    throw new OtherpiecesException("There are other pieces on the Pawn road!");
                }


            } else if (desx == (curx - 1) && desy == (cury - 1) && chessboard[desx][desy] != null) {

            } else if (desx == (curx - 1) && desy == (cury + 1) && chessboard[desx][desy] != null) {

            } else {
                throw new PawnException("worng steps");
            }


        } else if (chessboard[curx][cury].color == MyBoard.MyColor.B) {

            if (desy == cury && desx > curx) {
                count = MoveCheck.downcheck(curx, cury, desx, chessboard);
                if (count != 0) {

                    throw new OtherpiecesException("There are other pieces on the Pawn road!");
                }


            } else if (desx == (curx + 1) && desy == (cury - 1) && chessboard[desx][desy] != null) {

            } else if (desx == (curx + 1) && desy == (cury + 1) && chessboard[desx][desy] != null) {

            } else {
                throw new PawnException("worng steps");
            }

        }


    }


}
