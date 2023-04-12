/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		  // right child index in array
	int safe;

	public MyNode( int safe ) // setting the boolean state
	{
		this.safe = safe;
		
		if(safe == 1)
		{
			this.isSafe = true;
		}
		else 
		{
			this.isSafe = false;
		}
	}

	public MyNode(int leftIndex, int rightIndex) // setting both the left and right child
	{
		this.leftChildIndex = leftIndex;
		this.rightChildIndex = rightIndex;
	}


	public boolean safe() // checking whether it is safe
	{
		return isSafe;
	}

	public int getLeft() // return the left
	{
		return leftChildIndex;
	}
	
	public int getRight() // return the right
	{
		return rightChildIndex;
	}

	public void setLeft(int newLeft) // setting the left child
	{
		this.leftChildIndex = newLeft;
	}

	public void setRight(int newRight) // setting the right child
	{
		this.rightChildIndex = newRight;
	}
    // fill in your accessor and mutator methods here
    // ...
}

/** Class for a binary tree ADT
 */
public class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.
	int root = 0;
    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	


    // fill in your ADT methods here
    // ...
}
