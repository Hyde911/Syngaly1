/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.continuousSignals.zadanie4;

import org.apache.commons.math3.complex.Complex;
import signals.continuousSignals.abstracts.SineLikeSignals;

/**
 *
 * @author glabg
 */
public class S3 extends SineLikeSignals {

    public S3(double startTime, double amplitude, double duration, double period, double phaseShift) {
        super(startTime, amplitude, duration, period, phaseShift);
        this.fullName = "S3";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        double value = 0d;
        for (int i = 0; i < numberOfSamples; i++) {
            double temp = ((2d * Math.PI) / samplesPerPeriod) * i;
            value = 5d * Math.sin(((2d * Math.PI) / 2d * temp) + phaseShift) + Math.sin(((2d * Math.PI / 0.25) * temp) + phaseShift);
            this.result[i] = new Complex(value, 0d);
            //double temp = ((2 * Math.PI) / samplesPerPeriod) * (i);
            //this.result[i] = new Complex(Math.sin(temp + phaseShift), 0);
        }
    }
}
