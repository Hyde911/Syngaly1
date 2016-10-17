/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals;

import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.SquareSignals;

/**
 *
 * @author marr
 */
public class SymetricSquareSignal extends SquareSignals{
    
    public SymetricSquareSignal(double startTime, int numberOfSamples, double amplitude, int duration, double period, int fillFactor) {
        super(startTime, numberOfSamples, amplitude, duration, period, fillFactor);
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        int period = 0;
        int sampleOfPeriod = 0;
        for (int i = 0; i< numberOfSamples; i++){
            if (i % samplesPerPeriod == 0 && i != 0){
                period++;
                sampleOfPeriod = 0;
            }
            if (sampleOfPeriod < samplesPerPeriod * fillFactor*0.01){
                this.result[i] = new Complex(amplitude , 0);
            }
            else{
                this.result[i] = new Complex(-amplitude, 0);
            }
            sampleOfPeriod++;
        }
    }
    
}
