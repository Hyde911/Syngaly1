/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.continuousSignals.SineSignal;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.PeriodicDiscreteSignal;
import signals1.operations.AmplitudeCalculator;
import signals1.tools.RadarParameters;
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
    private final double amplitude = 1;
    private final RadarParameters params;

    public RadarSignalsGenerator(RadarParameters params) {
        this.params = params;
        samplesPerProbe = (int) (params.getSamplingRate() * params.getBuforLength()) / 1000;
        generateRadarSignal();
        
    }

    private void generateRadarSignal() {
        double duration = (params.getBuforLength() * 2)/1000;
        SineSignal signal1 = new SineSignal(0, amplitude, duration, params.getFirstCompomentPeriod() / 1000);
        SineSignal signal2 = new SineSignal(0, amplitude, duration, params.getSecondCompomentPeriod() / 1000);
        PeriodicDiscreteSignal disSignal1 = new PeriodicDiscreteSignal(signal1, params.getSamplingRate(), new NoneQuantizer());
        PeriodicDiscreteSignal disSignal2 = new PeriodicDiscreteSignal(signal2, params.getSamplingRate(), new NoneQuantizer());
        try {
            radarSignal = AmplitudeCalculator.AddSignals(disSignal1, disSignal2);
        } catch (NotSameSamplinRateExpcetion ex) {

        }
        Complex []tmp = Arrays.copyOf(radarSignal.getValues(), samplesPerProbe);
        probingSignal = new DerivedSignal(Arrays.copyOf(radarSignal.getValues(), samplesPerProbe), params.getSamplingRate(), 0, amplitude);
    }

    public DerivedSignal getResponseSignal(int startSample) {
        int startPosition = startSample % (samplesPerProbe * 2);
        return new DerivedSignal(Arrays.copyOfRange(radarSignal.getValues(), startPosition, startPosition + samplesPerProbe), radarSignal.getSamplingRate(), 0, radarSignal.getAmplitude());
    }

    public int getSamplesPerProbe() {
        return samplesPerProbe;
    }

    public DerivedSignal getProbingSignal() {
        return probingSignal;
    }
}
