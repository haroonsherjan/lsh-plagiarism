/** Class for a tree node
 */
class MyNode 
{
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

   
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array

    // Constructor
	public MyNode()
	{
		leftChildIndex = -1;
		rightChildIndex = -1;
	}

	public int getLeft(int i)
	{
		return leftChildIndex;
	}

	public int getRight(int i)
	{
		return rightChildIndex;
	}

	public void setLeft(int left)
	{
		leftChildIndex = left;
	}

	public void setRight(int right)
	{
		rightChildIndex = right;
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
    int [] leftChild = new int [MAX_NODES];
	int [] rightChild = new int [MAX_NODES];

	public MyTree()
	{
		myTree[0] = null;
	}

	public void setLeftRight(int left, int right)
	{
		myTree[size].setLeft(left);
		leftChild[(left-1) /2] = left;
		myTree[size].setRight(right);
		rightChild[(right -2)/2] = right;
		size++;
	}

	public String relation(int i, int j)
	{
		String relation = "";
		//if both nodes points to the same parent, they are siblings
		if( Math.abs(i - j) == 1 && (i != 0 || j != 0))
		{
			//if i is the left node, it is the left sibling of j
			if(i% 2 == 0)
			{
				relation = "LEFT SIBLING";
			}
			//if i is the right node, it is the right sibling of j
			{
				relation = "RIGHT SIBLING";
			}
		}
		//if i has the j as parent, i is the descendant
		else if(j > i)
		{
			relation = "DESCENDANT";
		}
		//if j has i as parent, i is the ancestor
		else if (j < i)
		{
			relation = "ANCESTOR";
		}
		return relation;
	}
}
