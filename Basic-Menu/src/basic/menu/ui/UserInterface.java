/*
 * Formation: basic menu sample.
 */

package basic.menu.ui;

import java.io.IOException;

/**
 * <p>
 * This interface defines interaction contract with a user.
 * </p>
 * 
 * @author Guillaume DROUET
 */
public interface UserInterface {
    
    /**
     * <p>
     * Builds a default instance.
     * </p>
     * 
     * @return the default implementation's instance
     */
    static UserInterface createDefault() {
        return new StdIoUserInterface();
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
    
    /**
     * <p>
     * Show a message.
     * </p>
     * 
     * @param message the message to show.
     */
    void info(String message);
    
    /**
     * <p>
     * Reads a value.
     * </p>
     * 
     * @return the read value
     * @throws IOException if an I/O error occurs
     */
    String read() throws IOException;
}
