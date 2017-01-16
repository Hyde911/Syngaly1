/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import java.util.logging.Level;
import java.util.logging.Logger;
import signals1.continuousSignals.SineSignal;
import signals1.continuousSignals.abstracts.PeriodicSignals;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.PeriodicDiscreteSignal;
import signals1.operations.AmplitudeCalculator;
import signals1.tools.exceptions.NotSameSamplinRateExpcetion;
import signals1.tools.quantisation.NoneQuantizer;

/**
 *
 * @author marr
 */
class RadarSignalsGenerator {

    private DerivedSignal radarSignal;

    public RadarSignalsGenerator(double period1, double period2, int samplingRate, double probingDuration) {
        generateRadarSignal(period1, period2, samplingRate, probingDuration);
    }

    private void generateRadarSignal(double period1, double period2, int samplingRate, double probingDuration) {
        double duration = probingDuration * 2;
        SineSignal signal1 = new SineSignal(0, 1, duration, period1);
        SineSignal signal2 = new SineSignal(0, 1, duration, period2);
        PeriodicDiscreteSignal disSignal1 = new PeriodicDiscreteSignal(signal1, samplingRate, new NoneQuantizer());
        PeriodicDiscreteSignal disSignal2 = new PeriodicDiscreteSignal(signal2, samplingRate, new NoneQuantizer());
        try {
            radarSignal = AmplitudeCalculator.AddSignals(disSignal1, disSignal2);
        } catch (NotSameSamplinRateExpcetion ex) {

        }
    }

    public void setRadarSignal(DerivedSignal radarSignal) {
        this.radarSignal = radarSignal;
    }
}
