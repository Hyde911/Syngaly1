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
public abstract class Quantizer {
    protected int bitsNumber;
    
    public Quantizer (int bitsNumber){
        this.bitsNumber = bitsNumber;
    }
    
    public abstract Complex quantizeSample(Complex value, double amplitude);
}
