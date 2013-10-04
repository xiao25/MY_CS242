package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class KnightException extends Exception {
    public String msg;

    public KnightException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public KnightException() {
        super();

    }
}
