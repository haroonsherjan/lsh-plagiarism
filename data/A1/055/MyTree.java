/** Class for a tree node
 */
class MyNode
{
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int item;

    // fill in your accessor and mutator methods here
    // ...
	public MyNode(int newItem, int safe)
	{
		item = newItem;
		if (safe == 1)
		{
			this.isSafe = true;
		}
		else
		{
			this.isSafe = false;
		}

	}

    public MyNode(int newItem, int safe, int left, int right)
	{
        item = newItem;
		if (safe == 1)
		{
			isSafe = true;
		}
		else
		{
			isSafe = false;
		}
		leftChildIndex = left;
		rightChildIndex = right;
	}

    public void setItem(int newItem)
	{
        item = newItem;
	}

	public int getItem()
	{
		return item;
	}

    public void setBoolean(int safe)
	{
		if (safe == 1)
		{
            isSafe = true;
		}
		else
		{
			isSafe = false;
		}
	}

	public boolean getBoolean()
	{
		return isSafe;
	}
	
	public int getLeft()
	{
		return leftChildIndex;
	}

	public void setLeft(int left)
	{
		leftChildIndex = left;
	}

	public int getRight()
	{
		return rightChildIndex;
	}

	public void setRight(int right)
	{
		rightChildIndex = right;
	}

}

/** Class for a binary tree ADT
 */
public class MyTree 
{
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private final int MAX_NODES = 1000;
    MyNode[] myTree = new MyNode[MAX_NODES];
    int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...
    
    public MyTree(int rootItem, int leftChild, int rightChild)
	{
		myTree[0].item = rootItem;
		myTree[0].leftChildIndex = leftChild;
		myTree[0].rightChildIndex = rightChild;
	}

	/*for (int i=0; i<number; i++)
	{
		myTree[i].setBoolean(arr[i]);
	}*/
}
