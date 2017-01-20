/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import org.apache.commons.math3.complex.Complex;
import signals1.discreteSignals.DerivedSignal;
import signals1.operations.Correlation;

/**
 *
 * @author marr
 */
public class RadarSimulator {

    private final RadarParameters params;
    private final RadarSignalsGenerator signals;
    private RadarResponse response;
    
    public RadarSimulator (RadarParameters params){
        this.params = params;
        signals = new RadarSignalsGenerator(params);
    }
    
    public RadarResponse generateResponse (){
        if (response != null){
            return response;
        }
        
        DerivedSignal probingSignal = signals.getProbingSignal();
        DerivedSignal firstResposne = signals.getFirstResponse();
        DerivedSignal secondResponse = signals.getSecondResponse();
        DerivedSignal correlation1 = Correlation.CalculateCorrelation(signals.getProbingSignal(), signals.getFirstResponse());
        DerivedSignal correlation2 = Correlation.CalculateCorrelation(signals.getProbingSignal(), signals.getSecondResponse());
        
        double calculatedInitialDistance = calculateDistance(correlation1);
        double calculatedFinalDistance = calculateDistance(correlation2);
        double calculatedVelocity = (calculatedFinalDistance - calculatedInitialDistance) / params.getInterval();
        
        response = new RadarResponse(   probingSignal,
                                        firstResposne,
                                        secondResponse,
                                        correlation1,
                                        correlation2,
                                        calculatedVelocity,
                                        calculatedInitialDistance,
                                        calculatedFinalDistance);
        return response;
    }
    
    private double calculateDistance(DerivedSignal correlation){
        Complex[] values = correlation.getValues();
        int middle = values.length / 2;
        int shift = 0;
        double max = 0;
        for (int i = middle; i < values.length; i++){
            double tmp = values[i].getReal();
            if (tmp >= max){
                max = tmp;
                shift = i;
            }
        }
        return ((shift - middle) * 1.0 /  params.getSamplingRate()) *  params.getWaveSpeed() / 2;
    }
}
