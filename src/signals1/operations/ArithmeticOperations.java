/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.discrete.DerivedSignal;
import signals1.signals.discrete.DiscreteSignal;

/**
 *
 * @author marr
 */
public class ArithmeticOperations {

    private double amplitude;
    private Complex[] values;
    private int samplingRate;
    private int numberOfSamples;
    private double startTime;
    private DiscreteSignal signal1;
    private DiscreteSignal signal2;
    private double startTime1;
    private double startTime2;
    private double endTime1;
    private double endTime2;

    public ArithmeticOperations(DiscreteSignal signal1, DiscreteSignal signal2) throws NotSameSamplinRateExpcetion {
        if (signal1.getSamplingRate() != signal2.getSamplingRate()) {
            throw new NotSameSamplinRateExpcetion();
        }
        this.signal1 = signal1;
        this.signal2 = signal2;
        this.samplingRate = signal1.getSamplingRate();
        setStartTime();
    }

    public DerivedSignal add() {
        int beginSingle = (int) Math.abs(startTime1 - startTime2) * samplingRate;
        int n = 0;
        try {
            for (int i = 0; i < numberOfSamples; i++) {
                if (startTime1 < startTime2) {
                    values[i] = signal1.getValues()[i + beginSingle].add(signal2.getValues()[n++]);
                } else if (startTime1 > startTime2) {
                    values[i] = signal2.getValues()[i + beginSingle].add(signal1.getValues()[n++]);
                } else {
                    values[i] = signal2.getValues()[i].add(signal1.getValues()[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return new DerivedSignal(values, samplingRate, startTime, 0);
    }

    private void setStartTime() {
        if (signal1.getStartTime() > signal2.getStartTime()) {
            this.startTime = signal2.getStartTime();
        } else if (signal1.getStartTime() < signal2.getStartTime()) {
            this.startTime = signal1.getStartTime();
        } else {
            this.startTime = signal1.getStartTime();
        }
        setNumberOfSamples();
    }

    private void setNumberOfSamples() {
        this.startTime1 = signal1.getStartTime();
        this.startTime2 = signal2.getStartTime();
        this.endTime1 = startTime1 + (signal1.getValues().length / signal1.getSamplingRate());
        this.endTime2 = startTime1 + (signal2.getValues().length / signal2.getSamplingRate());
        if (endTime1 >= endTime2) {
            numberOfSamples = (int) (endTime1 - this.startTime) * this.samplingRate;
        } else {
            numberOfSamples = (int) (endTime2 - this.startTime) * this.samplingRate;
        }
        this.values = new Complex[numberOfSamples];
        Arrays.fill(values, Complex.ZERO);
    }

    public class NotSameSamplinRateExpcetion extends Exception {

    }
}
