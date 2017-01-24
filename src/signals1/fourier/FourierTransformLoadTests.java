/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.fourier;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.complex.Complex;
import signals1.tools.exceptions.NotPowerOfTwoException;

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
        Complex[] data = new Complex[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = new Complex(rand.nextDouble(), rand.nextDouble());
        }

        System.out.println("External library");

        long start = System.nanoTime();
        FFT.fft(data);
        long stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("Definition transform");

        start = System.nanoTime();
        try {
            DefinitionFourierTransform.Transform(data);
        } catch (NotPowerOfTwoException ex) {
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");

        System.out.println("FFS");

        start = System.nanoTime();
        try {
            FastFourierTransform.RecursiveFfs(data);
        } catch (NotPowerOfTwoException ex) {
        }
        stop = System.nanoTime();

        System.out.println(((stop - start) / 1000000) + "[ms]");
        System.out.println("--------------------");
    }

}
