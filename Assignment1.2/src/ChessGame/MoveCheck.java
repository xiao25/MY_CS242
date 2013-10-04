package ChessGame;

import Board.MyBoard;
import MyException.EatException;
import MyException.NopieceException;
import MyException.OutofboardException;
import Pieces.Pawn;
import Pieces.Pieces;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoveCheck {
    public static boolean checknum(int num) {
        if (num < 0 || num > 8) {
            return false;
        }
        return true;
    }


    public static void movepieces(int curx, int cury, int desx, int desy, MyBoard board) {
        Pieces[][] chessboard = board.getChessboard();

        if (chessboard[desx][desy] != null) {
            System.out.print(chessboard[curx][cury].color);
            System.out.print(chessboard[curx][cury].type + " eat a " + chessboard[desx][desy].color);
            System.out.println(chessboard[desx][desy].type);
            if (chessboard[desx][desy].type.equals("K")) {
                System.out.println(chessboard[curx][cury].color + " player wins!");
                if (chessboard[curx][cury].color == MyBoard.MyColor.B) {
                    GameInit.currentState = GameInit.BLACKWON;
                } else {
                    GameInit.currentState = GameInit.WHITEWON;
                }

            }


        }


        if (chessboard[curx][cury].type.equals("P")) {
            Pawn pawn = (Pawn) chessboard[curx][cury];
            pawn.setFirsttime(false);
        }


        chessboard[desx][desy] = chessboard[curx][cury];
        chessboard[curx][cury] = null;


        board.printboard();
    }


    /**
     * move pieces to destination with distance and direction
     * detect all parameters are legal and make the change on board.
     * According to the direction, it can call relatively direction move method.
     * Also, it can detect pawn walk is legal or not.
     */

    public static int move(int curx, int cury, int desx, int desy, MyBoard board) {
        int returnvalue = 0;
        Pieces[][] chessboard = board.getChessboard();
        try {

            if (!checknum(curx) || !checknum(cury) || !checknum(desx) || !checknum(desy)) {
                throw new OutofboardException("Thers is no such position on the board!");


            } else if (chessboard[curx][cury] == null) {
                throw new NopieceException("There is no pieces on this place!");
            } else {
                //whether this piece can go to that position
                chessboard[curx][cury].moveck(curx, cury, desx, desy, chessboard);


                eatcheck(curx, cury, desx, desy, chessboard);


            }

        } catch (Exception e) {
            // e.printStackTrace();
            returnvalue = -1;
        } finally {
            return returnvalue;
        }


    }


    /*
    * This method is used to check whether this step will eat a piece and is it legal. Also,
    * if a King is eaten, the game is over.
    * */
    private static void eatcheck(int curx, int cury, int destx, int desty, Pieces[][] chessboard) throws Exception {


        if (chessboard[destx][desty] != null && chessboard[destx][desty].color == chessboard[curx][cury].color) {
            throw new EatException("There is your " + chessboard[destx][desty] + " so you can't eat it!");
        }


    }


    public static int upcheck(int curx, int cury, int desx, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; curx - i != desx; i++) {
            if (chessboard[curx - i][cury] != null) {
                ++count;
            }
        }


        return count;

    }


    public static int downcheck(int curx, int cury, int desx, Pieces[][] chessboard) {

        int i, count = 0;


        for (i = 1; curx + i != desx; i++) {
            if (chessboard[curx + i][cury] != null) {
                ++count;
            }
        }


        return count;

    }


    public static int leftcheck(int curx, int cury, int desy, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; cury - i != desy; i++) {
            if (chessboard[curx][cury - i] != null) {
                ++count;
            }
        }


        return count;


    }

    public static int rightcheck(int curx, int cury, int desy, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; cury + i != desy; i++) {
            if (chessboard[curx][cury + i] != null) {
                ++count;
            }
        }


        return count;

    }

    public static int leftupcheck(int curx, int cury, int desx, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; curx - i != desx; i++) {
            if (chessboard[curx - i][cury - i] != null) {
                ++count;
            }
        }


        return count;

    }

    public static int leftdowncheck(int curx, int cury, int desx, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; curx + i != desx; i++) {
            if (chessboard[curx + i][cury - i] != null) {
                ++count;
            }
        }


        return count;

    }

    public static int rightupcheck(int curx, int cury, int desx, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; curx - i != desx; i++) {
            if (chessboard[curx - i][cury + i] != null) {
                ++count;
            }
        }


        return count;
    }

    public static int rightdowncheck(int curx, int cury, int desx, Pieces[][] chessboard) {


        int i, count = 0;


        for (i = 1; curx + i != desx; i++) {
            if (chessboard[curx + i][cury + i] != null) {
                ++count;
            }
        }


        return count;

    }

}
