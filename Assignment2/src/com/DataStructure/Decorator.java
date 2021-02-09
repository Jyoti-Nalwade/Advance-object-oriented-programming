package com.DataStructure;

/**
 * Decorator class Decorates existing Heap class in order to add
 * odd filter functionality without changing existing heap class
 * Heap Decorator class implements OddDecorator.
 */

public class Decorator extends Heap implements OddDecorator {

	protected OddDecorator oddDecorator;

	public Decorator(OddDecorator oddDecorator) {

		this.oddDecorator = oddDecorator;
	}

	public String toString() {
		return oddDecorator.toString();
	}

	public Object[] toArray() {
		return oddDecorator.toArray();
	}

	@Override
	public Heap getHeap() {
		return oddDecorator.getHeap();
	}

}