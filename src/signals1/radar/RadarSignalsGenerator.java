/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import java.util.Arrays;
import signals1.continuousSignals.SineSignal;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.PeriodicDiscreteSignal;
import signals1.operations.AmplitudeCalculator;
import signals1.tools.exceptions.NotSameSamplinRateExpcetion;
import signals1.tools.quantisation.NoneQuantizer;

/**
 *
 * @author marr
 */
public class RadarSignalsGenerator {

    private DerivedSignal radarSignal;
    private DerivedSignal probingSignal;
    private final int samplesPerProbe;
    private final double probingDuration;

    public RadarSignalsGenerator(double period1, double period2, int samplingRate, double probingDuration) {
        generateRadarSignal(period1, period2, samplingRate, probingDuration);
        samplesPerProbe = (int)(samplingRate * probingDuration);
        this.probingDuration = probingDuration;
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
        probingSignal = new DerivedSignal(Arrays.copyOf(radarSignal.getValues(), samplesPerProbe), samplingRate, 0, radarSignal.getAmplitude());
    }

    public DerivedSignal getResponseSignal(int startSample){
        int startPosition = startSample % (samplesPerProbe * 2);
        return new DerivedSignal(Arrays.copyOfRange(radarSignal.getValues(), startPosition, samplesPerProbe), radarSignal.getSamplingRate(), 0, radarSignal.getAmplitude());
    }

    public DerivedSignal getRadarSignal() {
        return radarSignal;
    }

    public int getSamplesPerProbe() {
        return samplesPerProbe;
    }

    public DerivedSignal getProbingSignal() {
        return probingSignal;
    }

    public double getProbingDuration() {
        return probingDuration;
    }
}
