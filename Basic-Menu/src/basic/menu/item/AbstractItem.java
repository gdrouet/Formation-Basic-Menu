/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

import basic.menu.ui.UserInterface;
import java.io.IOException;

/**
 * <p>
 * An abstract item provide a mechanism to read a set of values provided during
 * the interaction with the user.
 * </p>
 *
 * @author Guillaume DROUET
 */
abstract class AbstractItem implements MenuItem {

    /**
     * String displayed when reading values from the user.
     */
    private static final String READ_MESSAGE =
            "Please enter an integer and then press enter (empty to finish)";
    
    /**
     * The item title.
     */
    private final String title;
    
    /**
     * <p>
     * Builds an item with a title.
     * </p>
     * 
     * @param title title
     */
    public AbstractItem(final String title) {
        this.title = title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String title() {
        return title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String interact(final UserInterface ui) throws IOException {
        return interact(ui, readValues(ui));
    }
    
    /**
     * <p>
     * Reads the values entered by the user. The values are parsed into integers
     * and bad values won't be managed (exception will occur).
     * </p>
     * 
     * <p>
     * A {@link #minVal()} and {@link #minVal() (number of values to be entered)
     * are used here. If a rule is broken, the method will return a {@code null}
     * array.
     * </p>
     * 
     * <p>
     * Otherwise, an array of 4000 elements will be return. User has to check
     * when the value becomes {@code null} which means this is the end of what
     * the user entered.
     * <p>
     * 
     * @param ui the user interface
     * @return the array of entered values
     * @throws IOException if I/O error occurs 
     */
    public String[] readValues(final UserInterface ui)  throws IOException {
        final int minVal = minVal();
        final int maxVal = maxVal();
        int nbValues = 0;
        String[] values = new String[4000];

        String val;

        // Apply max if necessary and reads until the user enters an empty string
        while ((maxVal == -1 || nbValues < maxVal)
                && !"".equals(val = ui.printEnterContinue(READ_MESSAGE, false))) {
            values[nbValues++] = val;
        }
        
        String error = "";
        
        // Min rule broken
        if (minVal > -1 && nbValues < minVal) {
            error += "You must enter at least " + minVal + " values.\n";
        }
        
        // At least one rule is broken
        if (!error.isEmpty()) {
            ui.printEnterContinue(error, true);
            return null;
        }
        
        return values;
    }
    
    /**
     * <p>
     * Continue interaction after the user entered its data
     * </p>
     * @param ui
     * @param data
     * @return 
     */
    protected abstract String interact(UserInterface ui, String[] data);
    
    /**
     * <p>
     * Minimal number of values entered by user.
     * </p>
     * 
     * @return the minimal value (-1 if no min)
     */
    protected abstract int minVal();
    
    /**
     * <p>
     * Maximal number of values entered by user.
     * </p>
     * 
     * @return the maximal value (-1 if no max)
     */
    protected abstract int maxVal();
}
