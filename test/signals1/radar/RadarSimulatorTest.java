/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.radar;

import signals.radar.RadarResponse;
import signals.radar.RadarParameters;
import signals.radar.RadarSimulator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marr
 */
public class RadarSimulatorTest {

    private final double firstCompomentPeriod = 0.05;
    private final double secondCompomentPeriod = 0.03;
    private final int samplingRate = 8192;
    private final double buforLength = 0.2;
    private final double initialDistance = 100;
    private final double velocity = 300;
    private final double interval = 0.01;
    private final double waveSpeed = 10000;
    private final double finalDistance;
    private final RadarParameters params;
    private final RadarSimulator radar;

    public RadarSimulatorTest() {
        params = new RadarParameters(firstCompomentPeriod, secondCompomentPeriod, samplingRate, buforLength, initialDistance, velocity, interval, waveSpeed);
        finalDistance = velocity * interval + initialDistance;
        radar = new RadarSimulator(params);
    }

    /**
     * Test of generateResponse method, of class RadarSimulator.
     */
    @Test
    public void testGenerateResponseInitialDistance() {
        RadarResponse result = radar.generateResponse();
        assertEquals(initialDistance, result.getCalculatedInitialDistance(), initialDistance * 0.05);
    }

    @Test
    public void testGenerateResponseVelocity() {
        RadarResponse result = radar.generateResponse();
        assertEquals(velocity, result.getCalculatedVelocity(), velocity * 0.1);
    }

    @Test
    public void testGenerateResponseFinalDistance() {
        RadarResponse result = radar.generateResponse();
        assertEquals(finalDistance, result.getCalculateFinalDistance(), initialDistance * 0.05);
    }
}
