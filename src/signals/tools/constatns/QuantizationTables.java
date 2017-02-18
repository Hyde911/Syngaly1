/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.tools.constatns;

/**
 *
 * @author marr
 */
public class QuantizationTables {

    public static double[] ONE = {0, 0.5, 1};
    public static double[] TWO = {0, 0.25, 0.5, 0.75, 1};
    public static double[] FOUR;
    public static double[] SIX;
    public static double[] EIGHT;
    public static double[] TWELVE;
    public static double[] SIXTEEN;

    static {
        FOUR = GenerateTable(4);
        SIX = GenerateTable(6);
        EIGHT = GenerateTable(8);
        TWELVE = GenerateTable(12);
        SIXTEEN = GenerateTable(16);
    }

    private static double[] GenerateTable(int bits) {
        int values = (int) Math.pow(2, bits);
        double[] result = new double[values + 1];
        for (int i = 1; i <= values; i++) {
            result[i] = 1.0 * i / values;
        }
        return result;
    }
}
