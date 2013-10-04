package GUI;

import Controller.MouseAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/15/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyPanel extends JPanel {

    public JButton getButtons(int i) {
        return buttons[i];
    }

    private JButton[] buttons;

    public MyPanel() {

        super(new GridLayout(8, 8));
        buttons = new JButton[64];


        for (int i = 0; i < 64; i++) {
            buttons[i] = new JButton();
            // buttons[i].setSize(20,20);
            int x = i / 8;
            int y = i % 8;
            if ((x + y) % 2 == 0) {
                //buttons[i].setBackground(Color.WHITE);
                buttons[i].setBackground(new Color(254, 196, 141));
            } else {
                // buttons[i].setBackground(Color.GRAY);
                buttons[i].setBackground(new Color(196, 119, 55));
            }
            buttons[i].setIcon(pieceImage(i));

            buttons[i].putClientProperty("x", i / 8);
            buttons[i].putClientProperty("y", i % 8);
            MouseAction mouseaction = new MouseAction();
            buttons[i].addMouseListener(mouseaction);
            buttons[i].addMouseMotionListener(mouseaction);
            this.add(buttons[i]);

        }


    }

    private ImageIcon pieceImage(int i) {

        ImageIcon piece = null;
        String[] Paths = {"/black_rook.gif", "/black_knight.gif", "/black_bishop.gif", "/black_queen.gif"
                , "/black_king.gif", "/black_bishop.gif", "/black_knight.gif", "/black_rook.gif"
                , "/white_rook.gif", "/white_knight.gif", "/white_bishop.gif", "/white_queen.gif"
                , "/white_king.gif", "/white_bishop.gif", "/white_knight.gif", "/white_rook.gif"

        };
        try {
            if (i < 8) {

                piece = new ImageIcon(ImageIO.read(getClass().getResource(Paths[i])));

            } else if (i > 7 && i < 16) {
                piece = new ImageIcon(ImageIO.read(getClass().getResource("/black_pawn.gif")));

            } else if (i > 47 && i < 56) {
                piece = new ImageIcon(ImageIO.read(getClass().getResource("/white_pawn.gif")));

            } else if (i > 55) {
                piece = new ImageIcon(ImageIO.read(getClass().getResource(Paths[i - 56 + 8])));

            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            return piece;
        }


    }


}
