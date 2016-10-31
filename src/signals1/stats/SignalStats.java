/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.stats;

import java.io.Serializable;

/**
 *
 * @author marr
 */
public class SignalStats implements Serializable{
    
    private double meanValue;
    private double absoluteMeanValue;
    private double averagePower;
    private double variance;
    private double effectivePower;

    public SignalStats(double meanValue, double absoluteMeanValue, double averagePower, double variance, double effectivePower) {
        this.meanValue = meanValue;
        this.absoluteMeanValue = absoluteMeanValue;
        this.averagePower = averagePower;
        this.variance = variance;
        this.effectivePower = effectivePower;
    }

    public double getMeanValue() {
        return meanValue;
    }

    public double getAbsoluteMeanValue() {
        return absoluteMeanValue;
    }

    public double getAveragePower() {
        return averagePower;
    }

    public double getVariance() {
        return variance;
    }

    public double getEffectivePower() {
        return effectivePower;
    }
    
    
    
}
