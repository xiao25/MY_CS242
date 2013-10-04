package Controller;

import ChessGame.GameInit;
import GUI.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class ForfeitAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.

        if (GameInit.currentState == GameInit.PLAYING) {

            int choice = JOptionPane.showConfirmDialog(null,
                    "Do you want to forfeit this game?", null,
                    JOptionPane.YES_NO_OPTION);

            if (choice == 0) {
                if (GameInit.currentPlayer == GameInit.WHITEPlayer) {
                    JOptionPane.showMessageDialog(null,
                            "Congratulations!! Black Player Won this Game!!.", null,
                            JOptionPane.WARNING_MESSAGE);
                    GameInit.blackScore++;
                    GameInit.currentState = GameInit.BLACKWON;

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Congratulations!! White Player Won this Game!!.", null,
                            JOptionPane.WARNING_MESSAGE);
                    GameInit.whiteScore++;
                    GameInit.currentState = GameInit.WHITEWON;

                }


                GUI.whiteScore.setText("White Player Score "
                        + GameInit.whiteScore);
                GUI.blackScore.setText("Black Plyaer Score "
                        + GameInit.blackScore);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please Start a Game!", null,
                    JOptionPane.WARNING_MESSAGE);
        }
    }

}
