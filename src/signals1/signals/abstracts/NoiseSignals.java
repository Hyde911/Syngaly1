/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import java.io.Serializable;
import signals1.stats.SignalStats;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public abstract class NoiseSignals extends Signals implements Serializable{

    public NoiseSignals(double startTime, double amplitude, int duration) {
        super(startTime, amplitude, duration);
    }
   
//    @Override
//    protected void calculateStats(){
//        this.stats = StatsCalculator.getStats(result);
//    }
}
