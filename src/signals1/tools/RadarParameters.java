/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

/**
 *
 * @author marr
 */
public class RadarParameters {
    private final double firstCompomentPeriod;
    private final double secondCompomentPeriod;
    private final int samplingRate;
    private final double buforLength;
    private final double initial;
    private final double velocity;
    private final double interval;

    public RadarParameters(double firstCompomentPeriod, double secondCompomentPeriod, int samplingRate, double buforLength, double initial, double velocity, double interval) {
        this.firstCompomentPeriod = firstCompomentPeriod;
        this.secondCompomentPeriod = secondCompomentPeriod;
        this.samplingRate = samplingRate;
        this.buforLength = buforLength;
        this.initial = initial;
        this.velocity = velocity;
        this.interval = interval;
    }

    public double getFirstCompomentPeriod() {
        return firstCompomentPeriod;
    }

    public double getSecondCompomentPeriod() {
        return secondCompomentPeriod;
    }

    public int getSamplingRate() {
        return samplingRate;
    }

    public double getBuforLength() {
        return buforLength;
    }

    public double getInitial() {
        return initial;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getInterval() {
        return interval;
    }
            
}
