/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    public MyNode(int left, int right) {
		setLeft(left);
		setRight(right);
	}

    public int getLeft() {
		return leftChildIndex;
	}

	public int getRight() {
		return rightChildIndex;
	}


	public void setLeft(int left) {
		leftChildIndex = left;
	}

	public void setRight(int right) {
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

    // fill in your ADT methods here
    public MyTree( int n ) {
		size = n;
	}

	public void setNode( int index, int left, int right ) {
		myTree[index] = new MyNode(left, right);
	}

	public boolean isLeftSibling(int a, int b) {
		for ( int i = 0; i < size; i++ ) {
			// search for the parent of a, which myTree[i]
			if ( myTree[i].getLeft() == a ) { 
				if ( myTree[i].getRight() == b )
					return true;
			}
		} // end for
		return false;
	}

	public boolean isRightSibling(int a, int b) {
		return isLeftSibling(b,a);
	}

	public boolean isAncestor(int a, int b) {
		if ( a == -1 )  // if a has no child
			return false;
		
		if ( myTree[a].getLeft() == b
				|| myTree[a].getRight() == b )
			return true;
		else     // check whether b is the descendant of a's children
			return ( isAncestor(myTree[a].getLeft(),b) ) 
				      || ( isAncestor(myTree[a].getRight(), b ) );
	}

	public boolean isDescendant(int a, int b) {
		return isAncestor(b,a);
	}

}// end class MyTree
