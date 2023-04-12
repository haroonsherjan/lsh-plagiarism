/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int parent; 				//parent in the array
	
	public MyNode(int safe)
	{
		if(safe == 0)
			isSafe = false;
		else if(safe == 1)
			isSafe = true;
	}
	
	public boolean getSafe()
	{
		return isSafe;
	}

	public void setLeft(int leftIndex)
	{
		if(leftIndex > 0)
		{
			leftChildIndex = leftIndex;
		}	
	}

	public void  setRight(int rightIndex)
	{
		if(rightIndex > 0)
			rightChildIndex = rightIndex;
	}

	public void setParent(int parent)
	{
		this.parent = parent;
	}

	public int getParent()
	{
		return parent;
	}
	
	public int getRight()
	{
		return rightChildIndex;
	}

	public int getLeft()
	{
		return leftChildIndex;
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
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed
	
	public MyTree()
	{}

	public void insert(int index, MyNode node)
	{
		myTree[index] = node;
		size ++;
	}

	public MyNode get(int index)
	{
		return myTree[index];
	}

    // fill in your ADT methods here
    // ...
}
