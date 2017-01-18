/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

/**
 *
 * @author glabg
 */
public class MathFunctions {

    public static double SINC(double n) {
        if (n == 0) {
            return 1;
        } else {
            return Math.sin(Math.PI * n) / (Math.PI * n);
        }
    }
}
