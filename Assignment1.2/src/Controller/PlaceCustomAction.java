package Controller;

import ChessGame.GameInit;
import GUI.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/17/13
 * Time: 1:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlaceCustomAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        if (GameInit.currentState != GameInit.PLAYING) {
            GUI.chessboard.placeGrasshopper();
            GUI.chessboard.placeNightride();

            JButton button;


            try {
                button = GUI.myPanel.getButtons(1);
                //getClass.getClassloader.getResource(image)
                button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/black_nightride.gif"))));


                button = GUI.myPanel.getButtons(3);
                button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/black_grasshopper.gif"))));

                button = GUI.myPanel.getButtons(57);
                button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/white_nightride.gif"))));

                button = GUI.myPanel.getButtons(59);
                button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/white_grasshopper.gif"))));
            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Can't change board in a running game!", null,
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
