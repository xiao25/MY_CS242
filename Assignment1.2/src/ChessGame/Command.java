package ChessGame;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/16/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    public void execute();

    public void undo();
}
