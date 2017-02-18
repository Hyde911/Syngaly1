/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.continuousSignals.abstracts;

/**
 *
 * @author marr
 */
public abstract class NonPeriodicSignals extends AbstractSignal {

    public NonPeriodicSignals(double startTime, double amplitude, double duration) {
        super(startTime, amplitude, duration);
    }
}
