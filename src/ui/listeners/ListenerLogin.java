/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ui.form.FrmLogin;
import ui.form.FrmMain;

/**
 *
 * @author Veljko
 */
public class ListenerLogin implements ActionListener {

    private final FrmLogin frmLogin;

    public ListenerLogin(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = String.valueOf(frmLogin.getPanelUsername().getValue());
            String password = String.valueOf(frmLogin.getPanelPassword().getValue());
            Controller.getInstance().login(username, password);
            frmLogin.setVisible(false);
            new FrmMain().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmLogin.getBtnLogin(), Controller.readResourceBundle(ex).getMessage(), "Error", 0);
        }
    }
}
