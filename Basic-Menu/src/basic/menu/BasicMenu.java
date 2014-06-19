/*
 * Formation: basic menu sample.
 */

package basic.menu;

import basic.menu.item.MenuItem;
import basic.menu.ui.UserInterface;
import java.io.IOException;

/**
 * <p>
 * Main class that launches the basic menu.
 * </p>
 *
 * @author Guillaume DROUET
 */
public class BasicMenu {
    
    /**
     * <p>
     * Main method.
     * </p>
     * 
     * @param args the command line arguments
     * @throws IOException if any I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        final MenuItem[] items = MenuItem.createDefault();
        final UserInterface ui = UserInterface.createDefault();
        
        // Loop while the user doesn't leave
        for (;;) {
            // Display menu
            for (int i = 0; i < items.length; i++) {
                ui.info((i + 1) + ". " + items[i].title());
            }
            
            // Always display the exit option
            ui.info((items.length + 1) + ". Exit");
            ui.info("Choice:");
            
            // Read choice
            final int choice = Integer.parseInt(ui.read());
            
            // Will contain the result of any interaction selected by user
            String res = null;
            
            // Evaluate the choice
            if (choice > 0) {
                if (choice <= items.length) {
                    res = items[choice - 1].interact(ui);
                } else if (choice == items.length + 1) {
                    ui.info("Bye.");
                    break;
                } else {
                    ui.info("Bad choice.");
                }
            }
            
            // Something to print
            if (res != null) {
                ui.printEnterContinue("Result: " + res, true);
            }
        }
    }
}
