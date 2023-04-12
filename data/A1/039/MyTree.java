/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;                // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // fill in your accessor and mutator methods here
    MyNode ( int safety, int left, int right) {
		if ( safety == 1) 
			isSafe = true;
	    else
			isSafe = false;
		leftChildIndex = left;
		rightChildIndex = right;
	}//end constructor

	/*******accessor**************/

	public boolean getSafety() {
		return isSafe;
	}

	public int getLeftChild() {
		return leftChildIndex;
	}

	public int getRightChild() {
		return rightChildIndex;
	}

}//end myNode

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    protected MyNode[] myTree;
    protected int size;	// make sure to update this variable as needed
    protected int root;
	protected boolean path1;
	protected boolean path2;

    // fill in your ADT methods here
    public MyTree(int n, int[] Safety, int[] leftChildren, int[] rightChildren[]) {
         for (int i = 0; i < n; i++ ) {
			 MyNode node = new MyNode (safety[i], leftChildren[i], rightChildren[i]);
			 myTree[i] = node;
		     size++;
		 }
		root = myTree[0];
	}//end constructor

    public boolean checkSafety( int i, int j) {
		
	    //i and j are the indexes
		if ( i == j && myTree[i].getSafety() )
			return true;
		else if ( i == j && myTree[i].getSafety() == false)
			return false;

		else if (i != j && (myTree[i].getSafety() == false || myTree[j].getSafety() == false))
			return false;
	    else {
		    if ( i != 0 ) 
	          path1 = checkSafety(i,(i-1)/2);
			if ( j != 0 )
		       path2 =  checkSafety(j,(j-1)/2);
	}//end else
            return path1 && path2;

}//end MyTree
