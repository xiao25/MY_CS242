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
* Time: 11:27 AM
* To change this template use File | Settings | File Templates.
*/
public class MyBoardTest {
    @Test
    public void movetest() {


        try {
            MyBoard myBoard = new MyBoard();

            assertEquals(-1, MoveCheck.move(-1, -1, -2, 0,myBoard));


            assertEquals(-1, MoveCheck.move(1, 1, -5, 3,myBoard));

            assertEquals(-1, MoveCheck.move(1, 1, 10, 1,myBoard));

            assertEquals(-1, MoveCheck.move(7, 1, 0, -4,myBoard));


            myBoard.printboard();
        } catch (Exception e) {
           e.printStackTrace();

        }


    }
}
