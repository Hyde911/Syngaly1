/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singals.fourier;

import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import org.junit.Assert;
import org.junit.Test;
import signals1.fourier.DefinitionFourierTransform;
import signals1.fourier.FFT;
import signals1.fourier.FastFourierTransform;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class FourierTransformTests {

    private final Complex[] data;
    private final Complex[] transformData;

    public FourierTransformTests() throws Exception {
        data = generateData(4);
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
    public void definitionInvTransormTest() {
        Complex[] reverse;
        try {
            reverse = DefinitionFourierTransform.InvTransform(transformData);
            compareComplexArrays(data, reverse);
        } catch (NotPowerOfTwoException ex) {
            Assert.fail();
        }
    }

    @Test(expected = NotPowerOfTwoException.class)
    public void definitionTransformNotPowerOfException() throws NotPowerOfTwoException {
        Complex[] invalidData = new Complex[10];
        Complex[] res = DefinitionFourierTransform.Transform(invalidData);
    }

    @Test(expected = NotPowerOfTwoException.class)
    public void definitionInvTransformNotPowerOfException() throws NotPowerOfTwoException {
        Complex[] invalidData = new Complex[10];
        Complex[] res = DefinitionFourierTransform.InvTransform(invalidData);
    }

    @Test
    public void definitionTransformBothWaysTest() throws NotPowerOfTwoException {
        Complex[] transform = DefinitionFourierTransform.Transform(data);
        Complex[] reverse = DefinitionFourierTransform.InvTransform(transform);
        compareComplexArrays(data, reverse);
    }

    @Test
    public void recursiveFftTest() throws NotPowerOfTwoException {
        Complex[] transform = FastFourierTransform.RecursiveFfs(data);
        compareComplexArrays(transformData, transform);
    }

    @Test
    public void recursiveIfftTest() throws NotPowerOfTwoException {
        Complex[] reverse = FastFourierTransform.RecursiveIffs(transformData);
        compareComplexArrays(data, reverse);
    }

    @Test(expected = NotPowerOfTwoException.class)
    public void recursiveFftTestNotPowerOfException() throws NotPowerOfTwoException {
        Complex[] invalidData = new Complex[10];
        Complex[] res = FastFourierTransform.RecursiveFfs(invalidData);
    }

    @Test(expected = NotPowerOfTwoException.class)
    public void recursiveIfftTestNotPowerOfException() throws NotPowerOfTwoException {
        Complex[] invalidData = new Complex[10];
        Complex[] res = FastFourierTransform.RecursiveIffs(invalidData);
    }

    private void compareComplexArrays(Complex[] expected, Complex[] result) {
        Assert.assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertTrue("i: " + i + " exp: " + expected[i] + " res: " + result[i], Complex.equals(expected[i], result[i], 0.0001));
        }
    }

    @Test
    public void fftTest() throws NotPowerOfTwoException {
        Complex[] transform = FastFourierTransform.Ffs(data);
        compareComplexArrays(transformData, transform);
    }

    @Test
    public void ifftTest() throws NotPowerOfTwoException {
        Complex[] reverse = FastFourierTransform.IFfs(transformData);
        compareComplexArrays(data, reverse);
    }

    @Test(expected = NotPowerOfTwoException.class)
    public void fftTestNotPowerOfException() throws NotPowerOfTwoException {
        Complex[] invalidData = new Complex[10];
        Complex[] res = FastFourierTransform.Ffs(invalidData);
    }

    @Test(expected = NotPowerOfTwoException.class)
    public void ifftTestNotPowerOfException() throws NotPowerOfTwoException {
        Complex[] invalidData = new Complex[10];
        Complex[] res = FastFourierTransform.IFfs(invalidData);
    }

    private Complex[] generateData(int n) {
        Complex[] result = new Complex[n];
        Random rand = new Random();
        for (int i = 1; i <= n; i++) {
            result[i - 1] = new Complex(rand.nextDouble(), rand.nextDouble());
        }
        return result;
    }
}
