package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class BishopException extends Exception {
    public String msg;

    public BishopException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public BishopException() {
        super();

    }
}
