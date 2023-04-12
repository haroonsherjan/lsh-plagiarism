/** Class for a tree node
 */
class MyNode {
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	int leftChildIndex;			  // left child index in array
	int rightChildIndex;		 // right child index in array
	int value;
	int index;

	public MyNode() {
		leftChildIndex = null;
		rightChildIndex = null;
		value = 0;
		index = -1;
	}

	public MyNode(int value) {
		leftChildIndex = null;
		rightChildIndex = null;
		value = 0;
		index = -1;
	}

	// fill in your accessor and mutator methods here
	// ...
	public void setValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	public int getLeftChildIndex(int i) {
		return 2*i + 1;
	}
	public int getRightChildIndex(int i) {
		return 2*i + 2;
	}
	public void setLeftChildIndex(MyTree node) {
		leftChildIndex = node;
	}
	public void setRightChildIndex(MyTree node) {
		rightChildIndex = node;
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
	public void insert(int leftChild, int rightChild) {
		myTree[0] = 0;
		// create a loop to insert the left and right child
		for(int i = 1; i < MAX_NODES; i+=2) {
			myTree[i] = leftChild;
			myTree[i+1] = rightChild;
		}
	}

	public String relation(int A, int B) {
		int aIndex = -1, bIndex = -1;
		int left, right;
		// get index of num1 and num2
		for(int i = 0; i < MAX_NODES; i++) {
			if(myTree[i] == A) {
				aIndex = i;
				left = getLeftChildIndex(i);
				right = getRightChildIndex(i);
			}
			if(myTree[i] == B) {
				bIndex = i;
			}

		}
		//check if A is a left sibling of B
		if(myTree[aIndex] == myTree[2*bIndex+1]) {
			return "LEFT SIBLING";
		} 
		// check if A is a right sibling of B
		if(myTree[aIndex] == myTree[2*bIndex+2]) {
			return "RIGHT SIBLING";
		}
		// check if B is a left sibling of A
		if(myTree[bIndex == myTree[2*aIndex+1]) {
			return "LEFT SIBLING";
		}
		// check if B is a right subling of A
		if(myTree[bIndex == myTree[2*bIndex+2]) {
			return "RIGHT SIBLING";
		}
		// check if ancestor
		if((myTree[aIndex] == myTree[(bIndex-1)/2]) || (myTree[bIndex] == myTree[(aIndex-1)/2])) {
			return "ANCESTOR";
		}
		if((myTree[aIndex] == myTree[(bIndex-1)*2) || (myTree[bIndex] == myTree[(aIndex-1)*2])) {
			return "DESCENDANT";
		}
		return;
	}	
