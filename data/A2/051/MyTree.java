/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		  // right child index in array
	
	// constructor
	public MyNode(int left, int right) {

		setLeft(left);
		setRight(right);
	}

    // fill in your accessor and mutator methods here
	// returns left index of node
    public int getLeft() {

		return leftChildIndex;
	}
	
	// returns right index of node
	public int getRight() {

		return rightChildIndex;
	}
	
	// sets the left index of the node
	public void setLeft(int l) {

		leftChildIndex = l;
	}
	
	// sets the right index of the node
	public void setRight(int r) {

		rightChildIndex = r;
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

    private final int MAX_NODES = 10000;
    private MyNode[] myTree = new MyNode[MAX_NODES];
    private int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
	// creates the node with its left and right child
    public void setNode(int left, int right, int position) {

		myTree[position] = new MyNode(left, right);
		size++;
	}
	
	// checks if a is the ancestor of b
	public boolean isAncestor(int a, int b) {

		boolean ancestor = false; // checks if a is ancestor of b
			
		if (myTree[a].getLeft() == b || myTree[a].getRight() == b) {
			ancestor = true;
		}
		
		else if (myTree[a].getLeft() != -1 && myTree[a].getRight() == -1) {
			ancestor = isAncestor(myTree[a].getLeft(), b);
		}

		else if (myTree[a].getRight() != -1 && myTree[a].getLeft() == -1) {
			ancestor = isAncestor(myTree[a].getRight(), b);
		}
		
		else if (myTree[a].getRight() == -1 && myTree[a].getLeft() == -1) {

			ancestor = false;
		}

		else {
			ancestor = isAncestor(myTree[a].getLeft(), b);
			ancestor = isAncestor(myTree[a].getRight(), b);
		}

		return ancestor;
	}
	
	// checks if a is the descendant of b
	public boolean isDescendant(int a, int b) {

		return isAncestor(b, a);
	}
	
	// method to check if node A is the right sibling of node B
	public boolean isLeftSibling(int a, int b) {
		
		boolean isLeft = false;

		for (int i = 0; i < size; i++) {

			if (myTree[i].getLeft() == a && myTree[i].getRight() == b) {

				isLeft = true;
			}
		}

		return isLeft;
	}
	
	// method to check if node A is the right sibling of node B
	public boolean isRightSibling(int a, int b) {
		
		return isLeftSibling(b, a);
	}
}
