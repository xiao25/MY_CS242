package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 9/18/13
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CopyrightAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
        JOptionPane.showMessageDialog(null, "The CopyRight of this game belongs to xiao~", null, JOptionPane.WARNING_MESSAGE);
    }

}
