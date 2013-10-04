package ChessGame;

import Board.MyBoard;
import Controller.MouseAction;
import GUI.GUI;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/16/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */

public class MovepieceCommand implements Command {

    private int initialx;
    private int initialy;
    private int finalx;
    private int finaly;
    private MyBoard board;
    private JButton rightClick;

    public MovepieceCommand(int initialx, int initialy, int finalx, int finaly, MyBoard board, JButton rightClick) {
        this.initialx = initialx;
        this.initialy = initialy;
        this.finalx = finalx;
        this.finaly = finaly;
        this.board = board;
        this.rightClick = rightClick;

    }


    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        MoveCheck.movepieces(initialx, initialy, finalx, finaly, board);
        //move piece in the GUI
        rightClick.setIcon(MouseAction.chosenImage);
        MouseAction.oldLocation.setIcon(null);
        GameInit.switchPlayer();
        MouseAction.chosen_y = MouseAction.chosen_x = -1;

        if (GameInit.currentState == GameInit.WHITEWON) {
            JOptionPane.showMessageDialog(null, "Congratulations!! White Player Won!!", null, JOptionPane.WARNING_MESSAGE);
            GameInit.whiteScore++;

            GUI.whiteScore.setText("White Player Score "
                    + GameInit.whiteScore);

        } else if (GameInit.currentState == GameInit.BLACKWON) {
            JOptionPane.showMessageDialog(null, "Congratulations!! Black Player Won!!", null, JOptionPane.WARNING_MESSAGE);
            GameInit.blackScore++;

            GUI.blackScore.setText("Blakc Player Score "
                    + GameInit.blackScore);
        }
    }

    @Override
    public void undo() {
        //To change body of implemented methods use File | Settings | File Templates.

        MoveCheck.movepieces(finalx, finaly, initialx, initialy, board);
        rightClick.setIcon(null);
        MouseAction.oldLocation.setIcon(MouseAction.chosenImage);

        GameInit.switchPlayer();
    }
}

