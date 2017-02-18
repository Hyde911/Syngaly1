/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools.exceptions;

/**
 *
 * @author marr
 */
public class DivideByZeroValueException extends Exception {

    public DivideByZeroValueException() {

        super("Divisor signal contains zero value");
    }
}
