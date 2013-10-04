package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/12/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class NightrideException extends Exception {
    public String msg;

    public NightrideException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public NightrideException() {
        super();

    }
}

