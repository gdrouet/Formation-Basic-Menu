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
 * {@link UserInterface} that user standard I/O to interact with the user.
 * </p>
 * 
 * @author Guillaume DROUET
 */
class StdIoUserInterface implements UserInterface {

    /**
     * The input.
     */
    private final BufferedReader reader;
    
    /**
     * The output.
     */
    private final PrintStream writer;

    /**
     * <p>
     * Builds a new instance.
     * </p>
     */
    StdIoUserInterface() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = System.out;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void info(final String message) {
        writer.println(message);
    }
   
    /**
     * {@inheritDoc}
     */
    @Override
    public String read() throws IOException {
        return reader.readLine();
    }    
}
