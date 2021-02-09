package com.DataStructure;

/**
 * OddHeapDecorator class decorate Heap class. This is achieved by modifying
 * toArray and toString methods of existing Heap class.
 */

public class OddHeapDecorator extends Decorator {

	public OddHeapDecorator(OddDecorator oddDecorator) {

		super(oddDecorator);
	}
	/**
	 * This method modifies/Decorates toString method of Heap.
	 */
	@Override
	public String toString() {
		Heap heap = oddDecorator.getHeap();
		OddFilter iterator = new OddFilter(heap.getIterator());
		String result = new String();
		while (iterator.hasNext()) {
			result += iterator.next().toString() + " ";
		}
		return result;
	}
	/**
	 * This method modifies/Decorates toArray method of Heap.
	 */
	@Override
	public String[] toArray() {
		int i = 0;
		Heap heap = oddDecorator.getHeap();
		OddFilter iterator = new OddFilter(heap.getIterator());
		String result[] = new String[heap.getOddCount()];
		while (iterator.hasNext())
			result[i++] = iterator.next().toString();
		return result;

	}

}
