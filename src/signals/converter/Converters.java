/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.converter;

import signals.converter.Converters.Types;

/**
 *
 * @author glabg
 */
public class Converters {

    public enum Types {
        ZOH("zero-order hold"),
        FOH("first-order hold"),
        SINC("sinus cardinalis");
        private final String display;

        private Types(String s) {
            display = s;
        }

        @Override
        public String toString() {
            return display;
        }
    }

    Types type;

    public Converters(Types type) {
        this.type = type;
    }

    public D2AConverter getConverter() {
        switch (type) {
            case ZOH:
                return new ZOHConverter();
            case FOH:
                return new FOHConverter();
            case SINC:
                return new SINCConverter();
            default:
                return null;
        }
    }

}
