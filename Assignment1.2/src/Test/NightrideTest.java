package Test;

import Board.MyBoard;
import ChessGame.MoveCheck;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/16/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class NightrideTest {
    MyBoard myBoard = new MyBoard();

    @Test
    public void movetest() {

        try {

            myBoard.placeNightride();
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(0, 1, 4, 3, myBoard));
            assertEquals(0, MoveCheck.move(0, 1, 2, 0, myBoard));




            myBoard.printboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

