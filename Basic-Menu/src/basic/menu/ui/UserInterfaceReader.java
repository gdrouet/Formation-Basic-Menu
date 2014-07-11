/*
 * Formation: basic menu sample.
 */

package basic.menu.ui;

import java.io.IOException;

/**
 * <p>
 * {@link UserInterface} that use standard input to interact with the user.
 * </p>
 * 
 * @author Guillaume DROUET
 */
@FunctionalInterface
public interface UserInterfaceReader {
        
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
