/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.gui;

import java.io.File;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import signals1.signals.abstracts.Signals;

/**
 *
 * @author glabg
 */
public class GUIHelper {

    private static final Class helperClass = GUIHelper.class;

    public static void actionLocator(String action, File file, int id) {
        try {
            Method actionMethod = helperClass.getMethod(action, File.class);
            actionMethod.invoke(null, file);
        } catch (Exception ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
            //DSAMainWindow.showError(ex, "Błąd Pliku", "Błąd Pliku");
        }
    }

    public static void saveCurrentToFile(final File file, final int id) {
        //DSAMainWindow.getInstance().setInputFile(file);
    }

    public static void readCurrentFromFile(final File file, final int id) {
       // DSAMainWindow.getInstance().saveDS(file);
    }

}
