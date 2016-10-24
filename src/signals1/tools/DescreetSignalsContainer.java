/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import java.util.ArrayList;

/**
 *
 * @author glabg
 */
public class DescreetSignalsContainer extends ArrayList{
    
    private static DescreetSignalsContainer INSTANCE;

    private DescreetSignalsContainer(){}
    
    public static DescreetSignalsContainer getInstance() {
        if(INSTANCE == null){
            INSTANCE = new DescreetSignalsContainer();
        }
        return INSTANCE;
    }
    
}
