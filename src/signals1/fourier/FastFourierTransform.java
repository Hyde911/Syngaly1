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

        if (length == 1) {
            return data;
        }
        Complex[] oddPart = new Complex[length / 2];
        Complex[] evenPart = new Complex[length / 2];

        for (int i = 0; i < length / 2; i++) {
            oddPart[i] = data[2 * i + 1];
            evenPart[i] = data[2 * i];
        }

        oddPart = RecursiveFfs(oddPart);
        evenPart = RecursiveFfs(evenPart);

        Complex[] result = new Complex[length];
        for (int i = 0; i < length / 2; i++) {
            Complex wFactor = CalculateWFactor(length).pow(-1 * i).multiply(oddPart[i]);
            result[i] = evenPart[i].add(wFactor);
            result[i + length / 2] = evenPart[i].subtract(wFactor);
        }
        return result;
    }

    public static Complex[] RecursiveIffs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex[] tmp = ComplexConjugate(data, 1);

        tmp = RecursiveFfs(tmp);

        return ComplexConjugate(tmp, length);
    }

    public static Complex[] Ffs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }

        //log2(length)
        int levels = (int) (Math.log(length) / Math.log(2));
        //bit reversal of indexes
        Complex tmp;
        for (int i = 0; i < length; i++) {
            int reversedIndex = Integer.reverse(i) >>> (32 - levels);
            if (reversedIndex > i) {
                tmp = data[i];
                data[i] = data[reversedIndex];
                data[reversedIndex] = tmp;
            }
        }
        //iterate over levels
        for (int i = levels - 1; i >= 0; i--) {
            //block size
            int tmpLength = (int) (length / Math.pow(2, i));
            Complex wFactor = CalculateWFactor(tmpLength);
            //iterate over blocks in level
            for (int j = 0; j < length / tmpLength; j++) {
                //iterate over butterlies inside block
                for (int k = j * tmpLength; k < (tmpLength / 2) + (j * tmpLength); k++) {
                    Complex first = data[k];
                    Complex second = data[k + (tmpLength / 2)].multiply(wFactor.pow(-k));
                    data[k] = first.add(second);
                    data[k + (tmpLength / 2)] = first.subtract(second);
                }
            }
        }
        return data;
    }

    public static Complex[] IFfs(Complex[] data) throws NotPowerOfTwoException {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex[] tmp = ComplexConjugate(data, 1);

        tmp = Ffs(tmp);

        return ComplexConjugate(tmp, length);
    }

    private static Complex CalculateWFactor(int n) {
        return new Complex(Math.cos(2.0 * Math.PI / n), Math.sin(2.0 * Math.PI / n));
    }

    private static Complex[] ComplexConjugate(Complex[] data, int div) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].conjugate().divide(div);
        }
        return data;
    }

    private static Complex[] BitReversal(Complex[] data) {
        Complex[] res = new Complex[data.length];
        for (int i = 0; i < data.length; i++) {
            res[Integer.reverse(i)] = data[i];
        }
        return res;
    }
}
