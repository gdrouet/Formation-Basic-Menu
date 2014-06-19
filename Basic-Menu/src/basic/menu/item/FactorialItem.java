/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

import basic.menu.ui.UserInterface;

/**
 * <p>
 * Computes the factorial. Requires one and only one value to be entered by the
 * user.
 * </p>
 * 
 * @author Guillaume DROUET
 */
class FactorialItem extends AbstractItem {

    /**
     * <p>
     * Builds a new instance.
     * </p>
     */
    FactorialItem() {
        super("Factorial");
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
        
        int res = Integer.parseInt(data[0]);
        
        for (int v = res - 1; v > 1; v--) {
            res *= v;
        }
        
        return String.valueOf(res);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final int minVal() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final int maxVal() {
        return 1;
    }
}
