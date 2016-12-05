/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools.quantisation;

import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marr
 */
public class MeanQuantizerTest {
    
    private MeanQuantizer quan = new MeanQuantizer(12);
    
    public MeanQuantizerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of quantizeSample method, of class MeanQuantizer.
     */
    @Test
    public void testQuantizeSample() {
        Complex val = new Complex(1, 0);
        System.out.println(quan.quantizeSample(val, 100));
    }
    
}
