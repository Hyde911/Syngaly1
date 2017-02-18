/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.fourier;

import org.apache.commons.math3.complex.Complex;
import signals.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class DefinitionFourierTransform {

    public static Complex[] transform(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex wFactor = calculateWFactor(length);

        Complex[] result = new Complex[length];

        for (int i = 0; i < length; i++) {
            result[i] = Complex.ZERO;
            for (int j = 0; j < length; j++) {
                result[i] = result[i].add(wFactor.pow(-1.0 * i * j).multiply(data[j]));
            }
        }

        return result;
    }

    public static Complex[] invTransform(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex wFactor = calculateWFactor(length);

        Complex[] result = new Complex[length];

        for (int i = 0; i < length; i++) {
            result[i] = Complex.ZERO;
            for (int j = 0; j < length; j++) {
                result[i] = result[i].add(wFactor.pow(1.0 * i * j).multiply(data[j]));
            }
            result[i] = result[i].divide(length);
        }

        return result;
    }

    private static Complex calculateWFactor(int n) {
        return new Complex(Math.cos(2.0 * Math.PI / n), Math.sin(2.0 * Math.PI / n));
    }
}
