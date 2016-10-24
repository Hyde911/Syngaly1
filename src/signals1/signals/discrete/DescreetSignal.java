/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author glabg
 */
public class DescreetSignal {
    
    private Complex[] values;
    private int samplingRate;
    private double startTime;

    public DescreetSignal(Complex[] values, int samplingRate, double startTime) {
        this.values = values;
        this.samplingRate = samplingRate;
        this.startTime = startTime;
    }

    public Complex[] getValues() {
        return values;
    }

    public int getSamplingRate() {
        return samplingRate;
    }

    public double getStartTime() {
        return startTime;
    }
   
}
