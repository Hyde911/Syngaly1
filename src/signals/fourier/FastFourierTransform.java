/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.fourier;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public class FastFourierTransform {

    public static Complex[] recursiveFft(Complex[] data) {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            data = fillToPowerOfTwo(data);
            length = data.length;
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

        oddPart = recursiveFft(oddPart);
        evenPart = recursiveFft(evenPart);

        Complex[] result = new Complex[length];
        for (int i = 0; i < length / 2; i++) {
            Complex wFactor = calculateWFactor(i, length).multiply(oddPart[i]);
            result[i] = evenPart[i].add(wFactor);
            result[i + length / 2] = evenPart[i].subtract(wFactor);
        }
        return result;
    }

    public static Complex[] recursiveIfft(Complex[] data) {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            data = fillToPowerOfTwo(data);
            length = data.length;
        }
        Complex[] tmp = complexConjugateWithDivision(data, 1);

        tmp = recursiveFft(tmp);

        return complexConjugateWithDivision(tmp, length);
    }

    public static Complex[] fft(Complex[] data) {
        int length = data.length;
        Complex[] res = Arrays.copyOf(data, length);
        if ((length & (length - 1)) != 0) {
            res = fillToPowerOfTwo(res);
            length = res.length;
        }

        //log2(length)
        int levels = (int) (Math.log(length) / Math.log(2));
        //bit reversal of indexes
        Complex tmp;
        for (int i = 0; i < length; i++) {
            int reversedIndex = Integer.reverse(i) >>> (32 - levels);
            if (reversedIndex > i) {
                tmp = res[i];
                res[i] = res[reversedIndex];
                res[reversedIndex] = tmp;
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
                    first = res[k];
                    second = res[k + (tmpLength / 2)].multiply(calculateWFactor((k - blocStart), tmpLength));
                    res[k] = first.add(second);
                    res[k + (tmpLength / 2)] = first.subtract(second);
                }
            }
        }
        return res;
    }

    public static Complex[] iFft(Complex[] data) {
        int length = data.length;
        if ((length & (length - 1)) != 0) {
            data = fillToPowerOfTwo(data);
            length = data.length;
        }
        Complex[] tmp = complexConjugateWithDivision(data, 1);

        tmp = fft(tmp);

        return complexConjugateWithDivision(tmp, length);
    }

    private static Complex calculateWFactor(int k, int n) {
        return new Complex(Math.cos(-2.0 * Math.PI * k / n), Math.sin(-2.0 * Math.PI * k / n));
    }

    private static Complex[] complexConjugateWithDivision(Complex[] data, int div) {
        Complex[] result = Arrays.copyOf(data, data.length);
        if (div == 1) {
            for (int i = 0; i < data.length; i++) {
                result[i] = data[i].conjugate();
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                result[i] = data[i].conjugate().divide(div);
            }
        }
        return result;
    }

    private static Complex[] fillToPowerOfTwo(Complex[] data) {
        int length = data.length;
        int nextPowerOfTwo = (int) Math.ceil(((Math.log(length) / Math.log(2))));
        Complex[] newData = new Complex[(int) Math.pow(2, nextPowerOfTwo)];
        Arrays.fill(newData, Complex.ZERO);
        for (int i = 0; i < length; i++) {
            newData[i] = data[i];
        }
        return newData;
    }

}
