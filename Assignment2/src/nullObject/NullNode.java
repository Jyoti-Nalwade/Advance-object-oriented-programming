package nullObject;

/**
 * This class represent nullNode objects which hold do nothing
 * behaviour NullNode class participates in Null object design pattern.
 */
public class NullNode extends Node implements HeapNode {

	public NullNode() {
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public boolean isTraversed() {
		return false;
	}

}