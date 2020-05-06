/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import exceptions.DifferentPasswordException;
import exceptions.ShortPasswordException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import ui.form.FrmLogin;
import ui.form.FrmRegistration;

/**
 *
 * @author veljko
 */
public class ListenerRegistration implements ActionListener {

    private final FrmRegistration frmRegistration;
    String username;
    String password;
    String password2;

    public ListenerRegistration(FrmRegistration frmRegistration) {
        this.frmRegistration = frmRegistration;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            username = (String) frmRegistration.getPanelInputUsername().getValue();
            password = (String) frmRegistration.getPanelInputPasswordFirstTime().getValue();
            password2 = (String) frmRegistration.getPanelInputPasswordSecondTime().getValue();
            checkPasswords();
            Controller.getInstance().register(username,password);
            ResourceBundle resourceBundle = frmRegistration.getResourceBundle();
            JOptionPane.showMessageDialog(frmRegistration, resourceBundle.getString("message"),resourceBundle.getString("title"), 1);
            frmRegistration.dispose();
            new FrmLogin().setVisible(true);
        } catch (Exception ex) {
            frmRegistration.getPanelInputPasswordSecondTime().getLblFieldError().setText(ex.getMessage());
        } 
    }

    private void checkPasswords() throws  Exception {
        if(password.length()<6) throw Controller.readResourceBundle(new ShortPasswordException());
        if (!password.equals(password2)) throw Controller.readResourceBundle(new DifferentPasswordException());
    }

}
