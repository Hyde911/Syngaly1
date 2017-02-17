/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author marr
 */
public class ConvolutionTest {

    private final Complex[] values1 = new Complex[]{new Complex(3.2), new Complex(1.5), new Complex(9.4), new Complex(4.3)};
    private final Complex[] values2 = new Complex[]{new Complex(0.9), new Complex(4.8), new Complex(7.1)};
    private final Complex[] valuesConvolutons = new Complex[]{new Complex(2.88), new Complex(16.71), new Complex(38.38), new Complex(59.64), new Complex(87.38), new Complex(30.53)};

    public ConvolutionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of CalculateConvolutions method, of class Convolution.
     */
    @Test
    public void testCalculateConvolutions() {
        DiscreteSignal signal1 = new DerivedSignal(this.values1, 100, 0, 1);
        DiscreteSignal signal2 = new DerivedSignal(this.values2, 100, 0, 1);
        DerivedSignal expResult = new DerivedSignal(this.valuesConvolutons, 100, 0, 1);

        DerivedSignal result = Convolution.CalculateConvolutions(signal1, signal2);
        assertEquals(expResult.getValues().length, result.getValues().length);
        for (int i = 0; i < expResult.getValues().length; i++) {
            assertTrue(Complex.equals(expResult.getValues()[i], result.getValues()[i], 0.00001));
        }
    }
}
