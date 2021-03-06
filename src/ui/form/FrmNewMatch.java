 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import controller.Controller;
import exceptions.ServerException;
import ui.validator.DateValidator;
import ui.validator.GoalValidator;
import ui.listeners.ListernInputNewMatch;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import ui.components.PanelInputComboBox;
import ui.components.PanelInputDate;
import ui.components.PanelInputTextField;

/**
 *
 * @author Veljko
 */
public class FrmNewMatch extends javax.swing.JFrame {

    /**
     * Creates new form FrmNewMatch
     */

    private Locale locale;
    private ResourceBundle resourceBundle;
    private Logger logger = Logger.getLogger(FrmNewMatch.class);
    
    
    public FrmNewMatch() {
        initComponents();
        prepareView();
        initValidator();
        addListener();
        fillComboBoxes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInputHostGoals = new ui.components.PanelInputTextField();
        panelInputAwayGoals = new ui.components.PanelInputTextField();
        panelInputDate = new ui.components.PanelInputDate();
        panelInputHost = new ui.components.PanelInputComboBox();
        panelInputAway = new ui.components.PanelInputComboBox();
        panelInputMatchType = new ui.components.PanelInputComboBox();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAdd.setText("Add Match");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelInputHostGoals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInputAwayGoals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInputDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInputHost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInputAway, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInputMatchType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelInputHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInputAway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInputMatchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInputHostGoals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelInputAwayGoals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelInputDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmNewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNewMatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private ui.components.PanelInputComboBox panelInputAway;
    private ui.components.PanelInputTextField panelInputAwayGoals;
    private ui.components.PanelInputDate panelInputDate;
    private ui.components.PanelInputComboBox panelInputHost;
    private ui.components.PanelInputTextField panelInputHostGoals;
    private ui.components.PanelInputComboBox panelInputMatchType;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/ball.png")));

        locale = Controller.getLocale();
        resourceBundle = ResourceBundle.getBundle("resourceBundles.resourceBundle_NewMatch_"+locale);
        
        panelInputHost.getLblFieldText().setText(resourceBundle.getString("panelInputHost_lblFieldText"));
        panelInputHost.getLblError().setText("");

        panelInputAway.getLblFieldText().setText(resourceBundle.getString("panelInputAway_lblFieldText"));
        panelInputAway.getLblError().setText("");

        panelInputHostGoals.getLblFieldText().setText(resourceBundle.getString("panelInputHostGoals_lblFieldText"));
        panelInputHostGoals.getLblError().setText("");

        panelInputAwayGoals.getLblFieldText().setText(resourceBundle.getString("panelInputAwayGoals_lblFieldText"));
        panelInputAwayGoals.getLblError().setText("");

        panelInputDate.getLblFieldText().setText(resourceBundle.getString("panelInputDate_lblFieldText"));
        panelInputDate.getLblError().setText("");

        panelInputMatchType.getLblFieldText().setText(resourceBundle.getString("panelInputMatchType_lblFieldText"));
        panelInputMatchType.getLblError().setText("");

        btnAdd.setText(resourceBundle.getString("btnAdd"));
    }

    private void initValidator() {
        GoalValidator goalValidator = new GoalValidator();
        panelInputAwayGoals.setValidator(goalValidator);
        panelInputHostGoals.setValidator(goalValidator);

        DateValidator dateValidator = new DateValidator();
        panelInputDate.setValidator(dateValidator);
    }

    private void addListener() {
        ActionListener listener = new ListernInputNewMatch(this);
        btnAdd.addActionListener(listener);
    }

    private void fillComboBoxes() {
        try {
            panelInputMatchType.initialize(Controller.getInstance().getAllMatchTypes());
            panelInputHost.initialize(Controller.getInstance().getAllSelections());
            panelInputAway.initialize(Controller.getInstance().getAllSelections());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } 
    }

    public PanelInputComboBox getPanelInputAway() {
        return panelInputAway;
    }

    public PanelInputTextField getPanelInputAwayGoals() {
        return panelInputAwayGoals;
    }

    public PanelInputDate getPanelInputDate() {
        return panelInputDate;
    }

    public PanelInputComboBox getPanelInputHost() {
        return panelInputHost;
    }

    public PanelInputTextField getPanelInputHostGoals() {
        return panelInputHostGoals;
    }

    public PanelInputComboBox getPanelInputMatchType() {
        return panelInputMatchType;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }  
    
}
