/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals1.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import signals1.signals.abstracts.Signals;

/**
 *
 * @author glabg
 */
public class SignalSerializationHelper {

    public static void saveSignal(Signals signal, File fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName.getName());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(signal);
        fos.close();
    }

    public static Signals ReadSignal(Signals signal, String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Signals result = (Signals) ois.readObject();
        ois.close();
        return result;
    }
}
