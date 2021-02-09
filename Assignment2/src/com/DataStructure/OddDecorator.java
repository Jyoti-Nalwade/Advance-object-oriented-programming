package com.DataStructure;

/**
 * OddDecorator is an Interface implemented in order to implement Decorator patterns
 * This interface has three methods which in then implemented by heapDecorator class.
 */

public interface OddDecorator {

	Heap getHeap();

	String toString();

	Object[] toArray();
}