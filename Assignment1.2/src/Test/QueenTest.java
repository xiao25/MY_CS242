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
public class QueenTest {
    MyBoard myBoard = new MyBoard();

    @Test
    public void movetest() {

        try {

            myBoard.printboard();
            assertEquals(0, MoveCheck.move(1, 4, 3, 4,myBoard));
            MoveCheck.movepieces(1, 4, 3, 4, myBoard);
            assertEquals(0, MoveCheck.move(0, 3, 2, 5,myBoard));
            MoveCheck.movepieces(0, 4, 2, 4, myBoard);
            assertEquals(-1, MoveCheck.move(2, 4, 6, 4,myBoard));


            myBoard.printboard();

        } catch (Exception e) {
           e.printStackTrace();
        }
    }


}
