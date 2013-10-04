package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class OtherpiecesException extends Exception {
    public String msg;

    public OtherpiecesException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public OtherpiecesException() {
        super();

    }
}
