/*
 * Formation: basic menu sample.
 */

package basic.menu.ui;

/**
 * <p>
 * {@link UserInterface} that use standard output to interact with the user.
 * </p>
 * 
 * @author Guillaume DROUET
 */
@FunctionalInterface
public interface UserInterfaceWriter {
   
    /**
     * <p>
     * Shows a message.
     * </p>
     * 
     * @param message the message to show.
     */
    void info(String message);
}
