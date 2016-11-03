/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.stats;

/**
 *
 * @author marr
 */
public class Histogram {

    protected double[] realHistogram;
    protected double[] imgHistogram;

    public Histogram(double[] realHistogram, double[] imgHistogram) {
        this.realHistogram = realHistogram;
        this.imgHistogram = imgHistogram;
    }

    public double[] getRealHistogram() {
        return realHistogram;
    }

    public double[] getImgHistogram() {
        return imgHistogram;
    }
}
