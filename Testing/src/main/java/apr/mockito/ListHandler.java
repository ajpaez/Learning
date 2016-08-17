package apr.mockito;

import java.util.List;

public interface ListHandler {

	/**
	 * Adds an element to the specified list implementation.
	 *
	 * @param list
	 *            An implementation of List.
	 * @param element
	 *            The element to add.
	 * @return The returned value by list.
	 */
	public boolean add(List<?> list, Object element);

	/**
	 * Removes the element at the specified position from the list
	 * implementation.
	 *
	 * @param list
	 *            An implementation of List.
	 * @param index
	 *            The index to be removed.
	 * @return The element previously at the specified position.
	 */
	public Object remove(List<?> list, int index);

}
