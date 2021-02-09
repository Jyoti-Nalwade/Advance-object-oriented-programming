/*
package com.DataStructure;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    // test to ensure it returns null when tree is empty
    @Test
    void getFromEmptyTree() {
        Heap tree = new Heap();
        //assertNull(tree.getRoot());
        assertEquals(Boolean.TRUE, tree.isEmpty());
        assertNotEquals(Boolean.FALSE, tree.isEmpty());
    }

    // test to ensure Nodes are getting added correctly(to minimum height subtree)
    @Test
    void addNodeTest() {
        Heap tree = new Heap();
        tree.add(20);
       // assertNotNull(tree.getRoot());
       // assertTrue(tree.getRoot().getValue() == 20);
        tree.add(23);
       // assertTrue(tree.getRoot().getLeftChild().getValue() == 23);
       // assertNotNull(tree.getRoot().getLeftChild());
       // assertNull(tree.getRoot().getRightChild());
    }

    //test to ensure getting subHeap Height correctly.
    @Test
    void subHeapHeightTest() {
        Heap tree = new Heap();
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(1);
       // assertEquals(2, tree.treeHeight(tree.Root().getLeftChild()));
       // assertEquals(1, tree.treeHeight(tree.getRoot().getRightChild()));
    }

    // test to ensure Root is the minimum value Node.
    @Test
    void minRootValueTest() {
        Heap tree = new Heap();
        assertEquals(-2147483648, tree.peek());
        tree.add(3);
        tree.add(8);
        tree.add(6);
        tree.add(1);
        assertEquals(1, tree.peek());
        assertNotEquals(8, tree.peek());
    }

    //Test to check swap of child parent works correctly.
    @Test
    public void swapTest() {
        Heap tree = new Heap();
        Node childNode = new Node(1);
        childNode.setLeftChild(null);
        childNode.setRightChild(null);
        Node parentNode = new Node(6);
        parentNode.setLeftChild(childNode);
        parentNode.setRightChild(null);
        tree.swapTreeNodesValues(parentNode, childNode);
        assertEquals(1, parentNode.getValue());
        assertEquals(6, childNode.getValue());
    }

    // Test to confirm the preorder traversal works fine.
   */
/* @Test
    void preOrderOddNumbersTest() {
        Heap tree = new Heap();
        tree.addNode(3);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(1);
        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        tree.preOrderTraverse(tree.getRoot(), treeValues);
        actual.addAll(tree.getTreeValues());
        assertEquals(expected, actual);
    }*//*


    */
/*//*
/test to confirm Postorder works fine.
    @Test
    void postOrderTraverseTest() {

        Heap tree = new Heap();
        tree.addNode(3);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(1);
        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        expected.add(4);
        expected.add(1);
        tree.postOrderTraverse(tree.getRoot(), treeValues);
        actual.addAll(tree.getTreeValues());
        assertEquals(expected, actual);
    }
*//*

}*/
