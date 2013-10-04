package Test;


import Board.MyBoard;
//import org.testng.annotations.Test;
//
//import static org.testng.AssertJUnit.assertEquals;

import ChessGame.MoveCheck;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
* Created with IntelliJ IDEA.
* User: ztx
* Date: 9/5/13
* Time: 11:26 AM
* To change this template use File | Settings | File Templates.
*/
public class KnightTest {
    @Test
    public void movetest() {


        try {
            MyBoard myBoard = new MyBoard();
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(0, 1, 2, 2,myBoard));
            MoveCheck.movepieces(0, 1, 2, 2, myBoard);
            myBoard.printboard();
            assertEquals(-1, MoveCheck.move(7, 1, 6, 3,myBoard));


            myBoard.printboard();
        } catch (Exception e) {
           e.printStackTrace();

        }


    }



}
