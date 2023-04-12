/** Class for a tree node
 */
class MyNode {
    //Instance variables
    private int leftIndex;			  // left child index in array
    private int rightIndex;		 // right child index in array
	private int data;
	
    //Constructor
	public MyNode(int l, int r, int data)
	{
		this.leftIndex = l;
		this.rightIndex = r;
		this.data = data;
	}
	
	//constructor
	public MyNode(int data)
	{
		this(-1, -1, data);
	}
    // fill in your accessor and mutator methods here
    //get leftIndex
	public int getLeftIndex()
	{
		return this.leftIndex;
	}

	//get rightIndex
	public int getRightIndex()
	{
		return this.rightIndex;
	}
	/*
	public int getMyIndex()
	{
		return this.myIndex;
	}*/


    //get this node
	public MyNode getNode()
	{
		return this;
	}

	public void setLeftIndex(int l)
	{
		this.leftIndex = l;
	}

	public void setRightIndex(int r)
	{
		this.rightIndex=r;
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
    //Instance variables
    private final int MAX_NODES = 1000; //max num of nodes in this tree
    MyNode[] myTree;
    int size = 0;	//num of elem in myTree
	

    // fill in your ADT methods here
    //constructor
	public MyTree(int[] data)
	{
		myTree = new MyNode[MAX_NODES];
		myTree[0] = new MyNode(0);
		for(int i=1; i<data.length; i++)
		{
			myTree[i] = new MyNode(data[i]);
		}
	}
	
	//check relationship btn 2 nodes,given their labels/indices
	//returns a String indicating relationship
	public String checkRelationship(int x, int y)
	{
		String relation ="NONE";
		//check the indices for relationship
		if(isAncestor(x,y))
		{
			return "ANCESTOR";
		}
		else if(isDescendant(x,y))
		{
			return "DESCENDANT";
		}
		else if(isLeftSibling(x,y))
		{
			return "LEFT SIBLING";
		}
		else if(isRightSibling(x,y))
		{
			return "RIGHT SIBLING";
		}
		return relation;
	}//end checkRelationship

	//check is node x is ancestor of node y
	public boolean isAncestor(int x, int y)
	{
		//case1: node x is root node
		if(x==0)
		{
			return true;
		}
		//case2: node x is parent of y
		else if(x == (y-1)/2)
		{
			//case2a: node y is left child
			return true;
		}
		//case2b: node y is right child
		else if(x == (y-2)/2)
		{
			return true;
		}
		return false;
	}

	public boolean isDescendant(int x, int y)
	{
		if(isAncestor(y,x))
		{
			return true;
		}
		return false;
	}

	public boolean isLeftSibling(int x, int y)
	{   //if x is root node index
		if(x==0)
		{
			return false;
		}
		else if(y-x ==1)
		{
			return true;
		}
		return false;
	}

	public boolean isRightSibling(int x, int y)
	{
		if(x==0)
		{
			return false;
		}
		else if(x-y ==1)
		{
			return true;
		}
		return false;
	}





}
