package strategy;

import nullObject.Node;

public class MinHeapComparison implements Strategy {

    public boolean notCorrectLocation(Node parent, Node child){
        return parent.getValue() > child.getValue();
    }
}
