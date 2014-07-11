/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

import basic.menu.ui.UserInterface;
import java.util.function.BiFunction;

/**
 * <p>
 * This items is an accumuluator to provide accumulation of values collected
 * during interaction with the user.
 * </p>
 * 
 * <p>
 * An accumulator requires at least to values and don't have maximum values to
 * be entered by the user.
 * </p>
 *
 * @author Guillaume DROUET
 */
class AccumulatorItem extends AbstractItem {

    /**
     * Performs accumulation.
     */
    private final BiFunction<Integer, Integer, Integer> operation;
    
    /**
     * Starter value for accumulation.
     */
    private final int starter;
    
    /**
     * <p>
     * Builds an item with a title.
     * </p>
     * 
     * @param title title
     * @param op the operation that cumumates
     * @param accumation the accumulation initial value
     */
    AccumulatorItem(final String title,
            final BiFunction<Integer, Integer, Integer> op,
            final int accumulation) {
        super(title);
        operation = op;
        starter = accumulation;
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
        
        int res = starter;
        
        for (String v : data) {
            
            // Read the end of what the user entered
            if (v == null) {
                break;
            }
            
            res = operation.apply(res, Integer.parseInt(v));
        }
        
        return String.valueOf(res);
    }
}
