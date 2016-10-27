/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import java.util.ArrayList;
import signals1.signals.abstracts.Signals;

public class SignalContainer extends ArrayList<Signals> {

    private static SignalContainer INSTANCE;

    public static SignalContainer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SignalContainer();
        }
        return INSTANCE;
    }

    public Signals getById(int id) {
        if (id < 1) {
            return null;
        }
        return get(id - 1);
    }
}
