/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals;

import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.NoiseSignals;

/**
 *
 * @author marr
 */
public class StrokeSignal extends NoiseSignals {

    private double strokeTime;

    public StrokeSignal(double startTime, double amplitude, double duration, double strokeTime) {
        super(startTime, amplitude, duration);
        this.strokeTime = strokeTime;
        if (strokeTime > duration - startTime){
            this.strokeTime = duration;
        }else if(strokeTime < startTime){
            this.strokeTime = startTime;
        }
        this.fullName = "skok jednostkowy";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        for (int i = 0; i < numberOfSamples; i++) {
            if (i < (strokeTime - startTime) * this.samplesPerSecond){
                result[i] = Complex.ZERO;
            }else{
                result[i] = new Complex(amplitude);
            }
        }
    }

}
