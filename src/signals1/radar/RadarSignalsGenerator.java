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
import signals1.tools.exceptions.NotSameSamplinRateExpcetion;
import signals1.tools.quantisation.NoneQuantizer;

/**
 *
 * @author marr
 */
public class RadarSignalsGenerator {

    private final DerivedSignal radarSignal;
    private final DerivedSignal probingSignal;
    private final DerivedSignal firstResponse;
    private final DerivedSignal secondResponse;
    private final int samplesPerProbe;
    private final double amplitude = 1;
    private final RadarParameters params;

    public RadarSignalsGenerator(RadarParameters params) {
        this.params = params;
        samplesPerProbe = (int) (params.getSamplingRate() * params.getBuforLength());
        radarSignal = generateRadarSignal();
        probingSignal = generateProbingSignal();
        firstResponse = getResponseSignal(getSamplesShiftFromDistance(params.getInitialDistance()));
        secondResponse = getResponseSignal(getSamplesShiftFromDistance(params.getInitialDistance() + (params.getInterval() * params.getVelocity())));
    }

    public int getSamplesPerProbe() {
        return samplesPerProbe;
    }

    public DerivedSignal getProbingSignal() {
        return probingSignal;
    }

    public DerivedSignal getFirstResponse() {
        return firstResponse;
    }

    public DerivedSignal getSecondResponse() {
        return secondResponse;
    }

    private DerivedSignal generateRadarSignal() {
        double duration = getDuration();
        SineSignal signal1 = new SineSignal(0, amplitude, duration, params.getFirstCompomentPeriod(), 1);
        SineSignal signal2 = new SineSignal(0, amplitude, duration, params.getSecondCompomentPeriod(), 1);
        PeriodicDiscreteSignal disSignal1 = new PeriodicDiscreteSignal(signal1, params.getSamplingRate(), new NoneQuantizer());
        PeriodicDiscreteSignal disSignal2 = new PeriodicDiscreteSignal(signal2, params.getSamplingRate(), new NoneQuantizer());
        try {
            return AmplitudeCalculator.AddSignals(disSignal1, disSignal2);
        } catch (NotSameSamplinRateExpcetion ex) {
            return null;
        }
    }

    private double getDuration() {
        int initialShift = getSamplesShiftFromDistance(params.getInitialDistance());
        int additionaShift = getSamplesShiftFromDistance(Math.abs(params.getVelocity()) * params.getInterval());
        return (initialShift + additionaShift + samplesPerProbe) * 1.5 / params.getSamplingRate();
    }

    private int getSamplesShiftFromDistance(double distance) {
        double time = (distance * 2) / params.getWaveSpeed();
        return (int) (time * params.getSamplingRate());
    }

    private DerivedSignal generateProbingSignal() {
        return new DerivedSignal(Arrays.copyOf(radarSignal.getValues(), samplesPerProbe), params.getSamplingRate(), 0, amplitude);
    }

    private DerivedSignal getResponseSignal(int shift) {
        return new DerivedSignal(Arrays.copyOfRange(radarSignal.getValues(), shift, shift + samplesPerProbe), radarSignal.getSamplingRate(), 0, radarSignal.getAmplitude());
    }
}
