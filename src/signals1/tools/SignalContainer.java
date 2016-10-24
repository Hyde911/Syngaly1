/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;


import java.util.HashMap;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;


public class SignalContainer extends HashMap{
    
    private static SignalContainer INSTANCE;

    public static SignalContainer getInstance() {
        if(INSTANCE == null){
            INSTANCE = new SignalContainer();
        }
        return INSTANCE;
    }
    
    public Complex[] getSignalOutput(int id){
        return get(id).getSignal();
    }
    
    public Signals get(int key) {
        return (Signals)get(key);
    }

}
