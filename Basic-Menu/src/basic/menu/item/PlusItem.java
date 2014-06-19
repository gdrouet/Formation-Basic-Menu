/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

/**
 * <p>
 * Menu item for addition.
 * </p>
 * 
 * @author Guillaume DROUET
 */
class PlusItem extends AccumulatorItem {

    /**
     * <p>
     * Builds a new instance.
     * </p>
     */
    PlusItem() {
        super("Addition");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int accumulate(final int what, final int with) {
        return what + with;
    }
}
