/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			 // left child index in array
    int rightChildIndex;		 // right child index in array
	int ancestorIndex;                // head index in array

    // fill in your accessor and mutator methods here
    // ...
	public MyNode() {
		setIsSafe(0);
		setLeft(-1);
		setRight(-1);
		setAncestor(-1);
	} // end constructor

	public void setIsSafe(int isSafeIndex) {
		if (isSafeIndex==1) {
			isSafe = true;
		}
		if (isSafeIndex==0) {
			isSafe = false;
		}
	} // end setIsSafe

	public void setLeft(int left) {
		leftChildIndex = left;
	} // end setLeft

	public void setRight(int right) {
		leftChildIndex = right;
	} // end setRight

	public void setAncestor(int ancestor) {
		ancestorIndex = ancestor;
	} // end setAncestor

	public boolean getIsSafe() {
		return isSafe;
	} // end getIsSafe

	public int getLeft() {
		return leftChildIndex;
	} // end getLeft

	public int getRight() {
		return rightChildIndex;
	} // end getRight

	public int getAncestor() {
		return ancestorIndex;
	} // end getAncestor

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
	
	public void setSafe(int safe,int index) {
		myTree[index].setIsSafe(safe);
	} // end setSafe

	public void set(int left, int right, int index) {
		myTree[index].setLeft(left);
		myTree[index].setRight(right);
		myTree[left].setAncestor(index);
		myTree[right].setAncestor(index);
	} // end set

	public boolean findPath(int start, int end) {
		boolean safe = true;
		boolean hasPath = true;
		boolean hasSafePath = false;
		if (start == end) {
			hasPath = true;
			return hasPath;
		}
		if (myTree[start].getIsSafe() == false) {
			safe = false;
			return safe;
		}

		if (myTree[start].getLeft() == -1) {
			hasPath = false;
			return hasPath;
		}

		if (myTree[start].getRight() == -1) {
			hasPath = false;
			return hasPath;
		}

		if (myTree[start].getAncestor() == -1) {
			hasPath = false;
			return hasPath;
		}
		if (start != end && safe == true && hasPath == true) {
			findPath(myTree[start].getAncestor(), end);
			findPath(myTree[start].getLeft(), end);
			findPath(myTree[start].getRight(), end);
		}

		if(safe == true && hasPath == true) {
			hasSafePath = true;
		}

		return hasSafePath;
	}

}
