/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.table;

import controller.Controller;
import domain.Selection;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;
import services.SystemDetails;

/**
 *
 * @author Veljko
 */
public class ModelTableRangList extends AbstractTableModel {

    List<Selection> selections;
    String[] columnNames;
    int startPosition;
    int tableSize;

    public ModelTableRangList(List<Selection> selections, int startPosition, int tableSize) {
        this.selections = selections;
        this.startPosition = startPosition;
        this.tableSize = tableSize;
        addColumnNames();

    }

    @Override
    public int getRowCount() {
        return Math.min(tableSize, selections.size() - startPosition);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (startPosition + rowIndex + 1 > selections.size()) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return startPosition + rowIndex + 1;
            case 1:
                return selections.get(startPosition + rowIndex).getName();
            case 2:
                return selections.get(startPosition + rowIndex).getPoints();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    private void addColumnNames() {
        Locale locale = Controller.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_FrmViewRangList_" + locale);
        columnNames = new String[]{resourceBundle.getString("rang"), resourceBundle.getString("selection"), resourceBundle.getString("points")};
    }

}
