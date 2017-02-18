/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.radar;

/**
 *
 * @author marr
 */
public class RadarParameters {

    private final double firstCompomentPeriod;
    private final double secondCompomentPeriod;
    private final int samplingRate;
    private final double buforLength;
    private final double initialDistance;
    private final double velocity;
    private final double interval;
    private final double waveSpeed;

    public RadarParameters(double firstCompomentPeriod, double secondCompomentPeriod, int samplingRate, double buforLength, double initialDistance, double velocity, double interval, double waveSpeed) {
        this.firstCompomentPeriod = firstCompomentPeriod;
        this.secondCompomentPeriod = secondCompomentPeriod;
        this.samplingRate = samplingRate;
        this.buforLength = buforLength;
        this.initialDistance = initialDistance;
        this.velocity = velocity;
        this.interval = interval;
        this.waveSpeed = waveSpeed;
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

    public double getVelocity() {
        return velocity;
    }

    public double getInterval() {
        return interval;
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    public double getWaveSpeed() {
        return waveSpeed;
    }

}
