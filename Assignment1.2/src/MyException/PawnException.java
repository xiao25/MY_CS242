package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PawnException extends Exception {
    public String msg;

    public PawnException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public PawnException() {
        super();

    }
}
