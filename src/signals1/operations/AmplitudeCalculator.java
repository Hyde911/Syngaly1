/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.operations;

import signals1.discreteSignals.DerivedSignal;
import signals1.discreteSignals.abstracts.DiscreteSignal;
import signals1.tools.exceptions.DivideByZeroValueExcpetion;
import signals1.tools.exceptions.NotSameSamplinRateExpcetion;

/**
 *
 * @author marr
 */
public class AmplitudeCalculator {

    public static DerivedSignal AddSignals(DiscreteSignal s1, DiscreteSignal s2) throws NotSameSamplinRateExpcetion {
        AmplitudeOperations op = new AmplitudeOperations(s1, s2);
        return op.add();
    }

    public static DerivedSignal SubSignals(DiscreteSignal s1, DiscreteSignal s2) throws NotSameSamplinRateExpcetion {
        AmplitudeOperations op = new AmplitudeOperations(s1, s2);
        return op.sub();
    }

    public static DerivedSignal MultiplySignals(DiscreteSignal s1, DiscreteSignal s2) throws NotSameSamplinRateExpcetion {
        AmplitudeOperations op = new AmplitudeOperations(s1, s2);
        return op.mul();
    }

    public static DerivedSignal DivideSignals(DiscreteSignal s1, DiscreteSignal s2) throws NotSameSamplinRateExpcetion, DivideByZeroValueExcpetion {
        AmplitudeOperations op = new AmplitudeOperations(s1, s2);
        return op.div();
    }
}
