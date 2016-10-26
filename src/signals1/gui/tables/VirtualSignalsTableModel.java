/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import signals1.signals.GaussianNoise;
import signals1.signals.abstracts.NoiseSignals;
import signals1.signals.abstracts.PeriodicSignals;
import signals1.signals.abstracts.Signals;
import signals1.signals.abstracts.SquareSignals;
import signals1.tools.SignalContainer;

/**
 *
 * @author marr
 */
public class VirtualSignalsTableModel extends DefaultTableModel {

    private String[] columnsNames = {"typ sygnału", "czas początkowy [s]", "czas trwania [s]", "amplituda", "okres [s]", "wypełnienie [%]"};
    private SignalContainer container = SignalContainer.getInstance();
    private int rowsNumber = 0;

    public VirtualSignalsTableModel(){
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
        Signals signal = container.get(rowIndex);
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
            case 5:
                return getFill(signal);
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    private Object getPeriod(Signals signal) {
        if (signal instanceof PeriodicSignals) {
            return ((PeriodicSignals) signal).getPeriod();
        }
        return null;
    }
    
    private Object getFill(Signals signal){
        if (signal instanceof SquareSignals){
            return ((SquareSignals) signal).getFillFactor();
        }
        return null;
    }
}
