/** Class for a tree node
 */
class MyNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
    //boolean isSafe;				  // is the city safe?
    //int leftChildIndex;			  // left child index in array
    //int rightChildIndex;		 // right child index in array
    
	private int item;
	private MyNode leftChild;
	private MyNode rightChild;
    // fill in your accessor and mutator methods here
    // ...
	public MyNode(int newItem)
	{
		item = newItem;
		leftChild = null;
		rightChild = null;
	}
    
	public MyNode(int newItem, MyNode left, MyNode right)
	{
		item = newItem;
		leftChild = left;
		rightChild = right;
	} 

	//public String status(MyNode node)
	//{
	//	if (node.item == 0)
	//	{
	//		return "NO";
	//	}
	//	else
	//	{
	//		return "YES";
	//	}
	//} // end String status

	public int getItem()
	{
		return item;
	}

	public void setItem(int newItem)
	{
		item = newItem;
	}

	public MyNode getLeft()
	{
		return leftChild;
	}

	public void setLeft(MyNode left)
	{
		leftChild = left;
	}

	public MyNode getRight()
	{
		return rightChild;
	}

	public void setRight(MyNode right)
	{
		rightChild = right;
	}
} // end MyNode class

abstract class BinaryTreeBasis
{
	protected MyNode root;

	public BinaryTreeBasis()
	{
		root = null;
	}

	public BinaryTreeBasis(int rootItem)
	{
		root = new MyNode(rootItem, null, null);
	}

	public boolean isEmpty()
	{
		return root==null;
	}

	public void makeEmpty()
	{
		root = null;
	}

	public int getRootItem()
	{
		//if (root!=null)
		//{
		//	//return root.getItem();
		//	return 1;
		//}
		return 1;
	}
} // end BinaryTreeBasis

/** Class for a binary tree ADT
 */
public class MyTree extends BinaryTreeBasis {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    //private final int MAX_NODES = 1000;
    //MyNode[] myTree = new MyNode[MAX_NODES];
    //int size = 0;	// make sure to update this variable as needed

    // fill in your ADT methods here
    // ...
    public MyTree()
	{
	} // end default constructor

	public MyTree(int rootItem)
	{
		super(rootItem);
	}

	public MyTree(int rootItem, MyTree leftTree, MyTree rightTree)
	{
		root = new MyNode(rootItem, null, null);
		//attachLeftSubTree(leftTree);
		//attachRightSubTree(rightTree);
	}

	public void setRootItem(int newItem)
	{
		if (root != null)
		{
			root.setItem(newItem);
		}
		else
		{
			root = new MyNode(newItem, null, null);
		}
	} //end setRootItem

	public void attachLeft(int newItem)
	{
		if (!isEmpty() && (root.getLeft() == null))
		{
			root.setLeft(new MyNode(newItem, null, null));
		}
	}

	public void attachRight(int newItem)
	{
		if (!isEmpty() && (root.getLeft() == null))
		{
			root.setRight(new MyNode(newItem, null, null));
		}
	}

    public void attachLeftSubtree(MyTree leftTree)
	{
		if (!isEmpty() && (root.getLeft() == null))
		{
			root.setLeft(leftTree.root);
			leftTree.makeEmpty();
		}
	}
 
    public void attachRightSubtree(MyTree rightTree)
	{
		if (!isEmpty() && (root.getRight() == null))
		{
			root.setRight(rightTree.root);
			rightTree.makeEmpty();
		}
	}

	protected MyTree(MyNode rootNode)
	{
		root = rootNode;
	}
} // end MyTree class
