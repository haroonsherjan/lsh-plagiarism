/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int value;

    // fill in your accessor and mutator methods here
    public MyNode(int vlaue) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setLeftChildIndex(int leftChildIndex) {
		this.leftChildIndex = leftChildIndex;
	}

	public int getLeftChildIndex() {
		return leftChildIndex;
	}

	public void setRightChildIndex(int rightChildIndex) {
		this.rightChildIndex = rightChildIndex;
	}

	public int getRightChildIndex() {
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

	//constructor
	public MyTree () {
		myTree[0] = new MyNode(0);
	}

    // Insertion
	public void insert(int value, int loc) {
		if(myTree != null) {
			if(myTree.length <= loc) {
				MyNode[] newTree = new MyNode[myTree.length * 2 + 1];
				for (int i = 0; i < myTree.length; i++)
					newTree[i] = myTree[i];
			    myTree = newTree;
		    }
			if(myTree[loc] == null) {
				myTree[loc] = new MyNode(value);
				size++;
			}
		}
	}

	public void processQuery(int A, int B) {
		int positionA, positionB, parentA, parentB;
		positionA = position(A);
		positionB = position(B);

		parentA = (positionA - 1) / 2;
		parentB = (positionB - 1) / 2;

		//both node belong to the same parent
		if (parentA == parentB)
			checkLeftRightSibling(positionA, positionB);
		else if (parentA != parentB)
			checkAncestDescend(A, B, positionA,  positionB);
	}
	int loc = 0;

	public int positon(int value, loc) {
		if (myTree == null || loc >= myTree.length || myTree[loc] == null) {
			return -1;
		}

		if (myTree[loc].getValue() == value) {
			return loc;
		}
		else {
			return position(value, ++loc);
		}
	}

	private void checkLeftRightSibling(int a, int b) {
		if (a < b)
			System.out.println("LEFT SIBLING");
		else 
			System.out.println("RIGHT SIBLING");
	}

	private void checkAncestDescend(int node1, int node2, int a, int b) {
		//index of parent: (i-1)/2
		int loc1, loc2, loc3, loc4;
		loc1 = (b-1)/2;
		loc2 = 2*a+1;
		loc3 = (a-1)/2;
		loc4 = 2*b+1;

		if(myTree[loc1].getValue() == node1 && myTree[loc2].getValue() == node2)
			System.out.println("ANCESTOR");
		else if(myTree[loc3].getValue() == node2 && myTree[loc4].getValue() == node1)
			System.out.println("DESCENDANT");
		else
			System.out.println("NONE");
	}
}
