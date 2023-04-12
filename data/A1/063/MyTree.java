/** Class for a tree node
 */
class MyNode {
    private boolean isSafe;				  // is the city safe?
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array
	private int value;

	public void setValue(int a) {
		value = a;
	}

	public int getValue() {
		return value;
	}

	public boolean getSafety() {
		return isSafe;
	}

	public void setSafety(boolean safe) {
		isSafe = safe;
	}

	public void setLeft(int a) {
		leftChildIndex = a;
	}

	public int getLeft() {
		return leftChildIndex;
	}

	public void setRight(int a) {
		rightChildIndex = a;
	}

	public int getRight() {
		return rightChildIndex;
	}
}

public class MyTree {

    private final int MAX_NODES = 1000;
    MyNode[] myTree;
    int size;

	public MyTree() {
		myTree = new MyNode[MAX_NODES];
		size = 0;
	}

	public MyNode getNode(int i) {
		return myTree[i];
	}
	/*
	public void addNode(int left, int right, MyNode curr) {
		if(curr.getLeft == 0) {
			curr.setLeft(left);
		}else {
			addNode(left, right, curr.left);
		}
		if(curr.getRight == 0) {
			curr.setRight(right);
		} else {
			addNode(left, right, curr.right)
		}
	}*/
}
