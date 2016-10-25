/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import signals1.signals.abstracts.Signals;
import signals1.signals.discrete.DescreetSignal;

/**
 *
 * @author glabg
 */
public class SignalSerializationHelper {

    public static void saveSignal(Signals signal, File writeFile) {
        try (FileOutputStream fos = new FileOutputStream(writeFile)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(signal);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SignalSerializationHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SignalSerializationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DescreetSignal ReadSignal(File readFile) throws IOException, ClassNotFoundException {
        DescreetSignal result = null;
        try (FileInputStream fis = new FileInputStream(readFile)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (DescreetSignal) ois.readObject();
            ois.close();
            fis.close();
        }
        
        return result;
    }
}
