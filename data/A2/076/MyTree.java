/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int item;

	MyNode leftChild;
	MyNode rightChild;

	public MyNode (int newItem) {
		item = newItem;
		leftChild.setItem(-1);
		rightChild.setItem(-1);

	}

	public MyNode (int newItem, MyNode left, MyNode right) {
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

	public MyNode getRight() {
		return rightChild; 
	}

	public void setLeft(MyNode left) {
		leftChild = left;
	}

	public void setRight(MyNode right) {
		rightChild = right;
	}   
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

//    private final int MAX_NODES = 1000;
//    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	
	protected MyNode root;
	
	public MyTree() {
		root = null;
		size++;          //size is even left node, right is odd 
	}

	


	public void insertLeft (int newItem) {
		root = insertLeftItem(root, newItem);
	}

	protected MyNode insertLeftItem (MyNode node, int newItem) {
		MyNode newNode;

		if (node == null) {
			newNode = new MyNode(newItem, null, null);
			size++;
			return newNode;

		}
		else if (node.getLeft().getItem() != -1) {
			newNode = insertLeftItem(node.getLeft(), newItem);
			node.setLeft(newNode);
			return node;
		}
		else return null;
	}

	public void insertRight (int newItem) {
		root = insertRightItem(root, newItem);
	}

	protected MyNode insertRightItem (MyNode node, int newItem) {
		MyNode newNode;

		if (node == null) {
			newNode = new MyNode(newItem, null, null);
			size++;
			return newNode;
		}
		else if (node.getRight().getItem() != -1) {
			newNode = insertRightItem(node.getRight(), newItem);
			node.setRight(newNode);
			return node;
		}
		else return null;
	} //end insertRigh
	
	String query(int leftQuery, int rightQuery) {    // to compare the index numbers and determine the status
		
		
		return null;

	}
	
	public void queryLeft(int leftQuery){        // to return the index found left
		
	}

	public void queryRight(int rightQuery) {    // to return the index found rgiht

	}
}// end MyTree
