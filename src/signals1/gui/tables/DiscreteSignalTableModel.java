/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui.tables;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import signals1.signals.discrete.DiscreteSignal;
import signals1.signals.discrete.PeriodicDiscreteSignal;
import signals1.tools.DiscretetSignalsContainer;

/**
 *
 * @author marr
 */
public class DiscreteSignalTableModel extends DefaultTableModel {

    private String[] columnsNames = {"typ sygnału", "czas początkowy [s]", "czas trwania [s]", "amplituda", "okres [s]"};
    private DiscretetSignalsContainer container = DiscretetSignalsContainer.getInstance();
    private int rowsNumber = 0;

    public DiscreteSignalTableModel() {
        addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                rowsNumber = container.size();
            }
        });
    }

    @Override
    public int getRowCount() {
        return rowsNumber;
    }

    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnsNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DiscreteSignal signal = container.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return signal.getFullName();
            case 1:
                return signal.getStartTime();
            case 2:
                return signal.getDuration();
            case 3:
                return signal.getAmplitude();
            case 4:
                return getPeriod(signal);
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    private Object getPeriod(DiscreteSignal signal) {
        if (signal instanceof PeriodicDiscreteSignal) {
            return ((PeriodicDiscreteSignal) signal).getPeriod();
        }
        return null;
    }
}
