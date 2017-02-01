/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.fourier;

import org.apache.commons.math3.complex.Complex;
import signals1.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author glabg
 *
 * m - output element
 */
public class GGFourierTransform {

    public static Complex[] fft_recursive(Complex[] input) throws NotPowerOfTwoException {
        int N = input.length;
        if(N==1){
            return new Complex[]{input[0]};
        }
        if ((N & (N - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex[] result = new Complex[N];
        Complex[] even = new Complex[N / 2];        
        Complex[] odd = new Complex[N / 2];
        
        splitTableToOddAndEven(input, even, odd);
        odd = fft_recursive(odd);
        even = fft_recursive(even);
        
        
        for (int m = 0; m < N/2; m++) {
            double angle = -2 * m * Math.PI / N;
            Complex w = new Complex(Math.cos(angle), Math.sin(angle));
            result[m] = even[m].add(w.multiply(odd[m]));
            result[m + N/2] = even[m].subtract(w.multiply(odd[m]));
        }

        return result;
    }

    public static Complex[] ifft_recursive(Complex[] input) throws NotPowerOfTwoException{
        int N = input.length;
        if ((N & (N - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex[] result = getSprzezone(input);
        //transformata na sprzężonych
        result = fft_recursive(result);
        //przeskalowanie nowych sprzężonych - dzielenie przez N
        result = getSprzezone(result);
        for(int m = 0; m<N; m++){
            result[m] = new Complex(result[m].getReal()/N, result[m].getImaginary()/N);
        }
                
        return result;
    }
    
    private static void splitTableToOddAndEven(Complex[] input, Complex[] even, Complex[] odd) {
        for (int n = 0; n < input.length/2; n++) {
            even[n] = input[n * 2];
            odd[n] = input[n * 2 + 1];
        }
    }

    public static Complex[] dft(Complex[] input, boolean isReversed) throws NotPowerOfTwoException {
        int N = input.length;
        if ((N & (N - 1)) != 0) {
            throw new NotPowerOfTwoException();
        }
        Complex[] result = new Complex[N];
        int directionFactor = getDirection(isReversed);
        Complex w = getW(N);
        for (int m = 0; m < N; m++) {
            result[m] = Complex.ZERO;
            for (int n = 0; n < N; n++) {
                result[m] = result[m].add(w.pow(directionFactor * m * n).multiply(input[n]));
            }
            if (isReversed) {
                result[m] = result[m].divide(N);
            }

        }
        return result;
    }

    private static Complex getW(int N) {
        return new Complex(Math.cos(2 * Math.PI / N),
                Math.sin(2 * Math.PI / N));
    }

    private static int getDirection(boolean isReversed) {
        if (isReversed) {
            return -1;
        }
        return 1;
    }

    private static Complex[] getSprzezone(Complex[] input) {
        int N = input.length;
        Complex[] result = new Complex[N];      
        for(int n = 0; n < N; n++){
            result[n] = input[n].conjugate();
        }        
        return result;
    }

}
