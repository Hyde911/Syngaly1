/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import signals1.discreteSignals.DerivedSignal;
import signals1.operations.filters.FIRFilter;
import signals1.operations.filters.LowPassFIRFilter;
import signals1.operations.windows.HammingWindow;

/**
 *
 * @author glabg
 */
public class FilterTest {
    
    public static void test(){
        FIRFilter filter = new LowPassFIRFilter(new HammingWindow(), 1, 10, 1000);
        DerivedSignal filterSignal = new DerivedSignal(filter.getFilter(),1000, 0, 1);
        
    }
}
