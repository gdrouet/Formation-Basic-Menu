/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

import basic.menu.ui.UserInterface;
import java.io.IOException;

/**
 * <p>
 * Menu item interface.
 * </p>
 * 
 * @author Guillaume DROUET
 */
public interface MenuItem {

    /**
     * <p>
     * Builds a default instance.
     * </p>
     * 
     * @return the default implementation's instance
     */
    static MenuItem[] createDefault() {
        return new MenuItem[] {
            new AccumulatorItem("Plus", (a, b) -> a + b, 0),
            new AccumulatorItem("Multiply", (a, b) -> a * b, 1),
            new FactorialItem(),
        };
    };
    
    /**
     * <p>
     * Returns the title of this item.
     * </p>
     * 
     * @return 
     */
    String title();
    
    /**
     * <p>
     * Interacts with the user.
     * </p>
     * 
     * @param ui the {@link UserInterface} to use to interact
     * @return the result of interaction
     * @throws IOException if any I/O error occurs
     */
    String interact(UserInterface ui) throws IOException ;
}
