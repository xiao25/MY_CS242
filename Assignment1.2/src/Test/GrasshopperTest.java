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
public class GrasshopperTest {
    MyBoard myBoard = new MyBoard();

    @Test
    public void movetest() {

        try {

            myBoard.placeGrasshopper();
            myBoard.printboard();
            assertEquals(0, MoveCheck.move(0, 3, 2, 5, myBoard));
            assertEquals(0, MoveCheck.move(0, 3, 3, 6, myBoard));
            assertEquals(0, MoveCheck.move(0, 3, 4, 7, myBoard));
            assertEquals(0, MoveCheck.move(0, 3, 2, 1, myBoard));



            myBoard.printboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
