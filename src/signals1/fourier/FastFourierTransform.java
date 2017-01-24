/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.fourier;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class FastFourierTransform {

    public static Complex[] RecursiveFfs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }

        Complex halfWFactor = CalculateWFactor(length / 2);
        Complex wFactor = CalculateWFactor(length);

        if (length > 8) {
            Complex[] firstHalf = RecursiveFfs(Arrays.copyOf(data, length / 2));
            Complex[] secondHalf = RecursiveFfs(Arrays.copyOfRange(data, length / 2, length));
            Complex[] whole = new Complex[length];
            for (int i = 0; i < length; i += 2) {
                whole[i] = firstHalf[i / 2];
                whole[i + 1] = secondHalf[i / 2];
            }
            return whole;
        } else {
            Complex[] result = new Complex[length];
            for (int i = 0; i < length / 2; i++) {
                Complex evenPart = Complex.ZERO;
                Complex oddPart = Complex.ZERO;
                for (int j = 0; j < length / 2; j++) {
                    evenPart = evenPart.add(halfWFactor.pow(-1.0 * i * j).multiply(data[j * 2]));
                    oddPart = oddPart.add(halfWFactor.pow(-1.0 * i * j).multiply(data[(j * 2 + 1)]));
                }
                oddPart = oddPart.multiply(wFactor.pow(-1.0 * i));
                result[i] = oddPart.add(evenPart);
                result[i + length / 2] = evenPart.subtract(oddPart);
            }

            return result;
        }
    }

    public static Complex[] RecursiveIffs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex halfWFactor = CalculateWFactor(length / 2);
        Complex wFactor = CalculateWFactor(length);

        if (length > 8) {
            Complex[] firstHalf = RecursiveFfs(Arrays.copyOf(data, length / 2));
            Complex[] secondHalf = RecursiveFfs(Arrays.copyOfRange(data, length / 2, length));
            Complex[] whole = new Complex[length];
            for (int i = 0; i < length; i += 2) {
                whole[i] = firstHalf[i / 2];
                whole[i + 1] = secondHalf[i / 2];
            }
            return whole;
        } else {
            Complex[] result = new Complex[length];
            for (int i = 0; i < length / 2; i++) {
                Complex evenHalf = Complex.ZERO;
                Complex oddHalf = Complex.ZERO;
                for (int j = 0; j < length / 2; j++) {
                    evenHalf = evenHalf.add(halfWFactor.pow(1.0 * i * j).multiply(data[j * 2]));
                    oddHalf = oddHalf.add(halfWFactor.pow(1.0 * i * j).multiply(data[(j * 2 + 1)]));
                }
                oddHalf = oddHalf.multiply(wFactor.pow(1.0 * i));
                result[i] = oddHalf.add(evenHalf).divide(length);
                result[i + length / 2] = evenHalf.subtract(oddHalf).divide(length);
            }

            return result;
        }
    }

    public static Complex[] Ffs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        return null;
    }

    public static Complex[] IFfs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        return null;
    }

    private static Complex CalculateWFactor(int n) {
        return new Complex(Math.cos(2.0 * Math.PI / n), Math.sin(2.0 * Math.PI / n));
    }
}
