package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/11/13
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class EatException extends Exception {
    public String msg;

    public EatException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public EatException() {
        super();

    }
}
