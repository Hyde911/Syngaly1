/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.tools;

import java.util.ArrayList;
import signals.continuousSignals.abstracts.AbstractSignal;

public class SignalContainer extends ArrayList<AbstractSignal> {

    private static SignalContainer INSTANCE;

    public static SignalContainer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SignalContainer();
        }
        return INSTANCE;
    }

    public AbstractSignal getById(int id) {
        if (id < 1) {
            return null;
        }
        for (AbstractSignal s : this) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
