/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
	int city;
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

	public MyNode() {
		city = -1;
		leftChildIndex = -1;
		rightChildIndex = -1;
		isSafe = false;
	}

	public MyNode(int i, int j, int k) {
		city = i;
		leftChildIndex = j;
		rightChildIndex = k;
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

    public MyTree() {
	}

	public MyTree(int n) {
		size = n;
	}

	public void setSafe(int[] safePath) {
		for(int i=0; i<size; i++) {
			if(myTree[i].city != -1) {
				if(safePath[i] == 1) myTree[i].isSafe = true;
				else myTree[i].isSafe = false;
			}
		}
	}

	public void insert(MyNode node) {
		myTree[node.city] = node;   // inserting each city as a node
	}

	public boolean checkSafe(int city1, int city2) {
		int pos1 = 0, pos2 = 0;

		for(int i=0; i<size; i++) {
			if(myTree[i].city == city1) {
				pos1 = i;   // get the index of the city in the array
			}
			if(myTree[i].city == city2) {
				pos2 = i;   // get the index of the city in the array
			}
		}

		do {
			if(!myTree[pos1].isSafe) return false;   // return immediately if city 1 (A) is unsafe
			if(!myTree[pos2].isSafe) return false;   // return immediately if city 2 (B) is unsafe
			
			if(pos1 > pos2) pos1 = getParent(pos1);   // get the parent of the node, if it is further away from the common root
			else if(pos2 > pos1)  pos2 = getParent(pos2);
		} while(pos1 != pos2);   // continue to loop till they reach the same root

		return true;
	}

	private static int getParent(int i) {
		return (int) ((i-1)/2);
	}
}
