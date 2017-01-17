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
public class HammingWindow extends WindowFunction {

    @Override
    protected double value(int length, int index) {
        return 0.54f - 0.46f * (double) Math.cos(TWO_PI * index / (length - 1));
    }
}
