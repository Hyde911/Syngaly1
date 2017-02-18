/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import signals.operations.AmplitudeCalculator;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import signals.discreteSignals.DerivedSignal;
import signals.tools.exceptions.DivideByZeroValueException;
import signals.tools.exceptions.NotSameSamplinRateExpcetion;

/**
 *
 * @author marr
 */
public class ArithmeticOperationsTest {

    private final Complex[] values1 = {
        new Complex(1.25, 1.02),
        new Complex(1.34, -2.7),
        new Complex(2.25, 2.13),
        new Complex(1.30, -2.3),
        new Complex(1.53, 9.13),
        new Complex(1.7, 1.22),
        new Complex(-0.37, -0.32),
        new Complex(-1.8, -8.4),
        new Complex(2.8, -1.81),
        new Complex(3.7, -0.88)
    };
    private final Complex[] values2 = {
        new Complex(1.8, -2.2),
        new Complex(13, 9.13),
        new Complex(0.97, 1.22),
        new Complex(-1.8, -8.4),
        new Complex(7.2, -1.81),
        new Complex(6.2, -0.88),
        new Complex(-4.1, 1.53),
        new Complex(4.9, 1.7),
        new Complex(-0.99, -0.37),
        new Complex(1.8, 1.34)
    };

    public ArithmeticOperationsTest() {
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
     * Test of add method, of class AmplitudeOperations.
     *
     * @throws signals.tools.exceptions.NotSameSamplinRateExpcetion
     */
    @Test(expected = NotSameSamplinRateExpcetion.class)
    public void testAdd_DifferentSamplingRates() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 2, 0, 0);
        AmplitudeCalculator.AddSignals(signal1, signal2);
    }

    @Test
    public void testAdd_EqualValues() throws NotSameSamplinRateExpcetion {
        double startTime = 0;
        DerivedSignal signal1 = new DerivedSignal(values1, 1, startTime, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, startTime, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal1, signal2);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].add(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        assertArrayEquals(expectedValues, result.getValues());

        assertEquals(result.getAmplitude(), 14.34, 0.0001);
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void addTest_SecondShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);

        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].add(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void addTest_FirstShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal2, signal1);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].add(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void addTest_SecondShifted() throws NotSameSamplinRateExpcetion {

        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal1, signal2);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i - 1].add(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(expectedValues.length, result.getDuration(), 0.0001);

    }

    @Test
    public void addTest_FirstShifted() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal2, signal1);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i - 1].add(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 11, 0.0001);
    }

    @Test
    public void addTest_FirstShiftedAndShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].add(signal2.getValues()[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 10, 0.0001);
    }

    @Test
    public void addTest_SecondShiftedAndShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.AddSignals(signal2, signal1);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = values1[i].add(values2[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[9] = values1[9];

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void testSub_EqualValues() throws NotSameSamplinRateExpcetion {
        double startTime = 0;
        DerivedSignal signal1 = new DerivedSignal(values1, 1, startTime, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, startTime, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal1, signal2);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].subtract(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getAmplitude(), 11.66, 0.0001);
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void subTest_SecondShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);

        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].subtract(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void subTest_FirstShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal2, signal1);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i].subtract(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void subTest_SecondShifted() throws NotSameSamplinRateExpcetion {

        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal1, signal2);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = values1[i].subtract(values2[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(expectedValues.length, result.getDuration(), 0.0001);

    }

    @Test
    public void subTest_FirstShifted() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal2, signal1);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i - 1].subtract(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 11, 0.0001);
    }

    @Test
    public void subTest_FirstShiftedAndShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].subtract(signal2.getValues()[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 10, 0.0001);
    }

    @Test
    public void subTest_SecondShiftedAndShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.SubSignals(signal2, signal1);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = values2[i - 1].subtract(values1[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[9] = values1[9];

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void testMul_EqualValues() throws NotSameSamplinRateExpcetion {
        double startTime = 0;
        DerivedSignal signal1 = new DerivedSignal(values1, 1, startTime, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, startTime, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal1, signal2);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].multiply(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        assertArrayEquals(expectedValues, result.getValues());

        assertEquals(result.getAmplitude(), 42.071, 0.0001);
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void mulTest_SecondShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].multiply(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void mulTest_FirstShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal2, signal1);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);

        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].multiply(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void mulTest_SecondShifted() throws NotSameSamplinRateExpcetion {

        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal1, signal2);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i - 1].multiply(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];
        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(expectedValues.length, result.getDuration(), 0.0001);

    }

    @Test
    public void mulTest_FirstShifted() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal2, signal1);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i - 1].multiply(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 11, 0.0001);
    }

    @Test
    public void mulTest_FirstShiftedAndShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].multiply(signal2.getValues()[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 10, 0.0001);
    }

    @Test
    public void mulTest_SecondShiftedAndShorter() throws NotSameSamplinRateExpcetion {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.MultiplySignals(signal2, signal1);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = values1[i].multiply(values2[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[9] = values1[9];

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void divTest_SecondShorter() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.DivideSignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);

        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].divide(signal2.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test
    public void divTest_FirstShorter() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 0, 0);
        DerivedSignal result = AmplitudeCalculator.DivideSignals(signal2, signal1);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 0; i < 10; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i].divide(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getStartTime(), 0, 0.0001);
    }

    @Test
    public void dviTest_SecondShifted() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {

        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.DivideSignals(signal1, signal2);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = values1[i].divide(values2[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(expectedValues.length, result.getDuration(), 0.0001);

    }

    @Test
    public void divTest_FirstShifted() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(values2, 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.DivideSignals(signal2, signal1);

        Complex[] expectedValues = new Complex[11];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal2.getValues()[i - 1].divide(signal1.getValues()[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[10] = values2[9];

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 11, 0.0001);
    }

    @Test
    public void divTest_FirstShiftedAndShorter() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.DivideSignals(signal1, signal2);

        Complex[] expectedValues = Arrays.copyOf(values1, 10);
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = signal1.getValues()[i].divide(signal2.getValues()[i - 1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }

        assertArrayEquals(expectedValues, result.getValues());
        assertEquals(result.getDuration(), 10, 0.0001);
    }

    @Test
    public void divTest_SecondShiftedAndShorter() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        DerivedSignal signal2 = new DerivedSignal(Arrays.copyOf(values2, 8), 1, 1, 0);
        DerivedSignal result = AmplitudeCalculator.DivideSignals(signal2, signal1);

        Complex[] expectedValues = new Complex[10];
        Arrays.fill(expectedValues, Complex.ZERO);
        expectedValues[0] = values1[0];
        for (int i = 1; i < 11; i++) {
            try {
                expectedValues[i] = values2[i - 1].divide(values1[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        expectedValues[9] = values1[9];

        assertArrayEquals(expectedValues, result.getValues());
    }

    @Test(expected = DivideByZeroValueException.class)
    public void divTest_DivideByZero() throws NotSameSamplinRateExpcetion, DivideByZeroValueException {
        DerivedSignal signal1 = new DerivedSignal(values1, 1, 0, 0);
        Complex[] val = new Complex[10];
        Arrays.fill(val, Complex.ZERO);

        DerivedSignal signal2 = new DerivedSignal(val, 1, 0, 0);
        AmplitudeCalculator.DivideSignals(signal1, signal2);
    }
}
