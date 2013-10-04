package Pieces;


import Board.MyBoard;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * This class a general class for all pieces. It contains all move methods for all pieces to use.
 */
public abstract class Pieces {
    // type means a specific name of piece and color demonstrate the side of player.


    public MyBoard.MyColor color;

    public String type;


    /**
     * @param color
     * @param type
     */
    public Pieces(MyBoard.MyColor color, String type) {
        super();
        this.color = color;
        this.type = type;


    }


    /*
   * This method is used to detect if the direction and dis is legal for each specific piece
   * regardless of is there any other pieces on the path, it will be detect on move method.
   * */
    public abstract void moveck(int curx, int cury, int desx, int desy, Pieces[][] chessboard) throws Exception;


}
