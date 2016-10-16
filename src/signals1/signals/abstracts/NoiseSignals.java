/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

/**
 *
 * @author marr
 */
public abstract class NoiseSignals extends Signals{
    
    public NoiseSignals(double startTime, int numberOfSamples, double amplitude, int duration) {
        super(startTime, numberOfSamples, amplitude, duration);
    }
    
    
}
