/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools.constatns;

import signals1.tools.quantisation.MeanQuantizer;
import signals1.tools.quantisation.NoneQuantizer;
import signals1.tools.quantisation.Quantizer;
import signals1.tools.quantisation.RoundDownQuantizer;

/**
 *
 * @author marr
 */
public class Quantizers {

    public static Quantizer getQuantizer(int id, int nubmerOfBits) {
        switch (id) {
            case 2:
                return new MeanQuantizer(nubmerOfBits);
            case 1:
                return new RoundDownQuantizer(nubmerOfBits);
            default:
                return new NoneQuantizer(nubmerOfBits);
        }
    }
}
