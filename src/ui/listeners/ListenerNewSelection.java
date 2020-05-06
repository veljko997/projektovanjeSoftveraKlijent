/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import domain.Selection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmNewSelection;
import wrapperEnum.WrapperConfederation;

/**
 *
 * @author veljko
 */
public class ListenerNewSelection implements ActionListener {

    private final FrmNewSelection frmNewSelection;
    private String selectionName;
    private final Logger logger = Logger.getLogger(ListenerNewSelection.class);

    public ListenerNewSelection(FrmNewSelection frmNewMatch) {
        this.frmNewSelection = frmNewMatch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            readSelectionName();
            ResourceBundle resourceBundle = frmNewSelection.getResourceBundle();

            Selection selection = new Selection(selectionName);
            selection.setConfederation(((WrapperConfederation) frmNewSelection.getPanelInputConfederation().
                    getValue()).getConfederation());

            if (Controller.getInstance().saveSelection(selection)) {
                JOptionPane.showMessageDialog(frmNewSelection, resourceBundle.getString("SuccesfullAdded"), resourceBundle.getString("Title"),
                        1);
                frmNewSelection.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(frmNewSelection, resourceBundle.getString("UnsuseccsfullAdded"), resourceBundle.getString("Title"),
                        1);
            }
        }  catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    }

    private void readSelectionName() throws Exception {
        selectionName = (String) frmNewSelection.getPanelInputName().getValue();
    }
}
