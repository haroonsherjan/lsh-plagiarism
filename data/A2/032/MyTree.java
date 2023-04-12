/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int item; // current item

    // fill in your accessor and mutator methods here
	public MyNode(int i, int left, int right) {
		item = i;
		leftChildIndex = left;
		rightChildIndex = right;
	} // end constructor
	
	// return node item
	public int getItem() {
		return item;
	}
	
	// return left child index of item
	public int getLeft() {
		return leftChildIndex;
	}

	// return right child index of item
	public int getRight() {
		return rightChildIndex;
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

    // fill in your ADT methods here

	// add new node to the tree with specified left & right child
	public void add(int index, int left, int right) {
		myTree[size] = new MyNode(index, left, right);
		size++;
	}

	// get the parent of the node, if applicable
	public int getParent(int index) {
		if (index != 0)
			return myTree[(index-1)/2].getItem();
		else
			return -1; // return -1 if index is already root.
	}

	// get the left child of the node
	public int getLeftChild(int index) {
		return myTree[myTree[index].getLeft()].getItem();
	}

	// get the right child of the node
	public int getRightChild(int index) {
		return myTree[myTree[index].getRight()].getItem();
	}

	// method to process query of relationship between A and B
	public void processQuery(int A, int B) {
		if (myTree[A].getItem() == getParent(B)) // A is parent of B
			System.out.println("ANCESTOR");

		else if (getParent(A) == myTree[B].getItem()) // A is child of B
			System.out.println("DESCENDANT");

		else if (myTree[A].getItem() == getLeftChild(getParent(B)))
			// A is left sibling of B
			System.out.println("LEFT SIBLING");

		else if (myTree[A].getItem() == getRightChild(getParent(B)))
			// A is right sibling of B
			System.out.println("RIGHT SIBLING");

		else // A has no relationship to B
			System.out.println("NONE");
	}
}
