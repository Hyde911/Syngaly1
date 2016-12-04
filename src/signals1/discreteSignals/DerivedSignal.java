/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.discreteSignals;

import signals1.discreteSignals.abstracts.DiscreteSignal;
import java.io.Serializable;
import org.apache.commons.math3.complex.Complex;
import signals1.stats.Histogram;
import signals1.stats.HistogramCalculator;
import signals1.stats.StatsCalculator;

/**
 *
 * @author marr
 */
public class DerivedSignal extends DiscreteSignal implements Serializable {
    
    private Class type;

    public DerivedSignal(Complex[] values, int samplingRate, double startTime, double amplitude){
        this(values, samplingRate, startTime, amplitude, DiscreteSignal.class);
    }
    
    public DerivedSignal(Complex[] values, int samplingRate, double startTime, double amplitude, Class type) {
        super();
        this.fullName = "sygnał pochodny";
        this.samplingRate = samplingRate;
        this.startTime = startTime;
        this.amplitude = amplitude;
        this.values = values;
        this.duration = values.length / samplingRate;
        this.type = type;
        calculateStats();
    }

    @Override
    public Histogram getHistogram(int numberOfIntervals) {
        HistogramCalculator hisCalc = new HistogramCalculator(values);
        return hisCalc.getHistogram(numberOfIntervals);
    }

    private void calculateStats() {
        this.stats = StatsCalculator.getStats(values);
    }
    
    public Class getType(){
        return type;
    }
}
