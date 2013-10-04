package ChessGame;

import Board.MyBoard;
import GUI.GUI;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 2:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameLoop {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        GameInit newGame = new GameInit();

        MyBoard chessboard = newGame.initBoard();

        newGame.whiteScore = 0;
        newGame.blackScore = 0;

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        GUI.setChessboard(chessboard);
        GUI gamegui = new GUI();
    }
}
