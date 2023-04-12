/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
	int index;                    //index of the Node
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
	int parent;                  //parent of the node, if parent does not exist then parent == -1

	public MyNode(int value, int left, int right, int parent)
	{
		index = 0;
	    leftChildIndex = 0;
		rightChildIndex = 0;
		parent = -1;
	}    

	public int getLeftChildIndex()
	{
		return leftChildIndex;
	}

	public int getRightChildIndex()
	{
		return rightChildIndex;
	}

	public void setRightChildIndex(int index)
	{
		rightChildIndex = index;
	}

	public void setLeftChildIndex(int index)
	{
		leftChildIndex = index;
	}

	public void setParent(int parent)
	{
		this.parent = parent;
	}

	public int getParent()
	{
		return this.parent;
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

    final public int MAX_ARRAY = 1000;
	MyNode[] nodeArray = new MyNode[MAX_ARRAY];
    int size = 0;	// make sure to update this variable as needed
    

	public MyTree(int root, int rootLeft, int rootRight)
	{
		array[0] = new MyNode(root, rootLeft, rootRight, -1);//root
		size++;
	}

	public void insertNode(int value, int left, int right, int parent)
	{
		nodeArray[value] = new MyNode(value, left, right, parent);
		size++;
	}

	public String relationshipCheck(int A, int B)
	{
		boolean relationshipAncestor = isAncestor(A, B);
		boolean relationshipDescendant = isDescendant(A, B);
		boolean relationshipLeftSibling = isLeftSibling(A, B);
		boolean relationshipRightSibling = isRightSibling(A, B);
	}

	public boolean isAncestor(int A, int B)
	{
		boolean AisAncestor = false;
		if(nodeArray[B].getParent() == A)
		{
			return AisAncestor = true;
		}
		else
		{
			int parent = nodeArray[B].getParent();
			isAncestor(parent , A);
		}
		return AisAncestor;
	}

	public boolean isDescendant(int A, int B)
	{
		boolean AisDescendant = false;
		if(nodeArray[B].getRightChild() == A)
		{AisDescendant = true;}
		else if(nodeArray[B].getLeftChild() == A)
		{AisDescendant = true;}
		else 
		{
			isDescendant(nodeArray[B].getRightChild(), A);
			isDescendant(nodeArray[B].getLeftChild(), A);
		}
		return AisDescendant;
	}

	public boolean isLeftSibling(int A, int B)
	{
		boolean AisLeftSibling = false;
		int parent = nodeArray[A].getParent();
		if(nodeArray[parent].getRightChild() == B)
		{
			AisLeftSibling = true;
		}
		return AisLeftSibling;
	}

	public boolean isRightSibling(int A, int B)
	{
		boolean AisRightSibling = false;
		int parent = nodeArray[A].getParent();
		if(nodeArray[parent].getLeftChild() == B)
		{
			AisRightSibling = true;
		}
		return AisRightSibling;
	}

}
