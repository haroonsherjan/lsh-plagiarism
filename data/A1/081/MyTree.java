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
	public MyNode(int safe) {
		leftChildIndex = -1;
		rightChildIndex = -1;
	}

	public int getLeft() {
		return leftChildIndex;
	}

	public int getRight() {
		return rightChildIndex;
	}

	public boolean safe(){
		return isSafe;
	}

	public void setLeft(int left) {
		leftChildIndex = left;
	}

	public void setRight(int right) {
		rightChildIndex = right;
	}

	public void setSafe(int safe) {
		if (safe == 0) {isSafe = false; }
		else if (safe == 1) { isSafe = true; }
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






	public void add(int left, int right) {
		myTree[size].setLeft(left);
		myTree[size].setRight(right);

		size++;
	}

	public void createSafe(int safe, int index) {
		myTree[index].setSafe(safe);
	}
// Loop the tree to find the path from start to destination. Check if city is safe at every city reached. 
	public boolean loopTree(int start,int destination) {
		int city = destination;
		boolean reached = false;
		boolean safe = false;
		boolean reached0 = false;

		while(reached != true) {
			city = search(city);
			//check for safe cities
			if (myTree[city].safe() == false) { 
				safe = false;
				reached = true;
				break;
			}

			else {
				safe = true;
			}
			//check if all cities are checked
			if (reached0 == true && city == 0) {
				reached = true;
			}
			else if (city == start && reached0 == false) {
				reached = true;
			}

			//check if 0 is reached
			if (city == 0 && reached0 == false) {
				city = start;
				reached0 = true;
			}
		}

		return safe;
				
	}

	public  int search(int city) {
		int index = -1;
		for(int i = 0; i < myTree.length; i++) {
			if (myTree[i].getLeft() == city || myTree[i].getRight() == city) {
				index = i;
				break;
			}
		}

		return index;
	}
}

	























