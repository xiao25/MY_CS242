package ChessGame;

import Board.MyBoard;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 2:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameInit {
    public static final int NOPLAYER = -1;
    public static final int NOPLAYING = 0;
    public static final int PLAYING = 3;
    public static final int BLACKPlayer = 1;
    public static final int WHITEPlayer = 2;
    public static final int WHITEWON = 4;
    public static final int BLACKWON = 5;

    public static int currentState;
    public static int currentPlayer;

    public static int whiteScore;
    public static int blackScore;
    public static CommandManager commandManager;

    public static MyBoard initBoard() {
        MyBoard myBoard = new MyBoard();
        currentState = NOPLAYING;
        currentPlayer = NOPLAYER;
        commandManager = new CommandManager();
        return myBoard;
    }

    public static void switchPlayer() {
        if (currentPlayer == BLACKPlayer)
            currentPlayer = WHITEPlayer;
        else
            currentPlayer = BLACKPlayer;
    }

}
