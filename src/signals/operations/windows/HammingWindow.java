/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.operations.windows;

/**
 *
 * @author glabg
 */
public class HammingWindow extends WindowFunction {

    @Override
    protected double value(int length, int index) {
        return 0.54d - 0.46d * (double) Math.cos(TWO_PI * index / (length - 1));
    }
}
