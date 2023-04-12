/** Class for a tree node
 */
class MyNode {

	int leftChildIndex;		// left child index in array
	int rightChildIndex; 	// right child index in array
	int item; // stores the item of the node

	// constructor
	public MyNode(int item, int left, int right) {
		this.item = item;
		leftChildIndex = left;
		rightChildIndex = right;
	}
}

/** Class for a binary tree ADT
 *  Uses a array-based implementation
 */
public class MyTree {

	int root;
	int free;
	MyNode tree[];
	int MAX_NODES = 1000;
	int size;

	// constructor
	public MyTree() {
		tree = new MyNode[MAX_NODES];
		root = 0;
		tree[0] = new MyNode(0, 1, 2);
		free = 1;
		size = 1;
	}

	// method to insert the nodes into the tree
	void insert(int left, int right) {
		// models a complete binary tree, item is -1 if the node is empty
		int leftC, rightC;
		leftC = 2 * free + 1;
		rightC = 2 * free + 2;
		MyNode leftN = new MyNode(left, leftC, rightC);
		tree[free] = leftN; // insert left node
		free++;
		MyNode rightN = new MyNode(right, (2 * free + 1), (2 * free + 2));
		tree[free] = rightN; // insert right node
		free++;
	}

	// determine the relationship between A and B
	String relation(int A, int B) {
		// first get the index of int A and B
		int i = getIndex(A);
		int j = getIndex(B);

		if (ancestor(i, j))
			return "ANCESTOR";
		else if (descendant(i, j))
			return "DESCENDANT";
		else
			return siblings(i, j);
	}

	int getIndex(int x) {
		// free - 1 is the current size of the tree including unfilled nodes
		for(int i = 0; i < free; i++) {
			MyNode temp = tree[i];
			if (temp.item == x)
				return i;
		}

		return -1;
	}

	// method to determine if A is the ancestor of B
	boolean ancestor(int A, int B) {
		// loops through the parent until the node
		for (int i = ((A - 1) / 2); i >= 0; i = (i - 1) / 2) {
			// if A is along the same path above B, then A is the ancestor of B
			if (i == B)
				return true;
		}
		return false;
	}

	// method to determine if A is the descendant of B
	boolean descendant(int A, int B) {
		// loops through the children of B until the end of the tree
		// first loops through the left path
		for (int i = (2 * B + 1); i < free; i = (2 * i + 1)) {
			// if A is along the left path of B, then A is the descendant of B
			if (i == A)
				return true;
		}

		// loops the right path
		for (int i = (2 * B + 2); i < free; i = (2 * i + 2)) {
			// if A is along the right path of B, then A is the descendant of B
			if (i == A)
				return true;
		}

		return false;
	}

	String siblings(int A, int B) {
		// check if they have the same parent first
		// if the parents of A and B are the same, then they are siblings
		if (((A - 1) / 2) == ((B - 1) / 2)) {
			// if the index of A is before B, then A is the left sibling of B
			// if the index of A is after B, then A is the right sibling of B
			if (A < B)
				return "LEFT SIBLING";
			else
				return "RIGHT SIBLING";
		}
		return "NONE";
	}    
}
