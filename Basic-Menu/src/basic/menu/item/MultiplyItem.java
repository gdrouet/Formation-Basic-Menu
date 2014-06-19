/*
 * Formation: basic menu sample.
 */

package basic.menu.item;

/**
 * <p>
 * Items for multiplication.
 * </p>
 *
 * @author Guillaume DROUET
 */
class MultiplyItem extends AccumulatorItem {

    /**
     * <p>
     * Builds a new instance.
     * </p>
     */
    MultiplyItem() {
        super("Multiply");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int accumulate(final int what, final int with) {
        return what + with;
    }
}
