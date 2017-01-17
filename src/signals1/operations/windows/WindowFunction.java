/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.windows;

/**
 *
 * @author glabg
 */
public abstract class WindowFunction {

    protected static final double TWO_PI = (double) (2 * Math.PI);
    protected int length;

    public WindowFunction() {
    }


    public void apply(double[] samples) {
        this.length = samples.length;

        for (int n = 0; n < samples.length; n++) {
            samples[n] *= value(samples.length, n);
        }
    }

    public void apply(double[] samples, int offset, int length) {
        this.length = length;

        for (int n = offset; n < offset + length; ++n) {
            samples[n] *= value(length, n - offset);
        }
    }


    public double[] generateCurve(int length) {
        double[] samples = new double[length];
        for (int n = 0; n < length; n++) {
            samples[n] = 1f * value(length, n);
        }
        return samples;
    }

    protected abstract double value(int length, int index);
}
