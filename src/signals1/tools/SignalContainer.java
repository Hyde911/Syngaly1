/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;


import java.util.HashMap;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;
import signals1.stats.SignalStats;


public class SignalContainer extends HashMap{
    
    public SignalStats getStats(int id){
        return ((Signals)get(id)).getStats();
    }
    
    public Complex[] getSignalOutput(int id){
        return ((Signals)get(id)).getSignal();
    }
    

}
