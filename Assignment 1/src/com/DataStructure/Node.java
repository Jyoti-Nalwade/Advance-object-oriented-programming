package com.DataStructure;

public class Node {

    private Node leftChild; //left pointer for Node
    private Node rightChild; // Right pointer for Node
    private Node parent;
    private Integer value; // to Store Node value

    public Node(Integer data) {

        this.value = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer dataValue) {
        this.value = dataValue;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public static int getHeight(Node treeNode) {
        if (treeNode == null)
            return 0;
        else {
            return 1 + getHeight(treeNode.leftChild) + getHeight(treeNode.rightChild);//calculate right and left child height recursively
        }
    }

    /*
     *this is recursive function, If the child is smaller than parent then swap with the
     *parent and then percolate it upwards
     */

    public static void swapTreeNodesValues(Node parentNode, Node childNode) throws NullPointerException {
        Integer swapValue;
        if (parentNode.getValue() > childNode.getValue()) {
            swapValue = parentNode.getValue();
            parentNode.setValue(childNode.getValue());
            childNode.setValue(swapValue);
        }
        if (parentNode.getParent() != null) {
            if (parentNode.getParent().getValue() > parentNode.getValue()) {
                swapTreeNodesValues(parentNode.getParent(), parentNode);
            }
        }
    }


}