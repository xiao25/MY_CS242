package ChessGame;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/16/13
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandManager {
    private Command lastCommand;

    public CommandManager() {
    }

    public void executeCommand(Command c) {
        c.execute();
        lastCommand = c;
    }

    public boolean isUndoAvailable() {
        return lastCommand != null;
    }

    public void undo() {
        assert (lastCommand != null);
        lastCommand.undo();
        lastCommand = null;
    }
}
