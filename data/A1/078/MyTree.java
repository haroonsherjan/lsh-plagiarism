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

	

}// end MyNode

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    private int[] tree = new int[MAX_NODES];
	private int treeIndex = 1;
	private final int CAPITAL = 0;
	private int[] route = new int[MAX_NODES];
	private int routeIndex = 0;
	private int[] leftChild = new int[MAX_NODES];
	private int leftIndex = 0;
	private int[] rightChild = new int[MAX_NODES];
	private int rightIndex = 0;
    private int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...

	public MyTree() {
		tree[CAPITAL] = 0;
	}

	public void route(int safety) {
		route[routeIndex] = safety;
		routeIndex++;
	}

	public void addItem(int item) {
		if(item != -1) {
			tree[treeIndex] = item;
			treeIndex++;
		}
	}

	public void addLeft(int left) {
		leftChild[leftIndex] = left;
		leftIndex++;
	}

	public void addRight(int right) {
		rightChild[rightIndex] = right;
		rightIndex++;
	}

	public boolean isSafe(int item) {
		return(item == 1);
	}

	public boolean search(int start, int end) {
		int startItemIndex, endItemIndex;

		for(int i = leftIndex -1; i >= 0; i--) {
			if(tree[i] == start) {
				startItemIndex = i;
			}

			if(tree[i] == end) {
				endItemIndex = i;
			}
		}

		return true;
	}

}// end MyTree
