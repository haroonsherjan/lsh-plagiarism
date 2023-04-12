/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

	public MyNode(int safe)
	{
		if(safe==0)
			isSafe = false;
			else
				isSafe = true;
		leftChildIndex = -1;
		rightChildIndex = -1;
	}

	public void setLeft(int left)
	{
		if(left!=-1)
			leftChildIndex = left;
	}

	public void setRight(int right)
	{
		if(right!=-1)
			rightChildIndex = right;
	}

	public boolean isSafe()
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

	public MyTree()
	{
	}

	public void setSize(int treeSize)
	{
		size = treeSize;
	}

	public void setSafety(int n, int safe)
	{
		myTree[n] = new MyNode(safe);
	}

	public void setLeftIndex(int n, int left)
	{
		myTree[n].setLeft(left);
	}

	public void setRightIndex(int n, int right)
	{
		myTree[n].setRight(right);
	}

	public boolean travel(int start, int end)
	{
		boolean safe = true;

		if(start==end)
			return myTree[start].isSafe();
			else safe = findPath(start, end);
		return safe;
	}

	private boolean findPath(int start, int end)
	{
		MyNode startCity = myTree[start];
		MyNode endCity = myTree[end];

		if(!endCity.isSafe() || !startCity.isSafe())
		{
			return false;
		}
		else
		{
			/*int[] startParents = new int[MAX_NODES];
			int startFree = 1;
			startParents[0] = end;

			while(parent!=0)
			{
				startParents[free] = findParent(parents[--free]);
				free++;
			}

			while(*/

		}
		return false;
	}

	private int findParent(int end)
	{
		for(int i=0; i<size; i++)
		{
			if(myTree[i].leftChildIndex==end || myTree[i].rightChildIndex==end)
				return i;
		}

		return -1;
	}
}
