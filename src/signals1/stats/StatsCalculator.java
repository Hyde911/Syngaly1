/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.stats;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public class StatsCalculator {

    public static SignalStats getStats(Complex[] input) {
        return new SignalStats(
                calcMeanValue(input),
                calcAbsoluteMeanValue(input),
                calcAveragePower(input),
                caclVariance(input),
                caclEffectivePower(input)
        );
    }

    public static double calcMeanValue(Complex[] input) {
        double mean = 0;
        for (int i = 0; i < input.length; i++) {
            mean += input[i].getReal();
        }
        return mean / (input.length + 1);
    }

    public static double calcAbsoluteMeanValue(Complex[] input) {
        double absMean = 0;
        for (int i = 0; i < input.length; i++) {
            absMean += Math.abs(input[i].getReal());
        }
        return absMean / (input.length + 1);
    }

    public static double calcAveragePower(Complex[] input) {
        double power = 0;
        for (int i = 0; i < input.length; i++) {
            power += input[i].getReal() * input[i].getReal();
        }
        return power / (input.length + 1);
    }

    public static double caclVariance(Complex[] input) {
        double mean = calcMeanValue(input);
        double variance = 0;
        for (int i = 0; i < input.length; i++) {
            variance += (input[i].getReal() - mean) * (input[i].getReal() - mean);
        }
        mean = variance / (input.length + 1);
        return mean;
    }

    public static double caclEffectivePower(Complex[] input) {
        return Math.sqrt(calcAveragePower(input));
    }
}
