package nullObject;

/***
 * Node class represents node type objects which holds our heap elements.
 * Node class is data class.
 */
public class Node implements HeapNode {

    private Node leftChild;
    private Node rightChild;
    private Node parent;
    private Integer value;

    public Node(Integer element) {
        this.value = element;
        leftChild= new NullNode();
        rightChild= new NullNode();
    }

    public Node() {
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

    public void setValue(Integer element) {
        this.value = element;
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

    public int getSize() {
        return  1+ leftChild.getSize() + rightChild.getSize() ;
    }

    @Override
    public boolean isTraversed() {
        return true;
    }


}
