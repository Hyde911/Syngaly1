/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.NoiseSignals;
import signals1.signals.abstracts.SineLikeSignals;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class SignalContainer {

    private SineLikeSignals sineSignal;
    private NoiseSignals noiseSignal;
    private String signal = "";
    private StatsCalculator statCalc = new StatsCalculator();
    
    public SignalContainer(SineLikeSignals signal){
        this.sineSignal = signal;
        this.signal = "sine";
    }
    
    public SignalContainer(NoiseSignals signal){
        this.noiseSignal = signal;
        this.signal = "noise";
    }
    
    public SignalStats getStats(){
        switch (signal){
            case "sine" : return statCalc.getStats(sineSignal);
            case "noise": return statCalc.getStats(noiseSignal);
            default: return null;
        }
    }
    
    public Complex[] getSignalOutput(){
                switch (signal){
            case "sine" : return sineSignal.getSignal();
            case "noise": return noiseSignal.getSignal();
            default: return null;
        }
    }
    

}
