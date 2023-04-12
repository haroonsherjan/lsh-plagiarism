/** Class for a tree node
 */
class IntNode 
{
    private int item;
	private IntNode left;
	private IntNode right;

	public IntNode(int x)
	{
		item = x;
		left = null;
		right = null;
	}

	public void setItem(int x)
	{
		item = x;
	}

	public int getItem()
	{
		return item;
	}

	public void setLeft(IntNode n)
	{
		left = n;
	}

	public IntNode getLeft()
	{
		return left;
	}

	public void setRight(IntNode n)
	{
		right = n;
	}

	public IntNode getRight()
	{
		return right;
	}
	
	// Checks if the tree has a child
	public boolean noChild()
	{
		return left == null && right == null;
	}
}

/** Class for a binary tree ADT
 */
public class MyTree 
{
	private IntNode root;

	public MyTree()
	{
		root = null;
	}

	public IntNode getRoot()
	{
		return root;
	}

	public void setRoot(int x)
	{
		root.setItem(x);
	}

	/*
	public boolean isEmpty()
	{
		return root == null;
    }*/

	// attaches int to the left
	public void attachLeft(int item)
	{
		if (root.getLeft() == null)
			root.setLeft(new IntNode(item));
	}// end attachLeft method

	// attaches int to the right
	public void attachRight(int item)
	{
		if (root.getRight() == null)
			root.setRight(new IntNode(item));
	}// end attachRight method
	
	
	public void insertLeft(int x)
	{
		if (root == null)
		{
			root = new IntNode(0);
		}

		else
		{
			IntNode curr = root;
			curr.setLeft(new IntNode(x));
		} // end else
	} // end insertLeft method

	public void insertRight(int x)
	{
		if (root == null)
			root = new IntNode(0);

		else
		{
			IntNode curr = root;
			curr.setRight(new IntNode(x));
		}// end else
	}// end insertRight method

	public void insert(int x)
	{
		if (root == null)
			root = new IntNode(x);

		else
		{
			IntNode curr = root;

			while ((x < curr.getItem() && curr.getLeft() != null)
				   || (x < curr.getItem() && curr.getRight() != null))
			{
				if (x < curr.getItem())
					curr = curr.getLeft();
				else 
					curr = curr.getRight();
			}

			if (x < curr.getItem())
				curr.setLeft(new IntNode(x));
			else
				curr.setRight(new IntNode(x));
		}
	} // end insert method

	public String relationship(int A, int B)
	{
		//shows relationship between A and B
		/*
		if ( A is the ancestor of B)
			return "ANCESTOR";
		else if ( A is the left sibling of B)
			return "LEFT SIBLING";
		else if ( A is the right sibling of B)
			return "RIGHT SIBLING";
		else if ( A is the descendant of B)
			return "DESCENDANT"
		else
			return "NONE";*/
			return "NONE";
	}
}

