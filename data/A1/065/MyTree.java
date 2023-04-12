/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	boolean isSafe;				  // is the city safe?
	int leftChildIndex;			  // left child index in array
	int rightChildIndex;		 // right child index in array

	public MyNode() {
	} // end constructor

	// fill in your accessor and mutator methods here
	// ...

	public int getLeft() {
		return leftChildIndex;
	} // end getLeft

	public int getRight() {
		return rightChildIndex;
	} // end getRight

	public void setLeft(int item) {
		leftChildIndex = item;
	}

	public void setRight(int item) {
		rightChildIndex = item;
	}

	public boolean checkSafe(int safety) {
		if(safety == 1)
		{
			return isSafe==true;
		}
		else
		{
			return isSafe==false;
		}
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
	// ...
	public MyTree() {
	}

	public void setSafe(int pos, int safe) {
		myTree[pos].checkSafe(safe);
	}

	public void setLR(int pos, int left, int right) {
		myTree[pos].setLeft(left);
		myTree[pos].setRight(right);
	}
}
