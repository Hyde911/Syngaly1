/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools.quantisation;

import java.io.Serializable;
import org.apache.commons.math3.complex.Complex;
import signals1.tools.constatns.QuantizationTables;

/**
 *
 * @author marr
 */
public abstract class Quantizer implements Serializable {

    protected int bitsNumber;
    protected double step;
    protected double[] stepsTable;

    public Quantizer(int bitsNumber) {
        this.bitsNumber = bitsNumber;
        step = 1.0 / Math.pow(2, bitsNumber);
        switch (bitsNumber) {
            case 1:
                stepsTable = QuantizationTables.ONE;
                break;
            case 2:
                stepsTable = QuantizationTables.TWO;
                break;
            case 4:
                stepsTable = QuantizationTables.FOUR;
                break;
            case 6:
                stepsTable = QuantizationTables.SIX;
                break;
            case 8:
                stepsTable = QuantizationTables.EIGHT;
                break;
            case 12:
                stepsTable = QuantizationTables.TWELVE;
                break;
            default:
                stepsTable = QuantizationTables.SIXTEEN;
                break;
        }
    }

    public abstract Complex quantizeSample(Complex value, double amplitude);

    protected int getInterval(double value) {
        return (int) (value / step);
    }
}
