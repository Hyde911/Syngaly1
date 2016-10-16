/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.stats;

import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;

/**
 *
 * @author marr
 */
public class StatsCalculator {

    private Complex[] result;
    private int numberOfSamples;

    public SignalStats getStats(Signals signal) {
        this.result = signal.getSignal();
        this.numberOfSamples = signal.getNumberOfSamples();
        
        return new SignalStats(
                calcMeanValue(),
                calcAbsoluteMeanValue(),
                calcAveragePower(),
                caclVariance(),
                caclEffectivePower()
        );
    }

    private double calcMeanValue() {
        double mean = 0;
        for (int i = 0; i < numberOfSamples; i++) {
            mean += result[i].getReal();
        }
        return mean / (numberOfSamples + 1);
    }

    private double calcAbsoluteMeanValue() {
        double absMean = 0;
        for (int i = 0; i < numberOfSamples; i++) {
            absMean += Math.abs(result[i].getReal());
        }
        return absMean / (numberOfSamples + 1);
    }

    private double calcAveragePower() {
        double power = 0;
        for (int i = 0; i < numberOfSamples; i++) {
            power += result[i].getReal() * result[i].getReal();
        }
        return power / (numberOfSamples + 1);
    }

    private double caclVariance() {
        double mean = calcMeanValue();
        double variance = 0;
        for (int i = 0; i < numberOfSamples; i++) {
            variance += (result[i].getReal() - mean) * (result[i].getReal() - mean) ;
        }
        mean = variance / (numberOfSamples + 1);
        return mean;
    }

    private double caclEffectivePower() {
        return Math.sqrt(calcAveragePower());
    }
}
