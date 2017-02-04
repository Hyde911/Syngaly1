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
            Complex wFactor = CalculateWFactor(i, length).multiply(oddPart[i]);
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
        Complex[] tmp = ComplexConjugateWithDivision(data, 1);

        tmp = RecursiveFfs(tmp);

        return ComplexConjugateWithDivision(tmp, length);
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
        Complex first;
        Complex second;
        //iterate over levels
        for (int i = levels - 1; i >= 0; i--) {

            //block size
            int tmpLength = (int) (length / Math.pow(2, i));

            //iterate over blocks in level
            for (int j = 0; j < length / tmpLength; j++) {

                //iterate over butterlies inside block
                int blocStart = (j * tmpLength);
                for (int k = blocStart; k < (tmpLength / 2) + blocStart; k++) {
                    first = data[k];
                    second = data[k + (tmpLength / 2)].multiply(CalculateWFactor((k - blocStart), tmpLength));
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
        Complex[] tmp = ComplexConjugateWithDivision(data, 1);

        tmp = Ffs(tmp);

        return ComplexConjugateWithDivision(tmp, length);
    }

    private static Complex CalculateWFactor(int k, int n) {
        return new Complex(Math.cos(-2.0 * Math.PI  * k / n), Math.sin(-2.0 * Math.PI * k/ n));
    }

    private static Complex[] ComplexConjugateWithDivision(Complex[] data, int div) {
        if (div == 1) {
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].conjugate();
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].conjugate().divide(div);
            }
        }
        return data;
    }


}
