package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class KingException extends Exception {
    public String msg;

    public KingException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public KingException() {
        super();

    }
}
