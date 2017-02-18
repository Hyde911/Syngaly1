/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.continuousSignals.zadanie4;

import org.apache.commons.math3.complex.Complex;
import signals1.continuousSignals.abstracts.SineLikeSignals;

/**
 *
 * @author glabg
 */
public class S1 extends SineLikeSignals {

    public S1(double startTime, double amplitude, double duration, double period, double phaseShift) {
        super(startTime, amplitude, duration, period, phaseShift);
        this.fullName = "S1";
    }

    @Override
    protected void generateSignal() {
        this.result = new Complex[numberOfSamples];
        double value = 0d;
        for (int i = 0; i < numberOfSamples; i++) {
            double temp = ((2d * Math.PI) / samplesPerPeriod) * i;
            value = 2d * Math.sin((((2d * Math.PI) / 2d * temp) * Math.PI / 2d) + phaseShift) + 5d * Math.sin((((2d * Math.PI / 0.5) * temp) * Math.PI / 2d) + phaseShift);
            //value = 2d*Math.sin(((2d*Math.PI)/2d * i) + Math.PI/2d) + 5d*Math.sin(((2d*Math.PI/0.5) * i) + Math.PI/2d);

            this.result[i] = new Complex(value, 0d);
            //double temp = ((2 * Math.PI) / samplesPerPeriod) * (i);
            //this.result[i] = new Complex(Math.sin(temp + phaseShift), 0);
        }
    }

}
