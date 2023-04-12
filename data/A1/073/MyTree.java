/** Class for a tree node
 */
class TreeNode {
    // You may use this class if you'd like.  It may help you if you use
    // an array based implementation of a binary tree

    // you can add other variables if you'd like
   	private boolean isSafe;				  // is the city safe?
   	private TreeNode leftChild;
   	private TreeNode rightChild;
	private	int cityNum;

	public TreeNode()
	{
	}

	public TreeNode(int city)
	{
		cityNum = city;
		leftChild = null;
		rightChild = null;
	}

	public void setLeft(TreeNode left)
	{
		leftChild = left;
	}

	public void setRight(TreeNode right)
	{
		rightChild = right;
	}

	public void setSafe(int safety)
	{
		if (safety == 0)
		{
			isSafe = false;
		}
		else
		{
			isSafe = true;
		}
	}

	public boolean getSafe()
	{
		return isSafe;
	}

	public TreeNode getLeft()
	{
		return leftChild;
	}

	public TreeNode getRight()
	{
		return rightChild;
	}

	public int getCity()
	{
		return cityNum;
	}
	
}

/** Class for a binary tree ADT
 */
class MyTree {
    // You may want to use an array based implementation for 
    // your tree, or change this to another implementation

    // Note that this code and the driver code do not necessarily
    // match well -- you decide how you want these two parts to work
    // together.

    private TreeNode root;
	private TreeNode curr;
	private TreeNode finder;

	public MyTree()
	{
	}

	public MyTree(int start)
	{
		root = new TreeNode(start);
	}

	public TreeNode getRoot()
	{
		return root;
	}

	public TreeNode search(int x, TreeNode curr)
	{
		if (x == curr.getCity())
		{
			return curr;
		}
		else
		{
			if (curr.getLeft() != null)
			{	
				search (x, curr.getLeft());
			}
			if (curr.getRight() != null)
			{
				search(x, curr.getRight());
			}
		}
			return curr;
	}

	public void inorder(TreeNode node)
	{
		if (node != null)
		{
			inorder(node.getLeft());
			System.out.print(" " + node.getCity() + " ");
			inorder(node.getRight());
		}
	}
		
}
