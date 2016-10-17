/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class SignalContainer {

    private Signals signal;
    
    public SignalContainer(Signals signal){
        this.signal = signal;
    }
    
    public SignalStats getStats(){
        return signal.getStats();
    }
    
    public Complex[] getSignalOutput(){
        return signal.getSignal();
    }
    

}
