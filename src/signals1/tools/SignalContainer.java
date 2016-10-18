/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class SignalContainer {

    private Signals current;
    private List<Signals> signalConainer = new ArrayList<Signals>();
    
    public SignalContainer(Signals signal){
        this.current = signal;
        signalConainer.add(signal);
    }
    
    public SignalStats getStats(){
        return current.getStats();
    }
    
    public Complex[] getSignalOutput(){
        return current.getSignal();
    }
    

}
