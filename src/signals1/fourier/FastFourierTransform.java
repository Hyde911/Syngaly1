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
            Complex wFactor = CalculateWFactor(length);
            result[i] = evenPart[i].add(wFactor.pow(-1 * i).multiply(oddPart[i]));
            result[i + length / 2] = evenPart[i].subtract(wFactor.pow(-1 * i).multiply(oddPart[i]));
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
        Complex[] result = new Complex[length];
        Complex wFactor = CalculateWFactor(length);
        for (int i = 0; i < (int)Math.log(length); i++){
//            Complex factorN = CalculateWFactor(i)
        }
//        for (int i = 0; i < 2; i++){
            result[0] = data[0].add(data[1]);
            result[1] = data[0].subtract(data[1]);
//        }
        return result;
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

    private static Complex[] ComplexConjugate(Complex[] data, int div) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].conjugate().divide(div);
        }
        return data;
    }

    private static Complex[] BitReversal(Complex[] data){
        Complex[] res = new Complex[data.length];
        for (int i = 0; i < data.length; i++){
            res[Integer.reverse(i)] = data[i];
        }
        return res;
    }
}
