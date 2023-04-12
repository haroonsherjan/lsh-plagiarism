/** Class for a tree node
 */
class MyNode
{
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;          // right child index in array
	Object item;

    // fill in your accessor and mutator methods here

	public MyNode(Object num)
	{
		item = num;
		leftChildIndex = null;
		rightChildIndex = null;
	} //end constructor

	public int getItem()
	{
		return item;
	} 

	public void setItem(int num)
	{
		item = num;
	}

    public int getLeft()
	{
		return leftChildIndex;
    } 

	public void setLeft(MyNode left)
	{
		leftChildIndex = left;
	}

	public void getRight()
	{
		return rightChildIndex;
	}

	public void setRight(MyNode right)
	{
		rightChildIndex = right;
	} 

	public boolean isSafe()
	{
	  //returns 1 if child city is safe,else return 0
		   return 1;
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
	protected MyNode root;

    // fill in your ADT methods here
    // ...
   
    public MyTree()
	{
    }

    public MyTree(rootItem)
    { 
	  root = new MyNode(rootItem,null,null);
    }		 

	public void attachLeft(Object newItem)
	{
		if(!isEmpty() && root.getLeft() == null)
		{
			//assertion: nonempty tree;no left child
			root.setLeft(new MyNode(newItem,null,null);
		} 
		size++;
	}

	public void attachRight(Object newItem)
	{
		if(!isEmpty() && root.getRight() == null)
		{
			//assertion: nonempty tree; no right child
		    root.setRight(new MyNode(newItem,null,null);
		} 
		size++;
	}

	protected MyTree(MyNode rootNode)
	{
		root = rootNode;
	}

	for(int i=0; i<MAX_NODES; i++)
	{
     myTree.readTree();
	 myTree.readQueries();
	}

}
