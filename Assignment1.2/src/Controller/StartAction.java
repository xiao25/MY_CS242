package Controller;

import ChessGame.GameInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class StartAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.


        if (GameInit.currentState == GameInit.NOPLAYING) {
            int choice = JOptionPane.showConfirmDialog(null,
                    "Do you want to start a game?", null,
                    JOptionPane.YES_NO_OPTION);

            if (choice == 0) {
                GameInit.currentState = GameInit.PLAYING;
                GameInit.currentPlayer = GameInit.WHITEPlayer;

//                    GUI.whiteScore.setText("White Player Score: "
//                            + + GameInit.whiteScore);
//                    GUI.blackScore.setText("Black Player Score: "
//                            + +  GameInit.blackScore);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Game is already started.",
                    null, JOptionPane.WARNING_MESSAGE);
        }

    }
}
