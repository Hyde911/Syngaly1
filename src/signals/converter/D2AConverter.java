/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.converter;

import signals.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author glabg
 */
public interface D2AConverter {

    public DiscreteSignal convert(DiscreteSignal input, int samplingRate);

}
