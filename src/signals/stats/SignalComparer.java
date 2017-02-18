/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.stats;

import org.apache.commons.math3.complex.Complex;
import signals.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author marr
 */
public class SignalComparer {

    public static double CalculateMSE(DiscreteSignal signal1, DiscreteSignal signal2) {
        if (signal1.getSamplingRate() != signal2.getSamplingRate()) {
            return Double.NaN;
        }
        if (signal1.getStartTime() != signal2.getStartTime()) {
            return Double.NaN;
        }
        if (signal1.getDuration() != signal2.getDuration()) {
            return Double.NaN;
        }
        double result = 0;
        Complex[] val1 = signal1.getValues();
        Complex[] val2 = signal2.getValues();
        for (int i = 0; i < val1.length; i++) {
            result += (val1[i].getReal() - val2[i].getReal()) * (val1[i].getReal() - val2[i].getReal());
        }
        return result / val1.length;
    }

    public static double CalculateSNR(DiscreteSignal signal1, DiscreteSignal signal2) {
        if (signal1.getSamplingRate() != signal2.getSamplingRate()) {
            return Double.NaN;
        }
        if (signal1.getStartTime() != signal2.getStartTime()) {
            return Double.NaN;
        }
        if (signal1.getDuration() != signal2.getDuration()) {
            return Double.NaN;
        }
        double result = 0;
        for (Complex value : signal1.getValues()) {
            result += value.getReal() * value.getReal();
        }
        return 10 * Math.log10(result / CalculateMSE(signal1, signal2));
    }

    public static double CalculatePSNR(DiscreteSignal signal1, DiscreteSignal signal2) {
        if (signal1.getSamplingRate() != signal2.getSamplingRate()) {
            return Double.NaN;
        }
        if (signal1.getStartTime() != signal2.getStartTime()) {
            return Double.NaN;
        }
        if (signal1.getDuration() != signal2.getDuration()) {
            return Double.NaN;
        }
        double max = 0;
        for (Complex value : signal1.getValues()) {
            if (value.getReal() > max) {
                max = value.getReal();
            }
        }
        return 10 * Math.log10(max / CalculateMSE(signal1, signal2));
    }

    public static double CalculateMD(DiscreteSignal signal1, DiscreteSignal signal2) {
        if (signal1.getSamplingRate() != signal2.getSamplingRate()) {
            return Double.NaN;
        }
        if (signal1.getStartTime() != signal2.getStartTime()) {
            return Double.NaN;
        }
        if (signal1.getDuration() != signal2.getDuration()) {
            return Double.NaN;
        }
        Complex[] val1 = signal1.getValues();
        Complex[] val2 = signal2.getValues();
        double max = 0;
        for (int i = 0; i < val1.length; i++) {
            double tmp = Math.abs(val1[i].getReal() - val2[i].getReal());
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
