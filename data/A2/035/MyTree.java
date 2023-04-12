/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree
	
	private int item;
    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // constructors
	public MyNode(int item) {
		//initialise a tree node with item and no children
		this.item = item;
		leftChildIndex = null;
		rightChildIndex = null;
	} // end Constructor

	public MyNode(int item, int left, int right) {
		//initialise a tree with item and left and right children
		this.item = item;
		this.leftChildIndex = left;
		this.rightChildIndex = right;
	} // end constructor

	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getLeft() {
		//returns the index of the left child
		return this.leftChildIndex;
	}

	public void setLeft(int left) {
		// sets the leftChildIndex to left
		leftChildIndex = left;
	}

	public int getRight() {
		// returns the index of the right child
		return this.rightChildIndex;
	}

	public void setRight(int right) {
		// set the rightChildIndex to right
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

	private int root; // index of the tree's root
	private int free; // index of the next unused array location
	private int currentIndex; //index of current node

    // fill in your ADT methods here
    // constructors
	public MyTree() {
		root = null;
	} // end default constructor

	public MyTree(int rootIndex, int rootItem) {
		root = rootIndex;
		myTree[root].setItem();
		++size;
		free = rootIndex + 1;
		setCurrentIndex(rootIndex);
	} // end constructor

	public int currentIndex() {
		return this.currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public boolean isEmpty() {
		return (root == null);
	} // end isEmpty

	public void makeEmpty() {
		//removes all nodes from tree
		root = null;
	} // end makeEmpty

	public int getRootItem() {
		// returns the item in the tree's root
		return myTree[root].getItem();
	} // end getRootItem

	//argh don't know how to do!!!

	public void setLeft(int leftItem) {
		if (!isEmpty() && myTree[current].getLeft() == null) {
			myTree[current].setLeftIndex(free);
			++free;
			myTree[current].setLeftItem(leftItem);
			++size;
		}
	} // end setLeft

	public void setRight(int rightItem) {
		if (!isEmpty() && myTree[current].getRight() == null) {
			myTree[current].setRightIndex(free);
			++free;
			myTree[current].setRightItem(rightItem);
			++size;
		}
	}
}
