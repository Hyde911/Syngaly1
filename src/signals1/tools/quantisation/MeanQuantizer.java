/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools.quantisation;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public class MeanQuantizer extends Quantizer{

    public MeanQuantizer(int bitsNumber) {
        super(bitsNumber);
    }

    @Override
    public Complex quantizeSample(Complex value, double amplitude) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
