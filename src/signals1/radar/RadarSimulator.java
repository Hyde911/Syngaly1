/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import signals1.tools.RadarParameters;

/**
 *
 * @author marr
 */
public class RadarSimulator {

    private final RadarParameters params;
    private RadarSignalsGenerator signals;
    
    public RadarSimulator (RadarParameters params){
        this.params = params;
        signals = new RadarSignalsGenerator(params);
    }
}
