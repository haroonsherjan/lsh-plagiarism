/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    boolean isSafe;				  // is the city safe?
    int leftChildIndex;			  // left child index in array
    int rightChildIndex;		 // right child index in array


	MyTree root;
	int count = 0;

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

    
	private int value;
	private int safe;
	MyTree leftChild;
	MyTree rightChild;
	private int count = 0;
	MyTree root;

   public MyTree()
   {
   }
	public MyTree(int value, int safe)
	{
		this.value = value;
		this.safe = safe;
		leftChild = null;
		rightChild = null;
	}

	public void insert (int newItem, int safe)
    {
		root = insertItem (root, newItem, safe);
	}
	
	public MyTree insertItem(MyTree tNode, int newItem, int safe)
	{

		if(tNode==null)
		{
			tNode = new MyTree(newItem, safe);
		}
		else
		{
			if( (root.getLeft() == null) && (newItem != -1) && (count%2==0))
			{
				root.setLeft(new MyTree (newItem, safe));
			}
			else if ( (root.getRight() == null) && (newItem != -1) && (count%2==1))
			{
				root.setRight(new MyTree (newItem, safe));
			}
		}

		return tNode;
	}


	int treeItem = 0;
	public int retrieve (int searchKey) //to check the country (safe or not safe)
	{
		
		return retrieveItem(root, searchKey);
	}

	
	protected int retrieveItem(MyTree tNode, int searchKey)
	{
	
		if (tNode != null)
		{
			if (tNode.value == searchKey)
			{
				treeItem = tNode.safe;
			}
			else
			{
				treeItem = retrieveItem(tNode.getLeft(), searchKey);
				treeItem = retrieveItem(tNode.getRight(), searchKey);
			}



		}
		return treeItem;
	}
	public int getValue()
	{
		return value;
	}

	public MyTree getLeft()
	{
		return leftChild;
	}

	public MyTree getRight()
	{
		return rightChild;
	}
	
	public void setLeft(MyTree left)
	{
		leftChild = left;
	}
	
	public void setRight(MyTree right)
	{
		rightChild = right;
	}
















	
	
	
	// fill in your ADT methods here
    // ...
}
