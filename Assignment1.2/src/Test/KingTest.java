package Test;


import Board.MyBoard;
import ChessGame.MoveCheck;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

//import org.testng.annotations.Test;
//
//import static org.testng.AssertJUnit.assertEquals;


/**
* Created with IntelliJ IDEA.
* User: ztx
* Date: 9/5/13
* Time: 11:24 AM
* To change this template use File | Settings | File Templates.
*/
public class KingTest {
    @Test
    public void movetest() {


        try {
            MyBoard myBoard = new MyBoard();
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(1, 3, 3, 3, myBoard));
            MoveCheck.movepieces(1, 3, 3, 3, myBoard);
            assertEquals(0, MoveCheck.move(0, 3, 1, 3,myBoard));
            MoveCheck.movepieces(0, 3, 1, 3, myBoard);
            assertEquals(0, MoveCheck.move(7, 6, 5, 5,myBoard));
            MoveCheck.movepieces(7, 6, 5, 5, myBoard);
            assertEquals(0, MoveCheck.move(1, 3, 2, 3,myBoard));
            MoveCheck.movepieces(1, 3, 2, 3, myBoard);
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(5, 5, 3, 6,myBoard));
            MoveCheck.movepieces(5, 5, 3, 6, myBoard);
            assertEquals(0, MoveCheck.move(2, 3, 2, 4,myBoard));
            MoveCheck.movepieces(2, 3, 2, 4, myBoard);
            myBoard.printboard();

            assertEquals(0, MoveCheck.move(3, 6, 2, 4,myBoard));
            MoveCheck.movepieces(3, 6, 2, 4, myBoard);

            myBoard.printboard();
            //  assertEquals(-1, myBoard.move(2, 4, 3,4 ));


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

}
