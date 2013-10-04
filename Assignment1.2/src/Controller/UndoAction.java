package Controller;

import ChessGame.GameInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 1:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class UndoAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (GameInit.currentState == GameInit.PLAYING) {
            if ((MouseAction.chosen_x == -1) && (MouseAction.chosen_y == -1)) {
                undoClicked();

            } else {
                JOptionPane.showMessageDialog(null,
                        "Your opposite player has already planed to move so you can't undo!", null,
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please Start a Game!", null,
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    private void undoClicked() {

        if (!GameInit.commandManager.isUndoAvailable()) {
            // status.setText("There are no moves to undo.");
            return;
        }
        GameInit.commandManager.undo();


    }
}
