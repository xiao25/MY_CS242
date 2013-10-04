package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class OutofboardException extends Exception {
    public String msg;

    public OutofboardException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public OutofboardException() {
        super();

    }
}
