package com.DataStructure;

import nullObject.Node;
import nullObject.NullNode;
import strategy.Strategy;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.function.Consumer;

/***
 * Heap class represents heap type objects.strategy object will be passed
 * to this class which will decide either to be minHeap or MaxHeap.
 * Heap implements Container interface in order to create iterator on heap,
 * implements OddDecorator interface to decorate existing Heap class.
 * This class extends java's default AbstractQueue class to override some of its
 * operations/methods add, toArray, toString, size, peek etc.
 */
public class Heap extends AbstractQueue<Integer> implements Container, OddDecorator {

    private Node root;

    // This strategy object is accepted as an
    // argument during the instantiation of the heap at runtime, hence we can
    // easily create different heap objects which have different formulae to
    // satisfy minHeap and MaxHeap requirements .
    private Strategy strategy;
    private boolean isFirstElement;
    private int oddCount;

    public Node getRoot() {
        return root;
    }

    public Heap() {
        isFirstElement = true;
    }
    public Heap getHeap() {
        return this;
    }
    protected int getOddCount() {
        return oddCount;
    }
    private void setRoot(Node root) {
        this.root = root;
    }

    public void setHeapStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int size() {
        return root.getSize();
    }

    /**
     * The add(E) method adds a node to the heap
     * This is done based on the subHeap height, node will be added to the proper
     * location in heap structure.
     * values will be swapped if needed to satisfy heap algorithm.
     */
    @Override
    public boolean add(Integer e) {
        if (e%2!=0){oddCount++;}
        if (isFirstElement) {
            this.setRoot(new Node(e));
            isFirstElement = false;
        } else
            add(e, root);
            return true;
        }
    @Override
    public boolean isEmpty() {
        if (isFirstElement){return true;}
        return false;
    }
    /**
     * Simply returns the root element of the heap.
     */
    @Override
    public Integer peek() {
        return root.getValue();
    }
    @Override
    public Object[] toArray() {
        int i = 0;
        Iterator iterator = this.getIterator();
        String[] result = new String[this.size()];
        while (iterator.hasNext())
            result[i++] = iterator.next().toString();
        return result;
    }

    @Override
    public String toString() {
        Iterator iterator = this.getIterator();
        String result = new String();
        while (iterator.hasNext()) {
            result += iterator.next().toString() + " ";
        }
        return result;
    }
    @Override
    public java.util.Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }
    //This will simply clear the heap by making root null.
    @Override
    public void clear() {
        this.setRoot(new NullNode());
        isFirstElement = true;
    }
    /**
     * This method insert element into the heap.
     * This method works recursive manner until element get inserted into heap
     * at desired position.MinHeap/MaxHeap algorithm constructed based on strategy passed.
     * @param value
     * @param root
     */
    private void add(Integer value, Node root) {
        if (!root.getLeftChild().isTraversed()) {
            root.setLeftChild(new Node(value));
            root.getLeftChild().setParent(root);
            swap(root, root.getLeftChild());

        } else if (!root.getRightChild().isTraversed()) {
            root.setRightChild(new Node(value));
            root.getRightChild().setParent(root);
            swap(root, root.getRightChild());
        } else if (
                root.getLeftChild().getSize() <= root.getRightChild().getSize()) {
            add(value, root.getLeftChild());
        } else {
            add(value, root.getRightChild());
        }
    }

    public void swap(Node parent, Node child) {
        Integer swapValue;
        if(strategy.notCorrectLocation(parent,child)){
            swapValue = parent.getValue();
            parent.setValue(child.getValue());
            child.setValue(swapValue);
        }
        if (parent.getParent() != null) {
            if (strategy.notCorrectLocation(parent.getParent(),parent)) {
                swap(parent.getParent(), parent);
            }
        }
    }

    //STUBBED METHODS
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
    // Iterator class to implement iterator on heap class.
    // This iterator iterate heap and provide values in InOrder manner.

    private class HeapIterator implements Iterator {
        private Stack<Node> heapStack = new Stack<Node>();
        private Node currentNode;
        private Node currentElement;

        public Node getCurrentElement() {
            return currentElement;
        }
        public HeapIterator(Node currentNode) {
            this.currentNode = currentNode;
            while (currentNode.isTraversed()) {
                heapStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
        }
        @Override
        public boolean hasNext() {
          return !heapStack.isEmpty();
        }
        @Override
        public Node next() {
            currentNode = heapStack.pop();
            currentElement = currentNode;
            if (currentNode.getRightChild().isTraversed()) {
                currentNode = currentNode.getRightChild();
                while (currentNode.isTraversed()) {
                    heapStack.push(currentNode);
                    currentNode = currentNode.getLeftChild();
                }
            }
            return currentElement;
        }
    }

    public ArrayList<Integer> preOrderTraverse(Node root, ArrayList<Integer> heapValues) {
        if (root.isTraversed()) {
            heapValues.add(root.getValue());
            preOrderTraverse(root.getLeftChild(), heapValues);
            preOrderTraverse(root.getRightChild(), heapValues);
        }
        return heapValues;
    }

    public ArrayList<Integer> postOrderTraverse(Node root, ArrayList<Integer> heapValues) {
        if (root.isTraversed()) {
            postOrderTraverse(root.getLeftChild(), heapValues);
            postOrderTraverse(root.getRightChild(), heapValues);
            heapValues.add(root.getValue());
        }
        return heapValues;
    }

    @Override
    public Iterator getIterator() {
        return new HeapIterator(root);
    }
}
