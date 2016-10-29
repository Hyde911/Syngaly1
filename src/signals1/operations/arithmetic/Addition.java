/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations.arithmetic;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public class Addition implements ArithmeticOperator{

    @Override
    public Complex getResult(Complex c1, Complex c2) {
        return c1.add(c2);
    }
    
}
