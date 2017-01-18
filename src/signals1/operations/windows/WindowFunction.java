/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.windows;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author glabg
 */
public abstract class WindowFunction {

    protected static final double TWO_PI = (double) (2 * Math.PI);
    protected int length;

    public WindowFunction() {
    }


    public Complex[] apply(Complex[] filter) {
        this.length = filter.length;

        for (int n = 0; n < filter.length; n++) {
            double real = filter[n].getReal();
            real *= value(filter.length, n);
            filter[n] = new Complex(real);
        }
        return filter;
    }

    public Complex[] apply(Complex[] filter, int offset, int length) {
        this.length = length;

        for (int n = offset; n < offset + length; ++n) {
            double real = filter[n].getReal();
            real *= value(length, n - offset);
            filter[n] = new Complex(real);
        }
        return filter;
    }


    public Complex[] generateCurve(int length) {
        Complex[] samples = new Complex[length];
        for (int n = 0; n < length; n++) {
            samples[n] = new Complex(1d * value(length, n));
        }
        return samples;
    }

    protected abstract double value(int length, int index);
}
