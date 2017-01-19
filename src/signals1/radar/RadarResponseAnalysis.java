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
public class RadarResponseAnalysis {
    DerivedSignal correlation1;
    DerivedSignal correlation2;
    double calculatedVelocity;
    double calculatedInitialDistance;
    double calculatedFinalDistance;

    public RadarResponseAnalysis(DerivedSignal correlation1, DerivedSignal correlation2, double calculatedVelocity, double calculatedInitialDistance, double calculatedFinalDistance) {
        this.correlation1 = correlation1;
        this.correlation2 = correlation2;
        this.calculatedVelocity = calculatedVelocity;
        this.calculatedInitialDistance = calculatedInitialDistance;
        this.calculatedFinalDistance = calculatedFinalDistance;
    }

    public DerivedSignal getCorrelation1() {
        return correlation1;
    }

    public DerivedSignal getCorrelation2() {
        return correlation2;
    }

    public double getCalculatedVelocity() {
        return calculatedVelocity;
    }

    public double getCalculatedInitialDistance() {
        return calculatedInitialDistance;
    }

    public double getCalculatedFinalDistance() {
        return calculatedFinalDistance;
    }

}
