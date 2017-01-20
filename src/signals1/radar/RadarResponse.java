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
    
    private final DerivedSignal probingSignal;
    private final DerivedSignal firstResponse;
    private final DerivedSignal secondRespone;
    private final DerivedSignal correlation1;
    private final DerivedSignal correlation2;    
    private final double calculatedVelocity;
    private final double calculatedInitialDistance;
    private final double calculateFinalDistance;

    public RadarResponse(DerivedSignal probingSignal, DerivedSignal firstResponse, DerivedSignal secondRespone, DerivedSignal correlation1, DerivedSignal correlation2, double calculatedVelocity, double calculatedInitialDistance, double calculateFinalDistance) {
        this.probingSignal = probingSignal;
        this.firstResponse = firstResponse;
        this.secondRespone = secondRespone;
        this.correlation1 = correlation1;
        this.correlation2 = correlation2;
        this.calculatedVelocity = calculatedVelocity;
        this.calculatedInitialDistance = calculatedInitialDistance;
        this.calculateFinalDistance = calculateFinalDistance;
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

    public double getCalculateFinalDistance() {
        return calculateFinalDistance;
    }
    
    
}
