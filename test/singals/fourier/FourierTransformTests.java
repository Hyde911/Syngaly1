/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singals.fourier;

import java.util.Arrays;
import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import org.junit.Assert;
import org.junit.Test;
import signals1.fourier.Afft;
import signals1.fourier.GGFourierTransform;
import signals1.fourier.DefinitionFourierTransform;
import signals1.fourier.FFT;
import signals1.fourier.FastFourierTransform;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class FourierTransformTests {

    private Complex[] data;
    private Complex[] transformData;

    public FourierTransformTests() throws Exception {
        data = generateData(128);
        transformData = FFT.fft(data);       
    }

    @Test
    public void externalLibraryTest() {
        Complex[] transform = FFT.fft(data);
        Complex[] reverse = FFT.ifft(transform);
        compareComplexArrays(data, reverse);
    }

    @Test
    public void definitionTransformTest() {
        Complex[] transform;
        try {
            transform = DefinitionFourierTransform.Transform(data);
            compareComplexArrays(transformData, transform);
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }

    @Test
    public void ggDFTvsMG_DFT() {
        Complex[] transform;
        Complex[] mgDFTData;
        try {
            transform = GGFourierTransform.dft(data, false);
            mgDFTData = DefinitionFourierTransform.Transform(data);
            compareComplexArrays(mgDFTData, transform);
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }
    
    @Test
    public void ggDFT() {
        Complex[] transform;
        try {
            transform = GGFourierTransform.dft(data, false);
            compareComplexArrays(data, GGFourierTransform.dft(transform, true));
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }
    @Test
    public void ggFFT() {
        Complex[] transform;
        try {
            transform = GGFourierTransform.fft_recursive(data);
            compareComplexArrays(data, GGFourierTransform.ifft_recursive(transform));
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }
    @Test
    public void ggFFTvsDFT() {
        Complex[] transform;
        try {
            transform = GGFourierTransform.fft_recursive(data);
            compareComplexArrays(transform, GGFourierTransform.dft(data, false));
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }

    @Test
    public void definitionInvTransormTest() {
        Complex[] reverse;
        try {
            reverse = DefinitionFourierTransform.InvTransform(transformData);
            compareComplexArrays(data, reverse);
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }

//    @Test(expected = NotPowerOfTwoException.class)
//    public void definitionTransformNotPowerOfException() throws NotPowerOfTwoException {
//        Complex[] invalidData = new Complex[10];
//        Complex[] res = DefinitionFourierTransform.Transform(invalidData);
//    }
//
//    @Test(expected = NotPowerOfTwoException.class)
//    public void definitionInvTransformNotPowerOfException() throws NotPowerOfTwoException {
//        Complex[] invalidData = new Complex[10];
//        Complex[] res = DefinitionFourierTransform.InvTransform(invalidData);
//    }

    @Test
    public void definitionTransformBothWaysTest() throws NotPowerOfTwoException {
        Complex[] transform = DefinitionFourierTransform.Transform(data);
        Complex[] reverse = DefinitionFourierTransform.InvTransform(transform);
        compareComplexArrays(data, reverse);
    }

    @Test
    public void recursiveFftTest() throws NotPowerOfTwoException {
        Complex[] transform = FastFourierTransform.recursiveFft(data);
        compareComplexArrays(transformData, transform);
    }

    @Test
    public void recursiveIfftTest() throws NotPowerOfTwoException {
        Complex[] reverse = FastFourierTransform.recursiveIfft(transformData);
        compareComplexArrays(data, reverse);
    }

//    @Test(expected = NotPowerOfTwoException.class)
//    public void recursiveFftTestNotPowerOfException() throws NotPowerOfTwoException {
//        Complex[] invalidData = new Complex[10];
//        FastFourierTransform.RecursiveFft(invalidData);
//    }
//
//    @Test(expected = NotPowerOfTwoException.class)
//    public void recursiveIfftTestNotPowerOfException() throws NotPowerOfTwoException {
//        Complex[] invalidData = new Complex[10];
//        FastFourierTransform.RecursiveIfft(invalidData);
//    }

    private void compareComplexArrays(Complex[] expected, Complex[] result) {
        Assert.assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertTrue("i: " + i + " exp: " + expected[i] + " res: " + result[i], Complex.equals(expected[i], result[i], 0.0001));
        }
    }
    
    @Test
    public void ggfftTest() throws NotPowerOfTwoException {
        Complex[] transform = Arrays.copyOf(data, data.length);
        GGFourierTransform.fft_in_situ(transform);
        compareComplexArrays(transformData, transform);
    }

    @Test
    public void fftTest() throws NotPowerOfTwoException {
        Complex[] transform = FastFourierTransform.fft(data);
        compareComplexArrays(transformData, transform);
    }
    
    @Test
    public void fftTest_1() throws NotPowerOfTwoException {
        Complex[] transform = FastFourierTransform.fft(data);
        Complex[] orig = FastFourierTransform.iFft(transform);
        compareComplexArrays(data, orig);
    }

    @Test
    public void ifftTest() throws NotPowerOfTwoException {
        Complex[] reverse = FastFourierTransform.iFft(transformData);
        compareComplexArrays(data, reverse);
    }

//    @Test(expected = NotPowerOfTwoException.class)
//    public void fftTestNotPowerOfException() throws NotPowerOfTwoException {
//        Complex[] invalidData = new Complex[10];
//        data = generateData(128);
//        FastFourierTransform.Fft(invalidData);
//    }
//
//    @Test(expected = NotPowerOfTwoException.class)
//    public void ifftTestNotPowerOfException() throws NotPowerOfTwoException {
//        Complex[] invalidData = new Complex[10];
//        FastFourierTransform.IFft(invalidData);
//    }

    private Complex[] generateData(int n) {
        Complex[] result = new Complex[n];
        Random rand = new Random();
        for (int i = 1; i <= n; i++) {
            result[i - 1] = new Complex(rand.nextDouble(), rand.nextDouble());
        }
        return result;
    }
    
    

}
