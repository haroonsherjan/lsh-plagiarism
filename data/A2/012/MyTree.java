/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array
    int parentIndex;                  // parent index in arrayt of the node
    
	public MyNode(int l, int r)
	{
		leftChildIndex = l;
		rightChildIndex = r;
	}

	public void setLeft(int l)
	{
		leftChildIndex = l;
	}

	public void setRight(int r)
	{
		rightChildIndex = r;
	}

	public void setParent(int p)
	{
		parentIndex = p;
	}

	public int getLeft()
	{
		return this.leftChildIndex;
	}

	public int getRight()
	{
		return this.rightChildIndex;
	}
	public int getParent()
	{
		return this.parentIndex;
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
  
	public MyTree(int n)
	{
		size = n;
	}

	public void setTreeNode(int i, MyNode n)
	{
		myTree[i] = n;
	
	}

	public MyNode getTreeNode(int i)
	{
		return myTree[i];
	}

	public MyNode getTreeNode(int i)
	{
		return myTree[i];
	}

	public boolean isAncestor(int x, int y)
	{   
		boolean ancestor = false;
		if((myTree[x].getLeft() != -1 )&&(myTree[x].getRight() != -1))
		{
			if((myTree[x].getLeft() == y) || (myTree[x].getRight() == y))
			{
				return true;
			}

			else if((myTree[x].getLeft() != -1 )||(myTree[x].getRight() != -1))
			{
				
				isAncestor(myTree[x].getLeft(),  y);
				isAncestor(myTree[x].getRight(), y);
			}
		}
		return ancestor;
	}

	public boolean isDecendant(int x, int y)
	{   
		boolean decendant = false;
		if (myTree[x].getParent() >= 0)
		{
			if(myTree[x].getParent() == y)
			{
				decendant = true;
			}
			else 
			{
				isDecendant(myTree[x].getParent(),y);
			}
		}
		return decendant;
	}

	public boolean isLeftSibling(int x, int y)
	{
		
		if((myTree[x].getParent() == myTree[y].getParent())&&(myTree[myTree[x].getParent()].getLeft()==x))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public boolean isRightSibling(int x, int y)
	{
		if((myTree[x].getParent() == myTree[y].getParent())&&(myTree[myTree[x].getParent()].getRight()==x))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


    // fill in your ADT methods here
    // ...
}
