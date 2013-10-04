package MyException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/12/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrasshopperException extends Exception {
    public String msg;

    public GrasshopperException(String msg) {
        super(msg);
        this.msg = msg;

    }

    public GrasshopperException() {
        super();

    }
}
