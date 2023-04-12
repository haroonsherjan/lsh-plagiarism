/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private boolean isSafe;				  // is the city safe
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array
	
	MyNode()
	{
		isSafe = true;
		leftChildIndex = -1;
		rightChildIndex = -1;
	}

	int getLeftChildIndex()
	{
		return leftChildIndex;
	}

	int getRightChildIndex()
	{
		return rightChildIndex;
	}

	boolean isSafe()
	{
		return isSafe;
	}

	void setIsSafe(boolean isSafe)
	{
		this.isSafe = isSafe;
	}

	void setLeftChildIndex(int index)
	{
		leftChildIndex = index;
	}

	void setRightChildIndex(int index)
	{
		rightChildIndex = index;
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

    private final int MAX_NODES = 1000;
    private int size = 0;	// make sure to update this variable as needed
	
	MyTree()
	{
	//	MyNode[] MyTree = new MyNode[MAX_NODES];
		size = 0;
	}
	
	int getMAX_NODES()
	{
		return MAX_NODES;
	}

	int getSize()
	{
		return size;
	}

	void setSize(int num)
	{
		size = num;
	}

    // fill in your ADT methods here
    // ...

}
