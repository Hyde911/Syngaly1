/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.fourier;

import java.util.Random;
import org.apache.commons.math3.complex.Complex;
import signals.tools.exceptions.NotPowerOfTwoException;

/**
 *
 * @author marr
 */
public class FourierTransformLoadTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 2048;
        int iterations = 1;
        Complex[] data = new Complex[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = new Complex(rand.nextDouble(), rand.nextDouble());
        }

        System.out.println("External library");

        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            FFT.fft(data);
        }
        long stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("Definition transform");

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                DefinitionFourierTransform.transform(data);
            } catch (NotPowerOfTwoException ex) {
            }
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("RecursiveFFt");

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            FastFourierTransform.recursiveFft(data);
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("FFT");

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            FastFourierTransform.fft(data);
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("GGRecursiveFFt");

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                GGFourierTransform.fft_recursive(data);
            } catch (NotPowerOfTwoException ex) {
            }
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("GGFFT");

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                GGFourierTransform.fft_in_situ(data);
            } catch (NotPowerOfTwoException ex) {
            }
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");
    }

}
