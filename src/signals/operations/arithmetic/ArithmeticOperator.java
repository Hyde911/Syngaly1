/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.operations.arithmetic;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public interface ArithmeticOperator {

    Complex getResult(Complex c1, Complex c2);
}
