package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class NopieceException extends Exception {
    public String msg;

    public NopieceException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public NopieceException() {
        super();

    }
}
