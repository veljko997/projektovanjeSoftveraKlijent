/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import domain.Match;
import domain.MatchType;
import domain.Selection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmNewMatch;
import wrapperEnum.WrapperMatchType;

/**
 *
 * @author Veljko
 */
public class ListernInputNewMatch implements ActionListener {

    private final FrmNewMatch frmNewMatch;
    private Selection host;
    private Selection away;
    private int hostGoals;
    private int awayGoals;
    private Date date;
    private MatchType matchType;
    private final ResourceBundle resourceBundle;
    private final Logger logger = Logger.getLogger(ListernInputNewMatch.class);

    public ListernInputNewMatch(FrmNewMatch frmNewMatch) {
        this.frmNewMatch = frmNewMatch;
        resourceBundle = frmNewMatch.getResourceBundle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            readAwayGoals();
            readHostGoals();
            readDate();
            readHostAndAway();
            readMatchType();

            if (host.equals(away)) {
                JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("SameSelections"), resourceBundle.getString("Title"), 1);
                return;
            }

            Match match = new Match.Builder(host, away).matchType(matchType).
                    hostGoals(hostGoals).awayGoals(awayGoals).date(date).build();
            if (Controller.getInstance().saveMatch(match)) {
                JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("Sucessfull"), resourceBundle.getString("Title"), 1);
                frmNewMatch.dispose();
            } else {
                JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("Unsucesfull"), resourceBundle.getString("Title"), 1);
            }
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    public void readAwayGoals() throws Exception {
        Object inputa = frmNewMatch.getPanelInputAwayGoals().getValue();
        awayGoals = Integer.parseInt(inputa.toString());
    }

    public void readHostGoals() throws Exception {
        Object inputb = frmNewMatch.getPanelInputHostGoals().getValue();
        hostGoals = Integer.parseInt(inputb.toString());
    }

    private void readDate() throws Exception {
        date = (Date) frmNewMatch.getPanelInputDate().getValue();
    }

    private void readHostAndAway() {
        host = (Selection) frmNewMatch.getPanelInputHost().getValue();
        away = (Selection) frmNewMatch.getPanelInputAway().getValue();
    }

    private void readMatchType() {
        matchType = ((WrapperMatchType) frmNewMatch.getPanelInputMatchType().getValue()).getConfederation();
    }
}
