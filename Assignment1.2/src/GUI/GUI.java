package GUI;

import Board.MyBoard;
import ChessGame.GameInit;
import Controller.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/12/13
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class GUI {
    public static JLabel whiteScore;
    public static JLabel blackScore;
    public static JFrame window;
    public static MyPanel myPanel;

    public static void setChessboard(MyBoard chessboard) {
        GUI.chessboard = chessboard;
    }

    public static MyBoard chessboard;

    public GUI() {

        window = new JFrame("Chess game");


        myPanel = new MyPanel();


        setUpMenu(window);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel myControl = new ControlPanel();
        ScorePanel myScore = new ScorePanel();


        window.add(myPanel, BorderLayout.CENTER);
        window.add(myControl, BorderLayout.SOUTH);
        window.add(myScore, BorderLayout.EAST);
        //  window.pack();
        window.setSize(600, 500);
        window.setResizable(false);
    }


    private void setUpMenu(JFrame window) {
        JMenuBar menubar = new JMenuBar();
        JMenu boardType = new JMenu("BoardType");
        JMenu copyright = new JMenu("Copyright");
        JMenuItem CustomBoard = new JMenuItem("CustomBoard");
        JMenuItem StandardBoard = new JMenuItem("StandardBoard");


        CustomBoard.addActionListener(new PlaceCustomAction());
        StandardBoard.addActionListener(new PlaceStandardAction());
        copyright.addActionListener(new CopyrightAction());

        boardType.add(CustomBoard);
        boardType.add(StandardBoard);

        menubar.add(boardType);
        menubar.add(copyright);
        window.setJMenuBar(menubar);
    }

    private static class ControlPanel extends JPanel {
        public ControlPanel() {
            super(new GridLayout(1, 4));

            JButton startButton = new JButton("Start");

            JButton restartButton = new JButton("Restart");
            JButton forfeitButton = new JButton("ForFeit");
            JButton undoButton = new JButton("Undo");

            startButton.setBackground(new Color(99, 196, 250));
            restartButton.setBackground(new Color(99, 196, 250));
            forfeitButton.setBackground(new Color(99, 196, 250));
            undoButton.setBackground(new Color(99, 196, 250));

            startButton.setFont(new Font("Engravers MT", Font.ITALIC, 12));
            restartButton.setFont(new Font("Engravers MT", Font.ITALIC, 12));
            forfeitButton.setFont(new Font("Engravers MT", Font.ITALIC, 12));
            undoButton.setFont(new Font("Engravers MT", Font.ITALIC, 12));

            startButton.addActionListener(new StartAction());
            restartButton.addActionListener(new RestartAction());
            forfeitButton.addActionListener(new ForfeitAction());
            undoButton.addActionListener(new UndoAction());

            this.add(startButton);
            this.add(restartButton);
            this.add(forfeitButton);
            this.add(undoButton);
        }

    }


    private static class ScorePanel extends JPanel {

        public ScorePanel() {


            super(new GridLayout(2, 1));

            JButton whiteScoreButton = new JButton();
            JButton blackScoreButton = new JButton();

            whiteScore = new JLabel();
            blackScore = new JLabel();

            whiteScoreButton.setBackground(new Color(0, 138, 208));
            blackScoreButton.setBackground(new Color(0, 138, 208));

            whiteScore.setFont(new Font("Chalkduster", Font.BOLD, 12));
            blackScore.setFont(new Font("Chalkduster", Font.BOLD, 12));

            whiteScore.setText("White Player Score: " + GameInit.whiteScore
            );
            blackScore.setText("Black Player Score: " + GameInit.blackScore
            );

            whiteScoreButton.add(whiteScore);
            blackScoreButton.add(blackScore);

            this.add(blackScoreButton);
            this.add(whiteScoreButton);

        }
    }


}
