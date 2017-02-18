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
public class BlackmanWindow extends WindowFunction {

    protected double alpha;

    public BlackmanWindow(double alpha) {
        this.alpha = alpha;
    }

    public BlackmanWindow() {
        this(0.16f);
    }

    @Override
    protected double value(int length, int index) {
        double a0 = (1 - this.alpha) / 2f;
        double a1 = 0.5f;
        double a2 = this.alpha / 2f;

        return a0 - a1 * (double) Math.cos(TWO_PI * index / (length - 1)) + a2 * (double) Math.cos(4 * Math.PI * index / (length - 1));
    }
}
