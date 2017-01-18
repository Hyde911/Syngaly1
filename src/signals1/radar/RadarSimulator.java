/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import signals1.discreteSignals.DerivedSignal;
import signals1.operations.Correlation;
import signals1.tools.RadarParameters;

/**
 *
 * @author marr
 */
public class RadarSimulator {

    private final RadarParameters params;
    private RadarSignalsGenerator signals;
    
    public RadarSimulator (RadarParameters params){
        this.params = params;
        signals = new RadarSignalsGenerator(params);
    }
    
    public RadarResponse generateResponse (double distance, double velocity){
        DerivedSignal probingSignal = signals.getProbingSignal();
        DerivedSignal responseSignal1 = signals.getResponseSignal((int)(distance / params.getWaveSpeed()));
        DerivedSignal responseSignal2 = signals.getResponseSignal((int)(distance + params.getInterval() * velocity / params.getWaveSpeed()));        
        return new RadarResponse(probingSignal, responseSignal1, responseSignal2, distance, velocity, velocity);
    }
    
    public RadarResponseAnalysis ProcessRadarResponse (RadarResponse response){
        DerivedSignal correlation1 = Correlation.CalculateCorrelation(response.getProbingSignal(), response.getFirstResponse());
        DerivedSignal correlation2= Correlation.CalculateCorrelation(response.getProbingSignal(), response.getSecondRespone());
        return new RadarResponseAnalysis(correlation1, correlation2, 0, 0);
    }
}
