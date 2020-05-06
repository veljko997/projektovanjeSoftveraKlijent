/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import exceptions.ServerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmViewSelection;

/**
 *
 * @author Veljko
 */
public class ListenerDeleteMatch implements ActionListener {

    private final FrmViewSelection frmViewSelection;
    private ResourceBundle resourceBundle;
    private int selectedRow;
    private final Logger logger = Logger.getLogger(ListenerDeleteSelection.class);

    public ListenerDeleteMatch(FrmViewSelection frmViewSelection) {
        this.frmViewSelection = frmViewSelection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectedRow = frmViewSelection.getjTableMatches().getSelectedRow();
        if (selectedRow == -1) {
            return;
        }
        
        resourceBundle = frmViewSelection.getResourceBundle();
        int command = JOptionPane.showConfirmDialog(frmViewSelection, resourceBundle.getString("DeleteMessage"), resourceBundle.getString("Title"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (command == 0) {
            deleteMatch();
        }
    }

    private void deleteMatch() {
        try {
            if (Controller.getInstance().deleteMatch(frmViewSelection.getSelection().getMatches().get(selectedRow + frmViewSelection.getStartPositon()))) {
                JOptionPane.showMessageDialog(frmViewSelection, resourceBundle.getString("Succesfully"), resourceBundle.getString("Title"), 1);
                frmViewSelection.setTable();
            } else {
                JOptionPane.showMessageDialog(frmViewSelection, resourceBundle.getString("Unsucesfull"), resourceBundle.getString("Title"), 1);
            }
        } catch (ServerException ex) {
           logger.error(ex.getMessage());
        }
    }

}
