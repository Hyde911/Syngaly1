/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.discreteSignals.abstracts;

import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.SignalStats;

/**
 *
 * @author glabg
 */
public interface ImpulseInterface {

    Complex[] getValues();

    int getSamplingRate();

    double getStartTime();

    SignalStats getStats();

    double getDuration();

    Histogram getHistogram(int numberOfIntervals);
}
