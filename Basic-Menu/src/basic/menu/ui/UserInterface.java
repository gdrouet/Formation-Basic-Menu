/*
 * Formation: basic menu sample.
 */

package basic.menu.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * <p>
 * This interface defines interaction contract with a user.
 * </p>
 * 
 * @author Guillaume DROUET
 */
public interface UserInterface extends UserInterfaceReader, UserInterfaceWriter {
    
    /**
     * <p>
     * Builds a default instance.
     * </p>
     * 
     * @return the default implementation's instance
     */
    static UserInterface createDefault() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final PrintStream writer = System.out;
    
        final UserInterfaceWriter uiw = (message) -> writer.println(message);
        final UserInterfaceReader uir = () -> reader.readLine();

        return new UserInterface() {

            @Override
            public String read() throws IOException {
                return uir.read();
            }

            @Override
            public void info(String message) {
                uiw.info(message);
            }
        };
    };
    
    /**
     * <p>
     * Helper that prints the given message and optionally prints "Please press enter to continue"
     * message. Always wait the user enters something.
     * </p>
     * 
     * @param msg the message to always prints
     * @param enter optionnally prints "please enter..."
     * @return the value entered by user
     * @throws IOException if I/O error occurs 
     */
    default String printEnterContinue(final String msg, final boolean enter) throws IOException {
        info(msg);
        
        if (enter) {
            info("Please press enter to continue");
        }
        
        return read();
    }
}
