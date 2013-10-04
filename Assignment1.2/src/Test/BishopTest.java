package Test;


import Board.MyBoard;
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
public class BishopTest {
    MyBoard myBoard = new MyBoard();

    @Test
    public void movetest() {

        try {

            myBoard.printboard();
            assertEquals(0, MoveCheck.move(1, 3, 3, 3, myBoard));
            MoveCheck.movepieces(1, 3, 3, 3, myBoard);

            assertEquals(0, MoveCheck.move(0, 2, 2, 4, myBoard));
            MoveCheck.movepieces(0, 2, 2, 4, myBoard);

            assertEquals(-1, MoveCheck.move(2, 4, 4, 2, myBoard));

            assertEquals(0, MoveCheck.move(6, 1, 4, 1, myBoard));
            MoveCheck.movepieces(6, 1, 4, 1, myBoard);

            myBoard.printboard();
            assertEquals(-1, MoveCheck.move(5, 0, 4, 1, myBoard));

            assertEquals(0, MoveCheck.move(4, 1, 3, 1, myBoard));
            MoveCheck.movepieces(4, 1, 3, 1, myBoard);
            myBoard.printboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
