/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    // ...

	 
}

/** Class for a binary tree ADT
 */
public class MyTree {
    
	//data members
	private final int MAX_NODES = 1000;
    int parent, left, right;
	int size=0;
	boolean isSafe;

    // constructor
	public MyTree() {
		parent=0;
		left=-1;
		right=-1;
	}

	//accessors and mutators

	//set index of parent
	public void setParent(int p) {
		parent = p;
	}

	//set index of left child
	public void setLeft(int l) {
		left = l;
	}

	//set index of right child
	public void setRight(int r) {
		right = r;
	}
	
	//set safety to consider
	public void setSafety(boolean safety) {
		isSafe = safety;
	}

	//get index of parent
	public int getParent() {
		return parent;
	}

	//get index of left child
	public int getLeft() {
		return left;
	}

	//get index of right child
	public int getRight() {
		return right;
	}

	//get safety to consider
	public boolean getSafety() {
		return isSafe;
	}




}
