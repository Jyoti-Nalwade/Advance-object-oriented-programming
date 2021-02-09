package com.DataStructure;

import nullObject.Node;

/**
 * OddFilter class designed to implement oddIterator.
 * OddFilter constructor accept iterator as an argument, Operations are to
 * be performed on default iterator to get odd Iterator.
 */

public class OddFilter {

	private Iterator oddIterator;

	public OddFilter(Iterator iterator) {
		oddIterator = iterator;
	}

	public boolean hasNext() {
		while (oddIterator.hasNext()) {

			if (oddIterator.next().getValue()%2!=0) {
				return true;
			}
		}
		return false;
	}

	public Node next() {
		return oddIterator.getCurrentElement();
	}
}
