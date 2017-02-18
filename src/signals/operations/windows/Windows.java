/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signals.operations.windows;

/**
 *
 * @author glabg
 */
public class Windows {

    public enum Types {
        HAMM("Hamming'a"),
        HANN("Hanning'a"),
        BLACK("Blackman'a");
        private final String display;

        private Types(String s) {
            display = s;
        }

        @Override
        public String toString() {
            return display;
        }
    }

    Types type;

    public Windows(Windows.Types type) {
        this.type = type;
    }

    public WindowFunction getWindows() {
        switch (type) {
            case HAMM:
                return new HammingWindow();
            case HANN:
                return new HanningWindow();
            case BLACK:
                return new BlackmanWindow();
            default:
                return null;
        }
    }

}
