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
	public void setLeft(int left)
	{
		leftChildIndex = left; // set the left child node
	}

	public void setRight(int right)
	{
		rightChildIndex = right; //set the right child node
	}

	public int getLeft()
	{
		return leftChildIndex; // Retrieve Left Child node
	}

	public int getRight()
	{
		return rightChildIndex; // Retrieve Right Child node
	}

	public void setSafe(int node)
	{
		if (node == 0) //unsafe city
			isSafe = false;
		else
			isSafe = true;
	}

	public boolean getSafe()
	{
		return isSafe; // Retrieve Safe level	
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
    int size = 0;	// make sure to update this variable as neededx
	int root = 0; 	// root is always at node 

	public MyTree(int tSize)
	{
		size = tSize; //total number of node
	}

	public void safeRoute(int node, int safe)
	{
	 	myTree[node].setSafe(safe); //Set each safety level
	}

	public void setLChild (int node, int cLeft)
	{
		myTree[node].setLeft(cLeft); // set node's left child
	}

	public void setRChild (int node, int cRight)
	{
		myTree[node].setRight(cRight); //Set node's right child	
	}
	
	
	public boolean safeTravel (int start, int end)
	{
		if(myTree[start].getSafe())
			return false;
			else
				return true;
	}

	
	// fill in your ADT methods here
    // ...









}
