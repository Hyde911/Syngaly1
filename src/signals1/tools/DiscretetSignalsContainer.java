/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import java.util.ArrayList;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author glabg
 */
public class DiscretetSignalsContainer extends ArrayList<DiscreteSignal>{
    
    private static DiscretetSignalsContainer INSTANCE;

    private DiscretetSignalsContainer(){}
    
    public static DiscretetSignalsContainer getInstance() {
        if(INSTANCE == null){
            INSTANCE = new DiscretetSignalsContainer();
        }
        return INSTANCE;
    }
    
    public DiscreteSignal getById(int id) {
        if (id < 1) {
            return null;
        }
        for (DiscreteSignal s : this){
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
}

