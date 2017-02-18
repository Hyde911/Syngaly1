/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.converter;

import signals1.discreteSignals.abstracts.DiscreteSignal;

/**
 *
 * @author glabg
 */
public class D2AConverterService {

    private final D2AConverter service;
    private final DiscreteSignal input;
    private final DiscreteSignal output;
    private final int samplingRate;

    public D2AConverterService(D2AConverter service, DiscreteSignal input, int samplingRate) {
        this.service = service;
        this.input = input;
        this.samplingRate = samplingRate;
        this.output = convertD2A();
    }

    public DiscreteSignal getOutput() {
        return output;
    }

    private DiscreteSignal convertD2A() {
        return service.convert(input, samplingRate);
    }

}
