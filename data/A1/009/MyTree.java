/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int item;

    // fill in your accessor and mutator methods here
    // ...

	public MyNode (int newItem) {
		//Initializes tree node with item and no children.
		item = newItem;
	}
	
	public MyNode (int newItem, int left, int right) {
		//Initializes tree node with item and the left and right children references.
		item = newItem;
		leftChildIndex = left;
		rightChildIndex = right;
	} 

	public int getItem(){
		//Return the item field.
		return item;
	}

	public void setItem(int newItem) {
		//Sets the item field to the new value newcity.
		item = newItem;
	}

	public int getLeft() {
		//Returns the reference to the left child.
		return leftChildIndex;
	}

	public void setLeft(int left) {
		//Sets the left child reference to left.
		leftChildIndex = left;
	}

	public int getRight() {
		//Returns the reference to the right child.
		return rightChildIndex;
	}

	public void setRight(int right) {
		//Sets the right child reference to right.
		rightChildIndex = right;
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

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

	private MyNode root;

    // fill in your ADT methods here
    // ...

	public MyTree() {
		root = null;
	}

	public MyTree(int rootItem) {
		root = new MyNode(rootItem);
	}
	
	public boolean isEmpty() {
		//Returns true if the tree is empty, else returns false.
		return root == null;
	}

	public void makeEmpty() {
		//Removes all nodes from the tree.
		root = null;
	}

	public int getRootItem() {
		//Returns the item in the tree's root.
		return root.getItem();
	}

	public void setRootItem(int newItem) {
		//Set Root item
		if (root != null) {
			root.setItem(newItem);
		}
		else {
			root = new MyNode(newItem);
		}
	}

	public void attachLeft(int newItem) {

	}

	public void attachRight(int newItem) {
	
	}

}
