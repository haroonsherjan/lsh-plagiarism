/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
	private int item;
	private MyNode leftChild;
	private MyNode rightChild;
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...
	public MyNode (int newItem) {
		item = newItem;
		leftChild = null;
		rightChild = null;
	}

	public MyNode(int newItem, MyNode left, MyNode right) {
		item = newItem;
		leftChild = left;
		rightChild = right;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int newItem) {
		item = newItem;
	}

	public MyNode getLeft() {
		return leftChild;
	}

	public void setLeft(MyNode left) {
		leftChild = left;
	}

	public MyNode getRight() {
		return rightChild;
	}

	public void setRight(MyNode right) {
		rightChild = right;
	}

	public int getLeftChildIndex() {
		return leftChildIndex;
	}

	public void setLeftChildIndex(int leftindex) {
		leftChildIndex = leftindex;
	}

	public int getRightChildIndex() {
		return rightChildIndex;
	}

	public void setRightChildIndex(int rightindex) {
		rightChildIndex = rightindex;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree extends BinaryTreeBasic {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    // private final int MAX_NODES = 1000;
    // MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;

	public MyTree() {
	}

	public MyTree(int rootItem) {
		super(rootItem);
	}

	public void leftChild(int left) {
		root = insertItem(root, left, "odd");
	}

	public void rightChild(int right) {
		root = insertItem(root, right, "even");
	}

	protected MyNode insertItem(MyNode tNode, int newItem, String position) {
		MyNode newSubtree;
		MyNode value = null;

		if (tNode == null) {
			tNode = new MyNode(newItem, null, null);
			return tNode;
		}
		int nodeItem = tNode.getItem();

		if (position.equals("odd")) {
			if (newItem == -1) {
				value = null;
			}
			else {
				newSubtree = insertItem(tNode.getLeft(), newItem, "odd");
				tNode.setLeft(newSubtree);
				tNode.setLeftChildIndex(++size);
				value = tNode;
			}
		}
		else if (position.equals("even")) {
			if (newItem == -1) {
				value = tNode;
			}
			else {
				newSubtree = insertItem(tNode.getRight(), newItem, "even");
				tNode.setRight(newSubtree);
				tNode.setRightChildIndex(++size);
				value = tNode;
			}
		}
		return value;
	}

	// use num to represent the printing method
	// with the given node, check the left child first if it equals to the other node
	// if it is then it is a descendant, given no. 1
	// use the given node to find its root, if the other node equals to it, then it is ancestor
	// to check left or right, 

	
}

abstract class BinaryTreeBasic {
	protected MyNode root;
	protected MyNode left;
	protected MyNode right;

	public BinaryTreeBasic() {
		root = null;
	}

	public BinaryTreeBasic(int rootItem) {
		root = new MyNode(rootItem, null, null);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

	public int getRootItem() {
		return root.getItem();
	}

	public MyNode getLeft() {
		return left.getLeft();
	}

	public MyNode getRight() {
		return right.getRight();
	}
}

class TreeException extends RuntimeException {
	public TreeException(String s) {
		super(s);
	}
}
