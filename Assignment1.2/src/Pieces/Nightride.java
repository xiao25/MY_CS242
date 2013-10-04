package Pieces;

import Board.MyBoard;
import MyException.NightrideException;
import MyException.OtherpiecesException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/12/13
 * Time: 12:51 PM
 * A nightrider (also known as a knightmare or unicorn) is a fairy chess piece that can move any number
 * of steps as a knight in the same direction. Intervening squares must be vacant.
 */
public class Nightride extends Pieces {
    /**
     * @param color
     * @param type
     */
    public Nightride(MyBoard.MyColor color, String type) {
        super(color, type);

    }

    public void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception {
        if (curx == desx && cury == desy) {
            throw new NightrideException("You can't stay at here!");

        }
        if (Math.abs(desx - curx) == Math.abs(desy - cury)) {
            throw new NightrideException("Nightrider can only walk in mutil-steps of L shape!");
        }
        if ((Math.abs(desx - curx) % 2 != 0 && Math.abs(desy - cury) % 2 != 0) || ((Math.abs(desx - curx) + Math.abs(desy - cury)) % 3 != 0)) {
            throw new NightrideException("Nightrider can only walk in mutil-steps of L shape!");
        }


        int xstep = 0, ystep = 0;

        if (curx < desx) {
            if (cury < desy) {

                if ((desy - cury) > (desx - curx)) {
                    xstep = 1;
                    ystep = 2;
                } else {
                    xstep = 2;
                    ystep = 1;
                }

            } else {


                if ((cury - desy) > (desx - curx)) {
                    xstep = 1;
                    ystep = -2;
                } else {
                    xstep = 2;
                    ystep = -1;
                }
            }
        } else if (curx > desx) {
            if (cury < desy) {
                if ((desy - cury) > (curx - desx)) {
                    xstep = -1;
                    ystep = 2;
                } else {
                    xstep = -2;
                    ystep = 1;
                }
            } else {

                if ((cury - desy) > (curx - desx)) {
                    xstep = -1;
                    ystep = -2;
                } else {
                    xstep = -2;
                    ystep = -1;
                }
            }
        }


        for (int i = 1; xstep * i + curx != desx; i++) {
            if (chessboard[curx + i * xstep][cury + i * ystep] != null) {
                throw new OtherpiecesException("There are other pieces on the Nightrider Path!");
            }
        }

    }
}
