/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.tools.quantisation;

import java.io.Serializable;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public class RoundDownQuantizer extends Quantizer implements Serializable {

    public RoundDownQuantizer(int bitsNumber) {
        super(bitsNumber);
    }

    @Override
    public Complex quantizeSample(Complex value, double amplitude) {
        if (Math.abs(value.getReal()) == 1 || value.getReal() == 0) {
            return value.multiply(amplitude);
        }
        int sign = 1;
        if (value.getReal() < 0) {
            sign = -1;
        }
        int interval = getInterval(value.getReal());
        double newReal = stepsTable[sign * interval];
        return new Complex(newReal * amplitude * sign, value.getImaginary());
    }

}
