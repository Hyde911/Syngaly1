/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.continuousSignals;

import org.apache.commons.math3.complex.Complex;
import signals1.continuousSignals.abstracts.SquareSignals;

/**
 *
 * @author marr
 */
public class SymetricSquareSignal extends SquareSignals {

    public SymetricSquareSignal(double startTime, double amplitude, double duration, double period, int fillFactor) {
        super(startTime, amplitude, duration, period, fillFactor);
        this.fullName = "prostokątny symetryczny";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        int period = 0;
        int sampleOfPeriod = 0;
        for (int i = 0; i < numberOfSamples; i++) {
            if (i % samplesPerPeriod == 0 && i != 0) {
                period++;
                sampleOfPeriod = 0;
            }
            if (sampleOfPeriod < samplesPerPeriod * fillFactor * 0.01) {
                this.result[i] = new Complex(1, 0);
            } else {
                this.result[i] = new Complex(-1, 0);
            }
            sampleOfPeriod++;
        }
    }
}
