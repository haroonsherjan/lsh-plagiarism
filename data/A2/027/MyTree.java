/** Class for a tree node
 */
class MyNode
{
	// You may use this class if you'd like.  It may help you if you use
	// an array based implementation of a binary tree

	// you can add other variables if you'd like
	// int leftChildIndex;			  // left child index in array
	// int rightChildIndex;		  // right child index in array

	private int item;
	private MyNode leftChild;
	private MyNode rightChild;

	// initialize with item and no children
	public MyNode(int newItem)
	{
		item = newItem;
		leftChild = null;
		rightChild = null;
	}

	// initialize mynode with item and left, right children
	public MyNode(int newItem, MyNode left, MyNode right)
	{
		item = newItem;
		leftChild = left;
		rightChild = right;
	}

	// returns the item
	public int getItem()
	{
		return item;
	}

	// sets the item
	public void setItem(int newItem)
	{
		item = newItem;
	}

	// get the left child
	public MyNode getLeft()
	{
		return leftChild;
	}

	// get the right child
	public MyNode getRight()
	{
		return rightChild;
	}

	// set the left child
	public void setLeft(MyNode left)
	{
		leftChild = left;
	}

	// set the right child
	public void setRight(MyNode right)
	{
		rightChild = right;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree extends MyTreeBasis
{
	// You may want to use an array based implementation for 
	// your tree, or change this to another implementation

	// Note that this code and the driver code do not necessarily
	// match well -- you decide how you want these two parts to work
	// together.

	// default constructor
	public MyTree()
	{
	}

	public MyTree(int rootItem)
	{
		super(rootItem);
	}

	public MyTree(int rootItem, MyTree leftTree, MyTree rightTree)
	{
		root = new MyNode(rootItem, null, null);
		attachLeftSubtree(leftTree);
		attachRightSubtree(rightTree);
	}

	public void attachLeft(int newItem)
	{
		if (!isEmpty() && root.getLeft() == null)
		{
			root.setLeft(new MyNode(newItem, null, null));
		}
	}

	public void attachRight(int newItem)
	{
		if (!isEmpty() && root.getRight() == null)
		{
			root.setRight(new MyNode(newItem, null, null));
		}
	}

	public void attachLeftSubtree(MyTree leftTree) throws TreeException
	{
		if (!isEmpty())
		{
			throw new TreeException("TreeException: Empty tree");
		}
		else if (root.getLeft() != null)
		{
			throw new TreeException("TreeException: " + "Cannot overwrite left subtree");
		}
		else
		{
			root.setLeft(leftTree.root);
			leftTree.makeEmpty();
		}
	}

	public void attachRightSubtree(MyTree rightTree) throws TreeException
	{
		if (!isEmpty())
		{
			throw new TreeException("TreeException: Empty tree");
		}
		else if (root.getRight() != null)
		{
			throw new TreeException("TreeException: " + "Cannot overwrite right subtree");
		}
		else
		{
			root.setRight(rightTree.root);
			rightTree.makeEmpty();
		}
	}
}

class MyTreeBasis
{
	protected MyNode root;

	public MyTreeBasis()
	{
		root = null;
	}

	public MyTreeBasis(int rootItem)
	{
		root = new MyNode(rootItem, null, null);
	}

	public boolean isEmpty()
	{
		return root == null;
	}

	public void makeEmpty()
	{
		root = null;
	}

	public int getRootItem() throws TreeException
	{
		if (root == null)
		{
			throw new TreeException("TreeException: Empty tree");
		}
		else
		{
			return root.getItem();
		}
	}
}

class TreeException extends RuntimeException
{
	public TreeException(String s)
	{
		super(s);
	}
}
