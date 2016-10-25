/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.discrete;

import java.io.Serializable;
import static java.lang.Math.round;
import org.apache.commons.math3.complex.Complex;
import signals1.signals.abstracts.Signals;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public abstract class DescreetSignal implements Serializable{

    abstract Complex[] getValues();

    abstract int getSamplingRate();

    abstract double getStartTime();

    abstract SignalStats getStats();

    abstract int getDuration();
    
    abstract Histogram getHistogram(int numberOfIntervals);

}
