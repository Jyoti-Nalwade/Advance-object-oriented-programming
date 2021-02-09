package com.DataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
	/*
 	* Min Heap is a Minheap implementation using reference(pointers).
 	* NOTE : This class provides add Node implementation.
 	* and print ODD tree values in preorder traversal.
 	* And also print tree values in PostOrder traversal.
 	*/
public class Heap<E> implements Collection<Integer> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Heap() {
       root = null;
    }

    // This method add Node to tree.
    /*public void add(Integer nodeValue) {
        if (this.isEmpty())
            root = new Node(nodeValue);
        else
            addHelper(nodeValue, root);
    }*/

        @Override
        public int size() {
            return 0;
        }

        public boolean isEmpty() {
        return root == null;
    }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }
        @Override
        public boolean add(Integer e) {
            if (this.isEmpty())
                root = new Node(e);
            else
                addHelper(e, root);
            return true;
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
        public void clear() {

        }

        /*
	 * this is helper method to add node in manner,where we check for the height of sub-heap
	 * and add the new node to the left of sub-
	 * we pass node and its value to be added in tree.
	 * If newly added node value is less than parent we swap vales.
	 */
    private void addHelper(Integer value, Node root) throws NullPointerException {
        if (root.getLeftChild() == null) {
            root.setLeftChild(new Node(value));
            root.getLeftChild().setParent(root);

                Node.swapTreeNodesValues(root, root.getLeftChild());

        } else if (root.getRightChild() == null) {
            root.setRightChild(new Node(value));
            root.getRightChild().setParent(root);

                Node.swapTreeNodesValues(root, root.getRightChild());

        } else if (Node.getHeight(root.getLeftChild()) <= Node.getHeight(root.getRightChild())) {
            addHelper(value, root.getLeftChild());
        } else {
            addHelper(value, root.getRightChild());
        }

    }

	//Gives Odd tree values in preorder Traversal manner
    private ArrayList<Integer> preOrderTraverse(Node treeNode, ArrayList<Integer> treeValues) {
        if (treeNode != null) {
            treeValues.add(treeNode.getValue());
            preOrderTraverse(treeNode.getLeftChild(), treeValues);
            preOrderTraverse(treeNode.getRightChild(), treeValues);
        }
        return treeValues;
    }
    //Gives tree values in postorder Traversal manner
    private ArrayList<Integer> postOrderTraverse(Node root, ArrayList<Integer> treeValues) {
        if (root != null) {
            postOrderTraverse(root.getLeftChild(), treeValues);
            postOrderTraverse(root.getRightChild(), treeValues);
            treeValues.add(root.getValue());
        }
        return treeValues;
    }

    //if tree is not empty Returns Root(minimum value) of MinHeapTree.
    private int peek() {
        if (root != null) {
            return root.getValue();
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        Integer nodeValue;
        Heap heap = new Heap();
        String inputString;
        Scanner scanIn = new Scanner(System.in);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(8);
        heap.add(3);
        /*do {
            System.out.println("Enter Integer values to add into MinHeap: ");
            nodeValue = scanIn.nextInt();
            heap.add(nodeValue);
            System.out.println("Do You want to add more values into the MinHeap y/n?: ");
            inputString = scanIn.next();
        } while (inputString.equalsIgnoreCase("y"));
        scanIn.close();*/
        //System.out.println(heap);
          ArrayList<Integer> treeValues = new ArrayList<>();
          heap.preOrderTraverse(heap.root,treeValues);
          System.out.println("\n MinHeap Tree in PreOrder:");
          System.out.println(treeValues);
//        System.out.println("\n Odd Numbers in MinHeap Tree in PreOrder:");
//        treeValues.stream().filter(i -> i % 2 != 0).forEach(System.out::println);
//        treeValues.clear();
//        System.out.println("\n MinHeap Values in PostOrder:");
//        heap.postOrderTraverse(heap.root,treeValues);
//        System.out.println(treeValues);

    }
}