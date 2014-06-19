/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

import basic.menu.ui.UserInterface;

/**
 * <p>
 * This items is an accumuluator to provide accumulation of values collected
 * during interaction with the user.
 * </p>
 * 
 * </p>
 * An accumulator requires at least to values and don't have maximum values to
 * be entered by the user.
 * </p>
 *
 * @author Guillaume DROUET
 */
abstract class AccumulatorItem extends AbstractItem {

    /**
     * <p>
     * Builds an item with a title.
     * </p>
     * 
     * @param title title
     */
    AccumulatorItem(final String title) {
        super(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final int minVal() {
        return 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final int maxVal() {
        return -1;
    }    
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected String interact(final UserInterface ui, final String[] data) {
        // Rule broken
        if (data == null) {
            return null;
        }
        
        int res = 0;
        
        for (String v : data) {
            
            // Read the end of what the user entered
            if (v == null) {
                break;
            }
            
            res = accumulate(res, Integer.parseInt(v));
        }
        
        return String.valueOf(res);
    }
    
    /**
     * <p>
     * Performs accumulation.
     * </p>
     * 
     * @param what current value
     * @param with value to accumulate
     * @return the result of accumulation
     */
    protected abstract int accumulate(int what, int with);
}
