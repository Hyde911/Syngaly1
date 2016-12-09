/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.converter;

import signals1.converter.Converters.Types;

/**
 *
 * @author glabg
 */
public class Converters {

    public enum Types {
        ZOH,
        FOH,
        SINC;
    }
    
    Types type; 
    
    public Converters(Types type){
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
