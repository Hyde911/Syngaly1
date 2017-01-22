/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singals.fourier;

import org.apache.commons.math3.complex.Complex;
import org.junit.Assert;
import org.junit.Test;
import signals1.continuousSignals.SineSignal;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.PeriodicDiscreteSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.fourier.DefinitionFourierTransform;
import signals1.fourier.FFT;
import signals1.fourier.FastFourierTransform;
import signals1.operations.AmplitudeCalculator;
import signals1.tools.quantisation.NoneQuantizer;

/**
 *
 * @author marr
 */
public class FourierTransformTests {

    private final Complex[] signalData;
    private final Complex[] transformateData;

    public FourierTransformTests() throws Exception {
        SineSignal signal1 = new SineSignal(0, 1, 1, 0.5);
        SineSignal signal2 = new SineSignal(0, 2, 1, 0.06);
        SineSignal signal3 = new SineSignal(0, 4, 1, 0.9);
        PeriodicDiscreteSignal disSignal1 = new PeriodicDiscreteSignal(signal1, 8192, new NoneQuantizer());
        PeriodicDiscreteSignal disSignal2 = new PeriodicDiscreteSignal(signal2, 8192, new NoneQuantizer());
        PeriodicDiscreteSignal disSignal3 = new PeriodicDiscreteSignal(signal3, 8192, new NoneQuantizer());
        DerivedSignal signal;
        try {
            signal = AmplitudeCalculator.AddSignals(disSignal1, disSignal2);
            signal = AmplitudeCalculator.AddSignals(signal, disSignal3);
            signalData = signal.getValues();
        } catch (Exception ex) {
            throw ex;
        }
        transformateData = FFT.fft(signalData);
    }

    @Test
    public void externalLibraryTest() {
        Complex[] transform = FFT.fft(signalData);
        Complex[] reverse = FFT.ifft(transform);
        compareComplexArrays(signalData, reverse);
    }

    @Test
    public void definitionTransformTest() {
        Complex[] transform = DefinitionFourierTransform.transform(signalData);
        compareComplexArrays(transformateData, transform);
    }

    @Test
    public void definitionInvTransormTest() {
        Complex[] reverse = DefinitionFourierTransform.invTransform(transformateData);
        compareComplexArrays(signalData, reverse);
    }

    @Test
    public void fftTest() {
        Complex[] transform = FastFourierTransform.ffs(signalData);
        compareComplexArrays(transformateData, transform);
    }

    @Test
    public void ifftTest() {
        Complex[] reverse = FastFourierTransform.iffs(transformateData);
        compareComplexArrays(signalData, reverse);
    }

    private void compareComplexArrays(Complex[] expected, Complex[] result) {
        Assert.assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertTrue(Complex.equals(expected[i], result[i], 0.005));
        }
    }
}
