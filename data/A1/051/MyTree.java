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

    public MyNode(boolean isSafe, int left, int right){
		this.isSafe = isSafe;
		leftChildIndex = left;
		rightChildIndex = right;
	} // end constructor

    public boolean isSafe(){
		return this.isSafe;
	}

	public int getLeft(){
		return leftChildIndex;
	}

	public int getRight(){
		return rightChildIndex;
	}
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
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    public MyTree(int num, boolean[] safe, int[]left, int[]right){
		// fill in the array
		for(int i=0; i<num; i++){
			myTree[i] = new MyNode(safe[i], left[i], right[i]);
			size++;
		}
	} // end constructor
	
	public MyNode get(int index){
		return myTree[index];
	}
}// end MyTree
