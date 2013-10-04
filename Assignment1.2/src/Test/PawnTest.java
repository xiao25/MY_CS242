package Test;


import Board.MyBoard;
//import org.testng.annotations.Test;
//
//import static org.testng.AssertJUnit.assertEquals;

import ChessGame.MoveCheck;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
* @author ztx
*/
public class PawnTest {

    @Test
    public void normalmovetest() {


        try {
            MyBoard myBoard = new MyBoard();
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(1, 0, 3, 0, myBoard));
            MoveCheck.movepieces(1, 3, 3, 3, myBoard);
            assertEquals(0, MoveCheck.move(6, 1, 4, 1,myBoard));
            MoveCheck.movepieces(1, 3, 3, 3, myBoard);
            assertEquals(0, MoveCheck.move(3, 0, 4, 1,myBoard));


        } catch (Exception e) {
           e.printStackTrace();

        }


    }


    @Test
    public void Pawnruletest() {


        try {
            MyBoard myBoard = new MyBoard();
            assertEquals(0, MoveCheck.move(1, 3, 2, 3,myBoard));
            assertEquals(-1, MoveCheck.move(2, 3, 4, 3,myBoard));

        } catch (Exception e) {
           e.printStackTrace();

        }


    }


}
