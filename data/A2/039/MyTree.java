/** Class for a tree node
 */

class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    private int leftChildIndex;			  // left child index in array
    private int rightChildIndex;		 // right child index in array
	private int rootIndex;     // Root Index in the array
    
	
	public MyNode()
	{
		leftChildIndex=-1;
		rightChildIndex = -1;
		rootIndex = -1;
	}
	
	// fill in your accessor and mutator methods here
    
	public void changeLeft(int left)
	{
		leftChildIndex = left;
	}
	
	public void changeRight(int right)
	{
		rightChildIndex = right;
	}
	
	public void changeRoot(int root)
	{
		rootIndex = root;
	} 
	
	public int getLeft()
	{
		return leftChildIndex;
	}
	
	public int getRight()
	{
		return rightChildIndex;
	}

	public int getRoot()
	{
		return rootIndex;
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
	//blank consstrator
	
	public void setSize(int treesize)
	{
		size = treesize;
	//Create MyNode
		for(int i=0; i<treesize; i++)
			{
				myTree[i] = new MyNode();
			}
	}
	
	
	
	//setNode
	public void insert (int index,int left,int right)
	{
		myTree[index].changeLeft(left);
		myTree[index].changeRight(right);
		if(left!=-1)
			myTree[left].changeRoot(index);
		if(right!=-1)
			myTree[right].changeRoot(index);
	}
	//check and output
	public void check(int left,int right)
{
	if (myTree[left].getRoot()  == myTree[right].getRoot())
		{
			checkSibling(left,right);
		 	return;
		}//sibling case
	if (checkParent(left,right)==true)
		{
			System.out.println ("ANCESTOR");
			return;
		}
	if (checkParent(right,left) == true)
		{
		System.out.println("DESCENDANT");
		return;
		}
	//the above two are parent and child case
	// no other ouput means no relation 
	System.out.println("NONE");
	return;
}

	void checkSibling(int left,int right)
	{
		int commonRoot = myTree[left].getRoot();
		if( myTree[commonRoot].getLeft() == left )
		System.out.println("LEFT SIBLING");
		else System.out.println("RIGHT SIBLING");
	}
	// Recursiverly check parent case
	boolean checkParent(int first,int second)
	{
	int secondRoot =  myTree[second].getRoot();
	if(secondRoot == -1) return false;
	else if (secondRoot == first)
		return true;
	else return checkParent(first, secondRoot);

	}


}
