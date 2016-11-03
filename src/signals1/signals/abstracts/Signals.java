/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.signals.abstracts;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author marr
 */
public abstract class Signals {

    private final int id;
    protected final int samplesPerSecond = 1_048_5;//76;
    static AtomicInteger nextId = new AtomicInteger();
    protected double amplitude;
    protected double duration;
    protected int numberOfSamples;
    protected Complex[] result;
    protected double startTime;
    protected String fullName = "";

    private Signals() {
        id = nextId.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public Signals(double startTime, double amplitude, double duration) {
        this();
        this.startTime = startTime;
        this.amplitude = amplitude;
        this.duration = duration;
        this.numberOfSamples = (int) this.duration * samplesPerSecond;
    }

    public Complex[] getSignal() {
        if (result == null){
            generateSignal();
        }
        return result;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public double getDuration() {
        return duration;
    }

    public double getStartTime() {
        return startTime;
    }

    public int getNumberOfSamples() {
        return numberOfSamples;
    }

    public int getSamplesPerSecond() {
        return samplesPerSecond;
    }

    public String getFullName() {
        return fullName;
    }

    abstract protected void generateSignal();
}
