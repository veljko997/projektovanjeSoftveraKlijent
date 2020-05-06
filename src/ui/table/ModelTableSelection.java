/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.table;

import controller.Controller;
import domain.Match;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veljko
 */
public class ModelTableSelection extends AbstractTableModel {

    List<Match> matches;
    String[] columnNames;
    int startPosition;
    int tableSize;

    public ModelTableSelection(List<Match> matches, int startPosition, int tableSize) {
        this.matches = matches;
        this.startPosition = startPosition;
        this.tableSize = tableSize;
        setTColumnNames();
        
    }

    @Override
    public int getRowCount() {
        return Math.min(tableSize, matches.size() - startPosition);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (startPosition + rowIndex + 1 > matches.size()) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return matches.get(startPosition+rowIndex).getHost().getName();
            case 1:
                return matches.get(startPosition+rowIndex).getHostGoals() + ":" + matches.get(startPosition+rowIndex).getAwayGoals();
            case 2:
                return matches.get(startPosition+rowIndex).getAway().getName();
            case 3:
                return new SimpleDateFormat("dd.MM.yyyy.").format(matches.get(startPosition+rowIndex).getDate());
            case 4:
                return matches.get(startPosition+rowIndex).getMatchType();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    private void setTColumnNames() {
        Locale locale = Controller.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_FrmViewSelection_" + locale);
        
        columnNames = new String[] {resourceBundle.getString("Host"),resourceBundle.getString("Result"),
        resourceBundle.getString("Away"),resourceBundle.getString("Date"),resourceBundle.getString("MatchType")};
    }

    public void change() {
    }

}
