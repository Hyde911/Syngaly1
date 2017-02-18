/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.tools.exceptions;

/**
 *
 * @author marr
 */
public class NotSameSamplinRateExpcetion extends Exception {

    public NotSameSamplinRateExpcetion() {

        super("Sampling rates do not match");
    }
}
