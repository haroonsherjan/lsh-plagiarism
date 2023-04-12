/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    //int city;
   
	
	public MyNode( int left, int right)
	{
		leftChildIndex = -1;
		rightChildIndex = -1;
	} //end MyNode

    // fill in your accessor and mutator methods here
	/*protected int getCity()
	{
		return city;
	}*/

    protected int getLeftChildIndex()
	{
		return leftChildIndex;
	}

	protected int getRightChildIndex()
	{
		return rightChildIndex;
	}

	/*protected void setCity(int city)
	{
		this.city = city;
	}*/

	protected void setLeftChildIndex(int leftChildIndex)
	{
		this.leftChildIndex = leftChildIndex;
	}

	protected void setRightChildIndex(int rightChildIndex)
	{
		this.rightChildIndex = rightChildIndex;
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
	final int root = 0; //root is city 0

	public MyTree(int childL, int childR)
	{
			myTree = new MyNode(-1, -1);
	}

    // fill in your ADT methods here
	public void attachLeft(int childL)
	{
		myTree.setLeftChildIndex(new MyNode(childL));
	}
} //end MyTree
