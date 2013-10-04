package Controller;

import Board.MyBoard;
import ChessGame.GameInit;
import ChessGame.MoveCheck;
import ChessGame.MovepieceCommand;
import GUI.GUI;
import Pieces.Pieces;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/14/13
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class MouseAction implements MouseInputListener,
        MouseMotionListener {

    public static Color SquareColor;
    public static int chosen_x = -1;
    public static int chosen_y = -1;
    public static ImageIcon chosenImage;
    public static JButton oldLocation;

    @Override
    public void mouseClicked(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        Pieces[][] chessboard = GUI.chessboard.getChessboard();
        int flag = -1;
        if (GameInit.currentState == GameInit.PLAYING) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                JButton leftClick = (JButton) e.getSource();
                chosen_x = (Integer) leftClick.getClientProperty("x");
                chosen_y = (Integer) leftClick.getClientProperty("y");

                if (chessboard[chosen_x][chosen_y] != null) {


                    if ((chessboard[chosen_x][chosen_y].color == MyBoard.MyColor.B && GameInit.currentPlayer == GameInit.BLACKPlayer)
                            || (chessboard[chosen_x][chosen_y].color == MyBoard.MyColor.W && GameInit.currentPlayer == GameInit.WHITEPlayer)) {
                        chosenImage = (ImageIcon) leftClick.getIcon();
                        oldLocation = leftClick;
                        leftClick.setBackground(Color.green);
                        flag = 1;
                    }

                }

                if (flag == -1) {
                    chosen_y = chosen_x = -1;
                    leftClick.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "You can only move your pieces!", null, JOptionPane.WARNING_MESSAGE);


                }


            }

            //right click
            else {
                JButton rightClick = (JButton) e.getSource();
                if (rightClick.getBackground().equals(Color.green)) {
                    // excute a movepieceCommand

                    //move piece in the datastructure
                    // MoveCheck.movepieces(chosen_x, chosen_y, (Integer) rightClick.getClientProperty("x"), (Integer) rightClick.getClientProperty("y"), GUI.chessboard);

                    MovepieceCommand movepieceCommand = new MovepieceCommand(chosen_x, chosen_y, (Integer) rightClick.getClientProperty("x"),
                            (Integer) rightClick.getClientProperty("y"), GUI.chessboard, rightClick);

                    GameInit.commandManager.executeCommand(movepieceCommand);


                } else {
                    JOptionPane.showMessageDialog(null, "You can't move to this position!", null, JOptionPane.WARNING_MESSAGE);
                }

            }
        } else if (GameInit.currentState == GameInit.NOPLAYING) {

            JOptionPane.showMessageDialog(null, "Please Start a game first.", null, JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please Restart a game first.", null, JOptionPane.WARNING_MESSAGE);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        JButton enteredButton = (JButton) e.getSource();
        SquareColor = enteredButton.getBackground();
        if (chosen_x != -1 && chosen_y != -1) {
//
            int fianlx = (Integer) enteredButton.getClientProperty("x");
            int fianly = (Integer) enteredButton.getClientProperty("y");
            if (MoveCheck.move(chosen_x, chosen_y, fianlx, fianly, GUI.chessboard) == 0) {
                enteredButton.setBackground(Color.green);
            } else {
                enteredButton.setBackground(Color.red);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        JButton exitedButton = (JButton) e.getSource();
        exitedButton.setBackground(SquareColor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
