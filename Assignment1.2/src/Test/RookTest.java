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
* Time: 9:52 AM
* To change this template use File | Settings | File Templates.
*/
public class RookTest {
    MyBoard myBoard = new MyBoard();

    @Test
    public void normalmovetest() {

       try {

            myBoard.printboard();
            assertEquals(0, MoveCheck.move(1, 0, 3, 0,myBoard));
           MoveCheck.movepieces(1, 0, 3, 0, myBoard);
            assertEquals(0, MoveCheck.move(0, 0, 2, 0,myBoard));
           MoveCheck.movepieces(0,0, 2, 0, myBoard);
            assertEquals(0, MoveCheck.move(2, 0, 2, 7,myBoard));
           MoveCheck.movepieces(2, 0, 2, 7, myBoard);
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(6, 0, 4, 0,myBoard));
           MoveCheck.movepieces(6, 0, 4, 0, myBoard);
            assertEquals(0, MoveCheck.move(7, 0, 5, 0,myBoard));
           MoveCheck.movepieces(7, 0, 5, 0, myBoard);
            assertEquals(0, MoveCheck.move(5, 0, 5, 7,myBoard));
           MoveCheck.movepieces(5, 0, 5, 7, myBoard);
            assertEquals(0, MoveCheck.move(5, 7, 5, 6,myBoard));
            myBoard.printboard();

        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Test

    public void wrongdirectiontest() {


        try {

            assertEquals(-1, MoveCheck.move(2, 5, 1, 9,myBoard));
            assertEquals(-1, MoveCheck.move(2, 5, 1, 6,myBoard));

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}
