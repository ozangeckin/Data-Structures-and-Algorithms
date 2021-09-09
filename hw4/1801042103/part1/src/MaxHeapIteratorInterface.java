//package part1;

/**
 * This interface extends in the iterator class and also defined in the set function required in the assignment.
 * @author Ozan GECKIN
 */
import java.util.Iterator;

public interface MaxHeapIteratorInterface<T> extends Iterator{

	public void setValue(T value);
}
