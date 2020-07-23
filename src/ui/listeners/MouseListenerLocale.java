/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import controller.RMIController;
import controller.SocketController;
import exceptions.ServerException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.form.FrmChooseLanguage;
import ui.form.FrmChooseLoginOrRegistration;

/**
 *
 * @author Veljko
 */
public class MouseListenerLocale implements MouseListener{

    private final String language;
    private final String country;
    private final FrmChooseLanguage frmChooseLanguage;

    public MouseListenerLocale(FrmChooseLanguage frmChooseLanguage,String language, String country) {
        this.language = language;
        this.country = country;
        this.frmChooseLanguage=frmChooseLanguage;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Controller.getInstance().writeLanguage(language, country);
            new FrmChooseLoginOrRegistration().setVisible(true);
            frmChooseLanguage.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmChooseLanguage, "Server error. Try again later!", "Error", 1);
            frmChooseLanguage.dispose();
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
