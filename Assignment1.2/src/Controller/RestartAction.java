package Controller;

import Board.MyBoard;
import ChessGame.GameInit;
import GUI.GUI;
import GUI.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class RestartAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        int choice = -1;
        if (GameInit.currentState != GameInit.NOPLAYING) {
            if (GameInit.currentPlayer == GameInit.BLACKPlayer) {
                choice = JOptionPane.showConfirmDialog(null,
                        "White Player, Would you like to RESTART a Battle?", null,
                        JOptionPane.YES_NO_OPTION);
            } else {
                choice = JOptionPane.showConfirmDialog(null,
                        "Black Player, Would you like to RESTART a Battle?", null,
                        JOptionPane.YES_NO_OPTION);
            }

            if (choice == 0) {
                MouseAction.chosen_y = MouseAction.chosen_x = -1;
                MyBoard chessboard = GameInit.initBoard();
                GUI.setChessboard(chessboard);
                GameInit.currentState = GameInit.PLAYING;
                GameInit.currentPlayer = GameInit.WHITEPlayer;

                GUI.whiteScore.setText("White Player Score: "
                        + +GameInit.whiteScore);
                GUI.blackScore.setText("Black Player Score: "
                        + +GameInit.blackScore);

                GUI.myPanel.removeAll();
                GUI.window.remove(GUI.myPanel);

                GUI.myPanel = new MyPanel();

                GUI.window.add(GUI.myPanel, BorderLayout.CENTER);

                GUI.window.revalidate();
                GUI.window.repaint();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Your opposite player refuses. The Battle will go on.", null,
                        JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "Please Start a game!", null,
                    JOptionPane.WARNING_MESSAGE);
        }

    }
}
