/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int parent;

    // fill in your accessor and mutator methods here
    // ...
	public void setLeft(int left)
	{
		leftChildIndex = left;
	}
    
	public void setRight(int right)
	{
		rightChildIndex = right;
	}

	public void setParent(int parent)
	{
		this.parent = parent;
	}

	public int getParent()
	{
		return parent;
	}

	public int getLeft()
	{
		return leftChildIndex;
	}

	public int getRight()
	{
		return rightChildIndex;
	}

	public void setState(int x)
	{
		if(x==0)
			isSafe = false;
		else
			isSafe = true;
    }

	public boolean getState()
	{
		return isSafe;
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
	public MyTree(int size)
	{
		this.size=size;
		for(int i=0;i<size;i++)
			myTree[i]=new MyNode();
	}

	public MyNode[] getTree()
	{
		return myTree;
	}
    // ...
}
