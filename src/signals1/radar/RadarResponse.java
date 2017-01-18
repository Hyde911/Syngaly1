/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import signals1.discreteSignals.DerivedSignal;

/**
 *
 * @author marr
 */
public class RadarResponse {
    
    DerivedSignal probingSignal;
    DerivedSignal firstResponse;
    DerivedSignal secondRespone;
    double timeInterval;
    double waveSpeed;
    double samplingRate;

    public RadarResponse(DerivedSignal probingSignal, DerivedSignal firstResponse, DerivedSignal secondRespone, double timeInterval, double waveSpeed, double samplingRate) {
        this.probingSignal = probingSignal;
        this.firstResponse = firstResponse;
        this.secondRespone = secondRespone;
        this.timeInterval = timeInterval;
        this.waveSpeed = waveSpeed;
        this.samplingRate = samplingRate;
    }

    public double getSamplingRate() {
        return samplingRate;
    }

    public DerivedSignal getProbingSignal() {
        return probingSignal;
    }

    public DerivedSignal getFirstResponse() {
        return firstResponse;
    }

    public DerivedSignal getSecondRespone() {
        return secondRespone;
    }

    public double getTimeInterval() {
        return timeInterval;
    }

    public double getWaveSpeed() {
        return waveSpeed;
    }
}
