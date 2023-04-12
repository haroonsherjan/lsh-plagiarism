/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
	int item;                    // item

	public MyNode(int i) {
		item = i;
	}

    // fill in your accessor and mutator methods here
    // ...
	public int getItem() {
		return item;
	}

	public void setItem(int i) {
		item = i;
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
    MyNode[] myTree;
    int size;	// make sure to update this variable as needed

	// constructor
	public MyTree() {
		myTree = new MyNode[MAX_NODES];
		size = 0;
	}

    // fill in your ADT methods here
    // ...
	public void insertNode(int node, int left, int right) {
		if (isEmpty()) {
			myTree[node] = new MyNode(node); 
			size++;  // add one node for 0
		}
		myTree[(2 * node) + 1] = new MyNode(left);      // left child is based on parent's position
		myTree[(2 * node) + 2] = new MyNode(right);     // right child is based on parent's position
		size += 2; // add two nodes, regardless -1
	}
	
	public void checkRelationship(int a, int b) {
		// index of elements will be used to find their relationship
		int aIndex = findIndex(a);  // get index of a
		int bIndex = findIndex(b);  // get index of b
		
		if (checkSibling(aIndex,bIndex))      // a is RIGHT SIBLING
			System.out.println("RIGHT SIBLING");
		else if (checkSibling(bIndex,aIndex)) // a is LEFT SIBLING (by reversing right sibling method)
			System.out.println("LEFT SIBLING");
		else if (checkAncestor(aIndex,aIndex,b)) // a is ANCESTOR
			System.out.println("ANCESTOR");
		else if (checkAncestor(bIndex,bIndex,a)) // a is DESCENDENT (by reversing ancestor method)
			System.out.println("DESCENDENT");
		else                                  // by elimination
			System.out.println("NONE");
	}

	public boolean checkSibling(int aIndex, int bIndex) {
		// to check:
		// even number is greater than odd number by one
		// same as if (aIndex > bIndex && aIndex == bIndex + 1 && aIndex % 2 == 0)
		if (aIndex > bIndex)
			if (aIndex == bIndex + 1)
				if (aIndex % 2 == 0)
					return true;
		return false;
	}

	public boolean checkAncestor(int anc, int des, int item) {
		// using formula where left child is 2n + 1, right child is 2n + 2 to traverse the array
		// starting from anc (stupid problem here)
		if (myTree[des].getItem() == -1)
			return false;
		else if (myTree[des].getItem() == item)
			return true;
		else if (checkAncestor(anc,2*des + 1, item))
			return checkAncestor(anc, 2*des + 1, item);
		else
			return checkAncestor(anc, 2*des + 2, item);
	}

	private int findIndex(int x) { // find the index of the element by traversing the array
		for (int i=0; i<size; i++)
			if (x == myTree[i].getItem())
				return i;
		return -1;
	}

	public boolean isEmpty() { // check if array is empty
		return (size == 0);
	}

	public void print() { // used for testing driver class
		for (int i=0; i<size; i++)
			System.out.print(myTree[i].getItem() + " ");
	}

}
