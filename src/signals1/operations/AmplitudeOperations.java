/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.operations.arithmetic.Addition;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.operations.arithmetic.ArithmeticOperator;
import signals1.operations.arithmetic.Division;
import signals1.operations.arithmetic.Multiplication;
import signals1.operations.arithmetic.Subtraction;
import signals1.discreteSignals.abstracts.ImpulseInterface;
import signals1.tools.exceptions.DivideByZeroValueExcpetion;
import signals1.tools.exceptions.NotSameSamplinRateExpcetion;

/**
 *
 * @author marr
 */
class AmplitudeOperations {

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
    private Class signalType;

    public AmplitudeOperations(DiscreteSignal signal1, DiscreteSignal signal2) throws NotSameSamplinRateExpcetion {
        if (signal1.getSamplingRate() != signal2.getSamplingRate()) {
            throw new NotSameSamplinRateExpcetion();
        }
        this.signal1 = signal1;
        this.signal2 = signal2;
        this.samplingRate = signal1.getSamplingRate();
        if (signal1 instanceof ImpulseInterface && signal2 instanceof ImpulseInterface) {
            signalType = ImpulseInterface.class;
        } else {
            signalType = DiscreteSignal.class;
        }
        setStartTime();
    }

    public DerivedSignal add() {
        doCalculation(new Addition());
        return new DerivedSignal(values, samplingRate, startTime, amplitude, signalType);
    }

    public DerivedSignal sub() {
        doCalculation(new Subtraction());
        return new DerivedSignal(values, samplingRate, startTime, amplitude, signalType);
    }

    public DerivedSignal mul() {
        doCalculation(new Multiplication());
        return new DerivedSignal(values, samplingRate, startTime, amplitude, signalType);
    }

    public DerivedSignal div() throws DivideByZeroValueExcpetion {
        doCalculation(new Division());
        for (Complex c : values) {
            if (Double.isNaN(c.getReal())) {
                throw new DivideByZeroValueExcpetion();
            }
        }
        return new DerivedSignal(values, samplingRate, startTime, amplitude, signalType);
    }

    private void doCalculation(ArithmeticOperator op) {
        int beginSingle = (int) (Math.abs(startTime1 - startTime2) * samplingRate);
        int n = 0;
        amplitude = 0;
        try {
            if (startTime1 < startTime2) {
                for (int i = 0; i < numberOfSamples; i++) {
                    values[i + beginSingle] = singleOperation(op, signal1.getValues()[i + beginSingle], (signal2.getValues()[n++]));
                    if (Math.abs(values[i + beginSingle].getReal()) > amplitude) {
                        amplitude = Math.abs(values[i + beginSingle].getReal());
                    }
                }
            } else if (startTime1 > startTime2) {
                for (int i = 0; i < numberOfSamples; i++) {
                    values[i + beginSingle] = singleOperation(op, (signal1.getValues()[n++]), signal2.getValues()[i + beginSingle]);
                    if (Math.abs(values[i + beginSingle].getReal()) > amplitude) {
                        amplitude = Math.abs(values[i + beginSingle].getReal());
                    }
                }
            } else {
                for (int i = 0; i < numberOfSamples; i++) {
                    values[i] = singleOperation(op, signal1.getValues()[i], (signal2.getValues()[i]));
                    if (Math.abs(values[i].getReal()) > amplitude) {
                        amplitude = Math.abs(values[i].getReal());
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
    }

    private Complex singleOperation(ArithmeticOperator op, Complex c1, Complex c2) {
        return op.getResult(c1, c2);
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
        this.endTime1 = startTime1 + (signal1.getValues().length * 1.0 / signal1.getSamplingRate());
        this.endTime2 = startTime2 + (signal2.getValues().length * 1.0 / signal2.getSamplingRate());
        if (endTime1 >= endTime2) {
            numberOfSamples = (int) ((endTime1 - this.startTime) * this.samplingRate);
        } else {
            numberOfSamples = (int) ((endTime2 - this.startTime) * this.samplingRate);
        }
        this.values = new Complex[numberOfSamples];
        fillValues();
    }

    private void fillValues() {
        Arrays.fill(values, Complex.ZERO);
        int k = (int) Math.abs(startTime1 - startTime2) * samplingRate;
        if (startTime1 < startTime2) {
            for (int i = 0; i < k; i++) {
                if (signal1.getValues().length > i && values.length > i) {
                    values[i] = signal1.getValues()[i];
                }
            }
        } else if (startTime2 < startTime1) {
            for (int i = 0; i < k; i++) {
                if (signal2.getValues().length > i && values.length > i) {
                    values[i] = signal2.getValues()[i];
                }
            }
        }
        k = ((int) Math.abs(endTime1 - endTime2) * samplingRate);
        int j = 0;
        if (endTime1 < endTime2) {
            for (int i = values.length - k; i < values.length; i++) {
                if (i - k >= 0 && i >= 0) {
                    values[i] = signal2.getValues()[signal2.getValues().length - k + j];
                    j++;
                }
            }
        } else if (endTime2 < endTime1) {
            for (int i = values.length - k; i < values.length; i++) {
                if (i - k >= 0 && i >= 0) {
                    values[i] = signal1.getValues()[signal1.getValues().length - k + j];
                    j++;
                }
            }
        }
    }
}
